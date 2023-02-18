package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;

public class PMXFileDisplayFrameData {
    private byte frameType;
    private IndexType frameData;

    public byte getFrameType() {
        return frameType;
    }

    public void setFrameType(byte frameType) {
        this.frameType = frameType;
    }

    public IndexType getFrameData() {
        return frameData;
    }

    public void setFrameData(IndexType frameData) {
        this.frameData = frameData;
    }
}
