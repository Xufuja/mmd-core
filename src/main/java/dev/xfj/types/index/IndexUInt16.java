package dev.xfj.types.index;

public final class IndexUInt16 implements IndexType<Integer> {
    private int value;

    public IndexUInt16(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void setValue(Integer value) {
        this.value = value;
    }
}
