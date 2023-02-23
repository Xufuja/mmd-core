package dev.xfj.writer;

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

public final class PMXWriter implements Writer {
    private final PMXFile pmxFile;
    private ByteBuffer byteBuffer;
    private int pmxFileSizeIn;
    private int pmxFileSizeOut;
    private Charset characterEncoding;

    public PMXWriter(PMXFile pmxFile) {
        this.pmxFile = pmxFile;
        this.pmxFileSizeIn = 0;
        this.pmxFileSizeOut = 0;
    }

    @Override
    public void write(boolean dryRun) throws IOException {
        this.characterEncoding = pmxFile.getGlobals().getTextEncoding() == 1 ? StandardCharsets.UTF_8 : StandardCharsets.UTF_16LE;
        pmxFileSizeIn += getSize(this.pmxFile);
        byteBuffer = ByteBuffer.allocate(pmxFileSizeIn);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        writeBytes(this.pmxFile);
        pmxFileSizeOut = byteBuffer.array().length;
        if (!dryRun) {
            Files.write(Path.of("test.pmx"), byteBuffer.array());
        } else {
            System.out.println("Dry run");
        }
    }

    private int getSize(Object object) {
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
                if (fieldValueClass.equals(Integer.class) || fieldValueClass.equals(IndexInt32.class)) {
                    size += Integer.BYTES;
                } else if (fieldValueClass.equals(Float.class)) {
                    size += Float.BYTES;
                } else if (fieldValueClass.equals(Short.class) || fieldValueClass.equals(IndexInt16.class) || fieldValueClass.equals(IndexUInt16.class)) {
                    size += Short.BYTES;
                } else if (fieldValueClass.equals(Byte.class) || fieldValueClass.equals(IndexByte.class) || fieldValueClass.equals(IndexUByte.class)) {
                    size += Byte.BYTES;
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
                            size += (((String) fieldValue).getBytes(characterEncoding).length + 4);
                        }
                    } else if (fieldValueClass.equals(ArrayList.class)) {
                        ArrayList<?> fieldValues = (ArrayList<?>) fieldValue;
                        if (!fieldValues.isEmpty()) {
                            for (Object value : fieldValues) {
                                if (value instanceof Integer || value instanceof IndexInt32) {
                                    if (fieldValueName.equals("flags")) { //Need to store the unsigned Byte as Integer
                                        size += Byte.BYTES;
                                    } else {
                                        size += Integer.BYTES;
                                    }
                                } else if (value instanceof Short) {
                                    size += Short.BYTES;
                                } else if (value instanceof Byte) {
                                    size += Byte.BYTES;
                                } else if (value instanceof Float) {
                                    size += Float.BYTES;
                                } else if (value instanceof String) {
                                    size += (((String) value).getBytes(characterEncoding).length + 4);
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

    private void writeBytes(Object object) {
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
                    byteBuffer.putInt((Integer) fieldValue);
                } else if (fieldValueClass.equals(IndexInt32.class)) {
                    byteBuffer.putInt(((IndexInt32) fieldValue).getValue());
                } else if (fieldValueClass.equals(Float.class)) {
                    byteBuffer.putFloat((Float) fieldValue);
                } else if (fieldValueClass.equals(Short.class)) {
                    byteBuffer.putShort((Short) fieldValue);
                } else if (fieldValueClass.equals(IndexInt16.class)) {
                    byteBuffer.putShort(((IndexInt16) fieldValue).getValue());
                } else if (fieldValueClass.equals(IndexUInt16.class)) {
                    byte[] byteArray = new byte[2];
                    byteArray[0] = (byte) (((IndexUInt16) fieldValue).getValue() & 0xFF);
                    byteArray[1] = (byte) ((((IndexUInt16) fieldValue).getValue() >> 8) & 0xFF);
                    byteBuffer.put(byteArray);
                } else if (fieldValueClass.equals(Byte.class)) {
                    byteBuffer.put((Byte) fieldValue);
                } else if (fieldValueClass.equals(IndexByte.class)) {
                    byteBuffer.put(((IndexByte) fieldValue).getValue());
                } else if (fieldValueClass.equals(IndexUByte.class)) {
                    byte[] byteArray = new byte[1];
                    byteArray[0] = (byte) (((IndexUByte) fieldValue).getValue() & 0xFF);
                    byteBuffer.put(byteArray);
                } else if (fieldValueClass.equals(Vec2.class)) {
                    byteBuffer.putFloat(((Vec2) fieldValue).getX());
                    byteBuffer.putFloat(((Vec2) fieldValue).getY());
                } else if (fieldValueClass.equals(Vec3.class)) {
                    byteBuffer.putFloat(((Vec3) fieldValue).getX());
                    byteBuffer.putFloat(((Vec3) fieldValue).getY());
                    byteBuffer.putFloat(((Vec3) fieldValue).getZ());
                } else if (fieldValueClass.equals(Vec4.class)) {
                    byteBuffer.putFloat(((Vec4) fieldValue).getX());
                    byteBuffer.putFloat(((Vec4) fieldValue).getY());
                    byteBuffer.putFloat(((Vec4) fieldValue).getZ());
                    byteBuffer.putFloat(((Vec4) fieldValue).getW());
                } else if (fieldValueClass.equals(PMXFile.class) || fieldValueClass.equals(PMXFileBone.class) || fieldValueClass.equals(PMXFileBoneLink.class) || fieldValueClass.equals(PMXFileDisplayFrame.class) || fieldValueClass.equals(PMXFileDisplayFrameData.class) || fieldValueClass.equals(PMXFileFlags.class) || fieldValueClass.equals(PMXFileGlobals.class) || fieldValueClass.equals(PMXFileJoint.class) || fieldValueClass.equals(PMXFileMaterial.class) || fieldValueClass.equals(PMXFileMorph.class) || fieldValueClass.equals(PMXFileMorphBone.class) || fieldValueClass.equals(PMXFileMorphFlip.class) || fieldValueClass.equals(PMXFileMorphGroup.class) || fieldValueClass.equals(PMXFileMorphImpulse.class) || fieldValueClass.equals(PMXFileMorphMaterial.class) || fieldValueClass.equals(PMXFileMorphType.class) || fieldValueClass.equals(PMXFileMorphUV.class) || fieldValueClass.equals(PMXFileMorphVertex.class) || fieldValueClass.equals(PMXFileRigidBody.class) || fieldValueClass.equals(PMXFileSoftBody.class) || fieldValueClass.equals(PMXFileSoftBodyAnchorRigidBody.class) || fieldValueClass.equals(PMXFileVertex.class) || fieldValueClass.equals(PMXFileVertexIndex.class)) {
                    //No idea why I cannot just stick this in the else case, but that errors out so here is a list of every single class in the package
                    writeBytes(fieldValue);
                } else {
                    if (fieldValueClass.equals(String.class)) {
                        if (fieldValueName.equals("signature")) {
                            byte[] bytes = new byte[4];
                            String tempSignature = (String) fieldValue;
                            byte[] stringBytes = tempSignature.getBytes(StandardCharsets.UTF_8); //Signature is always UTF8
                            System.arraycopy(stringBytes, 0, bytes, 0, stringBytes.length);
                            byteBuffer.put(bytes);
                        } else if (fieldValueName.contains("Japanese") || fieldValueName.contains("English") || fieldValueName.equals("metaData")) {
                            byte[] bytes = bytesFromString((String) fieldValue);
                            byteBuffer.putInt(bytes.length);
                            byteBuffer.put(bytes);
                        }
                    } else if (fieldValueClass.equals(ArrayList.class)) {
                        ArrayList<?> fieldValues = (ArrayList<?>) fieldValue;
                        if (!fieldValues.isEmpty()) {
                            for (Object value : fieldValues) {
                                if (value instanceof Integer) {
                                    if (fieldValueName.equals("flags")) { //Need to store the unsigned Byte as Integer
                                        byte[] byteArray = new byte[1];
                                        byteArray[0] = (byte) ((Integer) value & 0xFF);
                                        byteBuffer.put(byteArray);
                                    } else {
                                        byteBuffer.putInt((Integer) value);
                                    }
                                } else if (value instanceof Short) {
                                    byteBuffer.putShort((Short) value);
                                } else if (value instanceof Byte) {
                                    byteBuffer.put((Byte) value);
                                } else if (value instanceof Float) {
                                    byteBuffer.putFloat((Float) value);
                                } else if (value instanceof String) {
                                    byte[] bytes = bytesFromString((String) value);
                                    byteBuffer.putInt(bytes.length);
                                    byteBuffer.put(bytes);
                                } else {
                                    writeBytes(value);
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
    }

    private byte[] bytesFromString(String input) {
        return input.getBytes(characterEncoding);
    }

    public int getPmxFileSizeIn() {
        return pmxFileSizeIn;
    }

    public int getPmxFileSizeOut() {
        return pmxFileSizeOut;
    }
}
