package dev.xfj.parsing;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteHandler {
    private final byte[] bytes;

    public ByteHandler(byte[] bytes) {
        this.bytes = bytes;
    }
    public byte[] getByteRange(int start, int end) {
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
