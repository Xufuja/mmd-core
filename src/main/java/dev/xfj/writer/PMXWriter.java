package dev.xfj.writer;

import dev.xfj.format.pmm.*;
import dev.xfj.format.pmx.*;
import dev.xfj.types.index.*;
import dev.xfj.types.vec.Vec2;
import dev.xfj.types.vec.Vec3;
import dev.xfj.types.vec.Vec4;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static dev.xfj.parsing.PMMParser.*;
import static dev.xfj.parsing.PMMParser.NAME_LENGTH;

public final class PMXWriter implements Writer {
    private final PMXFile pmxFile;
    private ByteBuffer byteBuffer;
    private int pmxFileSizeIn;
    private int pmxFileSizeOut;
    private Charset characterEncoding;
    private PMXFileGlobals globals;

    public PMXWriter(PMXFile pmxFile) {
        this.pmxFile = pmxFile;
        this.pmxFileSizeIn = 0;
        this.pmxFileSizeOut = 0;
    }

    @Override
    public void write(boolean dryRun) throws IOException {
        this.globals = this.pmxFile.getGlobals();
        this.characterEncoding = pmxFile.getGlobals().getTextEncoding() == 1 ? StandardCharsets.UTF_8 : StandardCharsets.UTF_16LE;
        pmxFileSizeIn += getSize(this.pmxFile);
        byteBuffer = ByteBuffer.allocate(pmxFileSizeIn);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        /*writeBytes(this.pmmFile);
        pmxFileSizeOut = byteBuffer.array().length;
        if (!dryRun) {
            Files.write(Path.of("test.pmm"), byteBuffer.array());
        } else {
            System.out.println("Dry run");
        }*/
    }

    public int getSize(Object object) {
        String className = object.getClass().getName();
        int size = 0;
        for (Field field : object.getClass().getDeclaredFields()) {
            Object fieldValue;
            try {
                field.setAccessible(true);
                fieldValue = field.get(object);
            } catch (IllegalAccessException e) {
                continue;
            }
            if (fieldValue != null) {
                String fieldValueName = field.getName();
                //System.out.println(className + " " + fieldValueName);
                Class<?> fieldValueClass = fieldValue.getClass();
                if (fieldValueClass.equals(Integer.class)) {
                    size += Integer.BYTES;
                } else if (fieldValueClass.equals(Float.class)) {
                    size += Float.BYTES;
                } else if (fieldValueClass.equals(Short.class)) {
                    size += Short.BYTES;
                } else if (fieldValueClass.equals(Byte.class)) {
                    size += Byte.BYTES;
                } else if (fieldValueClass.equals(IndexByte.class)) {
                    size += Byte.BYTES;
                } else if (fieldValueClass.equals(IndexUByte.class)) {
                    size += Byte.BYTES;
                } else if (fieldValueClass.equals(IndexInt16.class)) {
                    size += Short.BYTES;
                } else if (fieldValueClass.equals(IndexUInt16.class)) {
                    size += Short.BYTES;
                } else if (fieldValueClass.equals(IndexInt32.class)) {
                    size += Integer.BYTES;
                } else if (fieldValueClass.equals(Vec2.class)) {
                    size += Float.BYTES * 2;
                } else if (fieldValueClass.equals(Vec3.class)) {
                    size += Float.BYTES * 3;
                } else if (fieldValueClass.equals(Vec4.class)) {
                    size += Float.BYTES * 4;
                } else if (fieldValueClass.equals(PMXFile.class) || fieldValueClass.equals(PMXFileBone.class) || fieldValueClass.equals(PMXFileBoneLink.class) || fieldValueClass.equals(PMXFileDisplayFrame.class) || fieldValueClass.equals(PMXFileDisplayFrameData.class) || fieldValueClass.equals(PMXFileFlags.class) || fieldValueClass.equals(PMXFileGlobals.class) || fieldValueClass.equals(PMXFileJoint.class) || fieldValueClass.equals(PMXFileMaterial.class) || fieldValueClass.equals(PMXFileMorph.class) || fieldValueClass.equals(PMXFileMorphBone.class) || fieldValueClass.equals(PMXFileMorphFlip.class) || fieldValueClass.equals(PMXFileMorphGroup.class) || fieldValueClass.equals(PMXFileMorphImpulse.class) || fieldValueClass.equals(PMXFileMorphMaterial.class) || fieldValueClass.equals(PMXFileMorphType.class) || fieldValueClass.equals(PMXFileMorphUV.class) || fieldValueClass.equals(PMXFileMorphVertex.class) || fieldValueClass.equals(PMXFileRigidBody.class) || fieldValueClass.equals(PMXFileSoftBody.class) || fieldValueClass.equals(PMXFileSoftBodyAnchorRigidBody.class) || fieldValueClass.equals(PMXFileVertex.class) || fieldValueClass.equals(PMXFileVertexIndex.class)) {
                    //No idea why I cannot just stick this in the else case, but that errors out so here is a list of every single class in the package
                    size += getSize(fieldValue);
                } else {
                    if (fieldValueClass.equals(String.class)) {
                        if (fieldValueName.equals("signature")) {
                            size += 4;
                        } else if (fieldValueName.contains("Japanese") || fieldValueName.contains("English") || fieldValueName.equals("metaData")) {
                            size += (((String) fieldValue).getBytes(characterEncoding).length + 1);
                        }
                    } else if (fieldValueClass.equals(ArrayList.class)) {
                        ArrayList<?> fieldValues = (ArrayList<?>) fieldValue;
                        if (!fieldValues.isEmpty()) {
                            for (Object value : fieldValues) {
                                if (value instanceof Integer) {
                                    size += Integer.BYTES;
                                } else if (value instanceof Byte) {
                                    size += Byte.BYTES;
                                } else if (value instanceof Float) {
                                    size += Float.BYTES;
                                } else if (value instanceof String) {
                                    size += (((String) value).getBytes(characterEncoding).length + 1);
                                } else {
                                    size += getSize(value);
                                }
                            }
                        }
                    } else {
                        if (!fieldValueClass.getName().contains("EmptyList")) {
                            System.out.println(String.format("Missing handler for class: %1$s, field: %1$s", fieldValueClass, fieldValueName));
                        }
                    }
                }
            }
        }
        //System.out.println(className + " "  + size);
        return size;
    }

    public int getPmxFileSizeIn() {
        return pmxFileSizeIn;
    }

    public void setPmxFileSizeIn(int pmxFileSizeIn) {
        this.pmxFileSizeIn = pmxFileSizeIn;
    }

    public int getPmxFileSizeOut() {
        return pmxFileSizeOut;
    }

    public void setPmxFileSizeOut(int pmxFileSizeOut) {
        this.pmxFileSizeOut = pmxFileSizeOut;
    }
}
