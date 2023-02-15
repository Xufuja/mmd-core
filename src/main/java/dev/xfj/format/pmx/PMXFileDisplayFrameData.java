package dev.xfj.format.pmx;

public class PMXFileDisplayFrameData {
    private byte frameType;
    private Object frameData;

    public byte getFrameType() {
        return frameType;
    }

    public void setFrameType(byte frameType) {
        this.frameType = frameType;
    }

    public Object getFrameData() {
        return frameData;
    }

    public void setFrameData(Object frameData) {
        this.frameData = frameData;
    }
}
