package dev.xfj.writer;

import dev.xfj.format.pmm.*;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static dev.xfj.parsing.PMMParser.*;

public class PMMWriter {
    PMMFile pmmFile;

    public PMMWriter(PMMFile pmmFile) {
        this.pmmFile = pmmFile;
    }

    public void write() {
        int size = 0;
        size += getSize(this.pmmFile);
        System.out.println(String.format("Allocating %1$s bytes", size));
        ByteBuffer byteBuffer = ByteBuffer.allocate(size);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);

    }

    //Tried to make it as generic as possible for maintainability but still ended with several exceptions
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
                    case "modelNameJapanese", "modelNameEnglish" -> size += (((String) fieldValue).getBytes(Charset.forName("Shift-JIS")).length + 1);
                    case "accessoryName" -> size += NAME_LENGTH;
                }
            } else if (fieldValueClass.equals(ArrayList.class)) {
                ArrayList<?> list = (ArrayList<?>) fieldValue;
                if (!list.isEmpty()) {
                    for (Object item : list) {
                        if (item instanceof Integer) {
                            size += Integer.BYTES;
                        } else if (item instanceof Byte) {
                            size += Byte.BYTES;
                        } else if (item instanceof Float) {
                            size += Float.BYTES;
                        } else if (item instanceof String) {
                            if (fieldValueName.equals("accessoryNames")) {
                                size += NAME_LENGTH;
                            } else {
                                size += (((String) item).getBytes(Charset.forName("Shift-JIS")).length + 1);
                            }
                        } else {
                            size += getSize(item);
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
}