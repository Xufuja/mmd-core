package dev.xfj.writer;

import dev.xfj.format.pmm.PMMFile;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

public class PMMWriter {
    PMMFile pmmFile;

    public PMMWriter(PMMFile pmmFile) {
        this.pmmFile = pmmFile;
    }

    public void write() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(getSize(this.pmmFile));

    }

    public int getSize(Object object) {
        System.out.println(object.getClass().getName());
        int size = 0;
        for (Field field : object.getClass().getDeclaredFields()) {
            Object fieldValue;
            try {
                field.setAccessible(true);
                fieldValue = field.get(object);
            } catch (IllegalAccessException e) {
                continue;
            }
            System.out.println(field.getName());
            Class<?> clazz = fieldValue.getClass();
            if (clazz.equals(Integer.class) || clazz.equals(Float.class)) {
                size += 4;
            } else if (clazz.equals(Byte.class)) {
                size += 1;
            }
        }
        System.out.println(size);
        return size;
    }
}
