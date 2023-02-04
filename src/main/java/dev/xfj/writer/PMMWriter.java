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
            String fieldName = field.getName();
            //System.out.println(className + " " + fieldName);
            Class<?> clazz = fieldValue.getClass();
            if (clazz.equals(Integer.class)) {
                size += Integer.BYTES;
            } else if (clazz.equals(Float.class)) {
                size += Float.BYTES;
            } else if (clazz.equals(Byte.class)) {
                size += Byte.BYTES;
            } else if (clazz.equals(PMMFile.class) || clazz.equals(PMMFileAccessory.class) || clazz.equals(PMMFileAccessoryData.class) || clazz.equals(PMMFileAccessoryKeyframe.class) || clazz.equals(PMMFileAccessoryKeyframeWithIndex.class) || clazz.equals(PMMFileCamera.class) || clazz.equals(PMMFileCameraKeyframe.class) || clazz.equals(PMMFileCameraKeyframeWithIndex.class) || clazz.equals(PMMFileGravity.class) || clazz.equals(PMMFileGravityKeyframe.class) || clazz.equals(PMMFileGravityKeyframeWithIndex.class) || clazz.equals(PMMFileKeyframeInterpolation.class) || clazz.equals(PMMFileLighting.class) || clazz.equals(PMMFileLightingData.class) || clazz.equals(PMMFileLightingKeyframe.class) || clazz.equals(PMMFileLightingKeyframeWithIndex.class) || clazz.equals(PMMFileModel.class) || clazz.equals(PMMFileModelBone.class) || clazz.equals(PMMFileModelKeyframe.class) || clazz.equals(PMMFileModelKeyframeConfiguration.class) || clazz.equals(PMMFileModelKeyframeConfigurationRelation.class) || clazz.equals(PMMFileModelKeyframeConfigurationRelationCurrent.class) || clazz.equals(PMMFileModelKeyframeConfigurationWithIndex.class) || clazz.equals(PMMFileModelKeyframeWithIndex.class) || clazz.equals(PMMFileModelMorphKeyframe.class) || clazz.equals(PMMFileModelMorphKeyframeWithIndex.class) || clazz.equals(PMMFileSelectorChoice.class) || clazz.equals(PMMFileSelfShadow.class) || clazz.equals(PMMFileSelfShadowKeyframe.class) || clazz.equals(PMMFileSelfShadowKeyframeWithIndex.class)) {
                //No idea why I cannot just stick this in the else case, but that errors out so here is a list of every single class in the package
                size += getSize(fieldValue);
            } else if (clazz.equals(String.class)) {
                switch (className) {
                    case "dev.xfj.format.pmm.PMMFile" -> {
                        switch (fieldName) {
                            case "version" -> size += FILE_FORMAT_VERSION_LENGTH;
                            case "waveFileName", "aviFileName", "backgroundImageFileName" -> size += FILE_NAME_LENGTH;
                        }
                    }
                    case "dev.xfj.format.pmm.PMMFileModel" -> {
                        switch (fieldName) {
                            case "modelFilePath" -> size += FILE_PATH_LENGTH;
                            case "modelNameJapanese", "modelNameEnglish" ->
                                    size += (((String) fieldValue).getBytes(Charset.forName("Shift-JIS")).length + 1);
                        }
                    }
                    case "dev.xfj.format.pmm.PMMFileAccessory" -> {
                        switch (fieldName) {
                            case "accessoryName" -> size += NAME_LENGTH;
                            case "accessoryFilePath" -> size += FILE_PATH_LENGTH;
                        }
                    }
                }
            } else if (clazz.equals(ArrayList.class)) {
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
                            if (fieldName.equals("accessoryNames")) {
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
                if (!clazz.getName().contains("EmptyList")) {
                    System.out.println(String.format("Missing handler for class: %1$s, field: %1$s", className, fieldName));
                }
            }
        }
        //System.out.println(className + " "  + size);
        return size;
    }
}