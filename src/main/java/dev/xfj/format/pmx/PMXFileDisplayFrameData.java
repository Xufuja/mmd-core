package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;

public class PMXFileDisplayFrameData {
    private Byte frameType;
    private IndexType<?> frameData;

    public Byte getFrameType() {
        return frameType;
    }

    public void setFrameType(Byte frameType) {
        this.frameType = frameType;
    }

    public IndexType<?> getFrameData() {
        return frameData;
    }

    public void setFrameData(IndexType<?> frameData) {
        this.frameData = frameData;
    }
}
