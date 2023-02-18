package dev.xfj.types.index;

public class IndexByte implements IndexType<Byte> {
    private byte value;

    public IndexByte(byte value) {
        this.value = value;
    }

    @Override
    public Byte getValue() {
        return value;
    }

    @Override
    public void setValue(Byte value) {
        this.value = value;
    }
}
