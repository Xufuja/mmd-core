package dev.xfj.types.index;

public class IndexByte implements IndexType {
    private byte indexByte;

    public IndexByte(byte indexByte) {
        this.indexByte = indexByte;
    }

    public byte getIndexByte() {
        return indexByte;
    }

    public void setIndexByte(byte indexByte) {
        this.indexByte = indexByte;
    }
}
