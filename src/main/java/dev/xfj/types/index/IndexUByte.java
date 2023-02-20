package dev.xfj.types.index;

public final class IndexUByte implements IndexType<Integer> {
    private int value;

    public IndexUByte(int value) {
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
