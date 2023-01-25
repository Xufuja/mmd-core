package dev.xfj.parsing;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteHandler {
    private final byte[] bytes;

    public ByteHandler(byte[] bytes) {
        this.bytes = bytes;
    }
    public byte[] getByteRange(int start, int length) {
        int end = start + length;
        byte[] result = new byte[length];
        for (int i = start; i < end; i++) {
            /*if (bytes[i] == 0) {
                break;
            }*/
            int resultIndex = i - start;
            result[resultIndex] = bytes[i];
            System.out.println(result[resultIndex]);
        }
        System.out.println("End of Byte Range");
        return result;
    }
    public byte[] getStringFromBytes(int start) {
        int end = bytes[start];
        System.out.println("Length: " + end);
        start++;
        end = end + start;
        byte[] result = new byte[end - start];
        for (int i = start; i < end; i++) {
            /*if (bytes[i] == 0) {
                break;
            }*/
            int resultIndex = i - start;
            result[resultIndex] = bytes[i];
            System.out.println(result[resultIndex]);
        }
        System.out.println("End of Byte Range");
        return result;
    }
    public ByteBuffer getLittleEndianBuffer(byte[] input) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(input);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return byteBuffer;
    }

    public byte[] getBytes() {
        return bytes;
    }
}
