package dev.xfj.writer;

import dev.xfj.format.pmm.PMMFile;
import dev.xfj.format.pmm.PMMFileAccessory;
import dev.xfj.format.pmm.PMMFileModel;
import dev.xfj.format.pmm.PMMFileSelectorChoice;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import static dev.xfj.parsing.PMMParser.*;

public class PMMWriter {
    PMMFile pmmFile;

    public PMMWriter(PMMFile pmmFile) {
        this.pmmFile = pmmFile;
    }

    public void write() {
        int size = 0;
        size += getSize(this.pmmFile);
        System.out.println(size);
        ByteBuffer byteBuffer = ByteBuffer.allocate(size);

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
            String fieldName = field.getName();
            System.out.println(className + " " + fieldName);
            Class<?> clazz = fieldValue.getClass();
            if (clazz.equals(Integer.class)) {
                size += Integer.BYTES;
            } else if (clazz.equals(Float.class)) {
                size += Float.BYTES;
            } else if (clazz.equals(Byte.class)) {
                size += Byte.BYTES;
            } else if (clazz.equals(String.class)) {
                switch (className) {
                    case "dev.xfj.format.pmm.PMMFile" -> {
                        switch (fieldName) {
                            case "version" -> size += FILE_FORMAT_VERSION_LENGTH;
                            case "accessoryNames" -> size += NAME_LENGTH;
                            case "waveFileName", "aviFileName", "backgroundImageFileName" -> size += FILE_NAME_LENGTH;
                        }
                    }
                    case "dev.xfj.format.pmm.PMMFileModel" -> {
                        switch (fieldName) {
                            case "modelFilePath" -> size += FILE_PATH_LENGTH;
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
                for (Object item : list) {
                    if (item instanceof PMMFileModel) {
                        size += getSize(item);
                    } else if (item instanceof PMMFileAccessory) {
                        size += getSize(item);
                    } else if (item instanceof PMMFileSelectorChoice) {
                        size += getSize(item);
                    }
                }
            }
        }
        System.out.println(size);
        return size;
    }
}