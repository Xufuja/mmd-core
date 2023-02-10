package dev.xfj.parsing;

import dev.xfj.vec.Vec2;
import dev.xfj.vec.Vec3;
import dev.xfj.vec.Vec4;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class Parser {
    protected final byte[] bytes;
    protected final ByteBuffer byteBuffer;
    protected int offset;

    public Parser(Path path) throws IOException {
        this.bytes = Files.readAllBytes(path);
        this.byteBuffer = ByteBuffer.wrap(bytes);
        this.byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.offset = 0;
    }

    public byte getByte() {
        byte result = byteBuffer.get(offset);
        this.offset += 1;
        return result;
    }

    public short getShort() {
        short result = byteBuffer.getShort(offset);
        this.offset += 2;
        return result;
    }

    public int getInt() {
        int result = byteBuffer.getInt(offset);
        this.offset += 4;
        return result;
    }

    public float getFloat() {
        float result = byteBuffer.getFloat(offset);
        this.offset += 4;
        return result;
    }

    public Vec2 getVec2() {
        return new Vec2(getFloat(), getFloat());
    }

    public Vec3 getVec3() {
        return new Vec3(getFloat(), getFloat(), getFloat());
    }

    public Vec4 getVec4() {
        return new Vec4(getFloat(), getFloat(), getFloat(), getFloat());
    }
}