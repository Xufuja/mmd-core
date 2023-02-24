package dev.xfj.writer;

import dev.xfj.format.pmm.*;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static dev.xfj.parsing.PMMParser.*;

public final class PMMWriter implements Writer{
    private final PMMFile pmmFile;
    private ByteBuffer byteBuffer;
    private int pmmFileSizeIn;
    private int pmmFileSizeOut;
    private final boolean dryRun;

    public PMMWriter(PMMFile pmmFile, boolean dryRun) {
        this.pmmFile = pmmFile;
        this.pmmFileSizeIn = 0;
        this.pmmFileSizeOut = 0;
        this.dryRun = dryRun;
    }

    @Override
    public void write(Path path) throws IOException {
        pmmFileSizeIn += getSize(this.pmmFile);
        byteBuffer = ByteBuffer.allocate(pmmFileSizeIn);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        writeBytes(this.pmmFile);
        pmmFileSizeOut = byteBuffer.array().length;
        if (!dryRun) {
            Files.write(path, byteBuffer.array());
        } else {
            System.out.println("Dry run");
        }
    }

    //Tried to make it as generic as possible for maintainability but still ended with several exceptions
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
            String fieldValueName = field.getName();
            //System.out.println(className + " " + fieldValueName);
            Class<?> fieldValueClass = fieldValue.getClass();
            if (fieldValueClass.equals(Integer.class)) {
                size += Integer.BYTES;
            } else if (fieldValueClass.equals(Float.class)) {
                size += Float.BYTES;
            } else if (fieldValueClass.equals(Byte.class)) {
                size += Byte.BYTES;
            } else if (fieldValueClass.equals(PMMFile.class) || fieldValueClass.equals(PMMFileAccessory.class) || fieldValueClass.equals(PMMFileAccessoryData.class) || fieldValueClass.equals(PMMFileAccessoryKeyframe.class) || fieldValueClass.equals(PMMFileAccessoryKeyframeWithIndex.class) || fieldValueClass.equals(PMMFileCamera.class) || fieldValueClass.equals(PMMFileCameraKeyframe.class) || fieldValueClass.equals(PMMFileCameraKeyframeWithIndex.class) || fieldValueClass.equals(PMMFileGravity.class) || fieldValueClass.equals(PMMFileGravityKeyframe.class) || fieldValueClass.equals(PMMFileGravityKeyframeWithIndex.class) || fieldValueClass.equals(PMMFileKeyframeInterpolation.class) || fieldValueClass.equals(PMMFileLighting.class) || fieldValueClass.equals(PMMFileLightingData.class) || fieldValueClass.equals(PMMFileLightingKeyframe.class) || fieldValueClass.equals(PMMFileLightingKeyframeWithIndex.class) || fieldValueClass.equals(PMMFileModel.class) || fieldValueClass.equals(PMMFileModelBone.class) || fieldValueClass.equals(PMMFileModelKeyframe.class) || fieldValueClass.equals(PMMFileModelKeyframeConfiguration.class) || fieldValueClass.equals(PMMFileModelKeyframeConfigurationRelation.class) || fieldValueClass.equals(PMMFileModelKeyframeConfigurationRelationCurrent.class) || fieldValueClass.equals(PMMFileModelKeyframeConfigurationWithIndex.class) || fieldValueClass.equals(PMMFileModelKeyframeWithIndex.class) || fieldValueClass.equals(PMMFileModelMorphKeyframe.class) || fieldValueClass.equals(PMMFileModelMorphKeyframeWithIndex.class) || fieldValueClass.equals(PMMFileSelectorChoice.class) || fieldValueClass.equals(PMMFileSelfShadow.class) || fieldValueClass.equals(PMMFileSelfShadowKeyframe.class) || fieldValueClass.equals(PMMFileSelfShadowKeyframeWithIndex.class)) {
                //No idea why I cannot just stick this in the else case, but that errors out so here is a list of every single class in the package
                size += getSize(fieldValue);
            } else if (fieldValueClass.equals(String.class)) {
                switch (fieldValueName) {
                    case "version" -> size += FILE_FORMAT_VERSION_LENGTH;
                    case "waveFileName", "aviFileName", "backgroundImageFileName" -> size += FILE_NAME_LENGTH;
                    case "modelFilePath", "accessoryFilePath" -> size += FILE_PATH_LENGTH;
                    case "modelNameJapanese", "modelNameEnglish" ->
                            size += (((String) fieldValue).getBytes(Charset.forName("Shift-JIS")).length + 1);
                    case "accessoryName" -> size += NAME_LENGTH;
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
                            if (fieldValueName.equals("accessoryNames")) {
                                size += NAME_LENGTH;
                            } else {
                                size += (((String) value).getBytes(Charset.forName("Shift-JIS")).length + 1);
                            }
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
        //System.out.println(className + " "  + size);
        return size;
    }

    private void writeBytes(Object object) {
        String className = object.getClass().getName();
        for (Field field : object.getClass().getDeclaredFields()) {
            Object fieldValue;
            try {
                field.setAccessible(true);
                fieldValue = field.get(object);
            } catch (IllegalAccessException e) {
                continue;
            }
            String fieldValueName = field.getName();
            //System.out.println(className + " " + fieldValueName);
            Class<?> fieldValueClass = fieldValue.getClass();
            if (fieldValueClass.equals(Integer.class)) {
                byteBuffer.putInt((Integer) fieldValue);
            } else if (fieldValueClass.equals(Float.class)) {
                byteBuffer.putFloat((Float) fieldValue);
            } else if (fieldValueClass.equals(Byte.class)) {
                byteBuffer.put((Byte) fieldValue);
            } else if (fieldValueClass.equals(PMMFile.class) || fieldValueClass.equals(PMMFileAccessory.class) || fieldValueClass.equals(PMMFileAccessoryData.class) || fieldValueClass.equals(PMMFileAccessoryKeyframe.class) || fieldValueClass.equals(PMMFileAccessoryKeyframeWithIndex.class) || fieldValueClass.equals(PMMFileCamera.class) || fieldValueClass.equals(PMMFileCameraKeyframe.class) || fieldValueClass.equals(PMMFileCameraKeyframeWithIndex.class) || fieldValueClass.equals(PMMFileGravity.class) || fieldValueClass.equals(PMMFileGravityKeyframe.class) || fieldValueClass.equals(PMMFileGravityKeyframeWithIndex.class) || fieldValueClass.equals(PMMFileKeyframeInterpolation.class) || fieldValueClass.equals(PMMFileLighting.class) || fieldValueClass.equals(PMMFileLightingData.class) || fieldValueClass.equals(PMMFileLightingKeyframe.class) || fieldValueClass.equals(PMMFileLightingKeyframeWithIndex.class) || fieldValueClass.equals(PMMFileModel.class) || fieldValueClass.equals(PMMFileModelBone.class) || fieldValueClass.equals(PMMFileModelKeyframe.class) || fieldValueClass.equals(PMMFileModelKeyframeConfiguration.class) || fieldValueClass.equals(PMMFileModelKeyframeConfigurationRelation.class) || fieldValueClass.equals(PMMFileModelKeyframeConfigurationRelationCurrent.class) || fieldValueClass.equals(PMMFileModelKeyframeConfigurationWithIndex.class) || fieldValueClass.equals(PMMFileModelKeyframeWithIndex.class) || fieldValueClass.equals(PMMFileModelMorphKeyframe.class) || fieldValueClass.equals(PMMFileModelMorphKeyframeWithIndex.class) || fieldValueClass.equals(PMMFileSelectorChoice.class) || fieldValueClass.equals(PMMFileSelfShadow.class) || fieldValueClass.equals(PMMFileSelfShadowKeyframe.class) || fieldValueClass.equals(PMMFileSelfShadowKeyframeWithIndex.class)) {
                //No idea why I cannot just stick this in the else case, but that errors out so here is a list of every single class in the package
                writeBytes(fieldValue);
            } else if (fieldValueClass.equals(String.class)) {
                switch (fieldValueName) {
                    case "version" -> {
                        byte[] bytes = new byte[FILE_FORMAT_VERSION_LENGTH];
                        byte[] stringBytes = bytesFromString((String) fieldValue);
                        System.arraycopy(stringBytes, 0, bytes, 0, stringBytes.length);
                        byteBuffer.put(bytes);
                    }
                    case "waveFileName", "aviFileName", "backgroundImageFileName" -> {
                        byte[] bytes = new byte[FILE_NAME_LENGTH];
                        byte[] stringBytes = bytesFromString((String) fieldValue);
                        System.arraycopy(stringBytes, 0, bytes, 0, stringBytes.length);
                        byteBuffer.put(bytes);
                    }
                    case "modelFilePath", "accessoryFilePath" -> {
                        byte[] bytes = new byte[FILE_PATH_LENGTH];
                        byte[] stringBytes = bytesFromString((String) fieldValue);
                        System.arraycopy(stringBytes, 0, bytes, 0, stringBytes.length);
                        byteBuffer.put(bytes);
                    }
                    case "modelNameJapanese", "modelNameEnglish" -> {
                        byte[] bytes = bytesFromString((String) fieldValue);
                        byteBuffer.put((byte) bytes.length);
                        byteBuffer.put(bytes);
                    }
                    case "accessoryName" -> {
                        byte[] bytes = new byte[NAME_LENGTH];
                        byte[] stringBytes = bytesFromString((String) fieldValue);
                        System.arraycopy(stringBytes, 0, bytes, 0, stringBytes.length);
                        byteBuffer.put(bytes);
                    }
                }
            } else if (fieldValueClass.equals(ArrayList.class)) {
                ArrayList<?> fieldValues = (ArrayList<?>) fieldValue;
                if (!fieldValues.isEmpty()) {
                    for (Object value : fieldValues) {
                        if (value instanceof Integer) {
                            byteBuffer.putInt((Integer) value);
                        } else if (value instanceof Byte) {
                            byteBuffer.put((Byte) value);
                        } else if (value instanceof Float) {
                            byteBuffer.putFloat((Float) value);
                        } else if (value instanceof String) {
                            if (fieldValueName.equals("accessoryNames")) {
                                byte[] bytes = new byte[NAME_LENGTH];
                                byte[] stringBytes = bytesFromString((String) value);
                                System.arraycopy(stringBytes, 0, bytes, 0, stringBytes.length);
                                byteBuffer.put(bytes);
                            } else {
                                byte[] bytes = bytesFromString((String) value);
                                byteBuffer.put((byte) bytes.length);
                                byteBuffer.put(bytes);
                            }
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
        //System.out.println(className + " "  + size);
    }
    private byte[] bytesFromString(String input) {
        return input.getBytes(Charset.forName("Shift-JIS"));
    }

    public int getPmmFileSizeIn() {
        return pmmFileSizeIn;
    }

    public int getPmmFileSizeOut() {
        return pmmFileSizeOut;
    }
}