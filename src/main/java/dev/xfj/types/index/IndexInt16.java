package dev.xfj.types.index;

public class IndexInt16 implements IndexType<Short> {
    private short value;

    public IndexInt16(short value) {
        this.value = value;
    }

    @Override
    public Short getValue() {
        return value;
    }

    @Override
    public void setValue(Short value) {
        this.value = value;
    }
}
