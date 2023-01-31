package dev.xfj.format;

public class PMMFileAccessoryKeyframe {
    private int keyframePosition;
    private int previousIndex;
    private int nextIndex;
    private PMMFileAccessoryData accessoryData;
    private byte selected;

    public int getKeyframePosition() {
        return keyframePosition;
    }

    public void setKeyframePosition(int keyframePosition) {
        this.keyframePosition = keyframePosition;
    }

    public int getPreviousIndex() {
        return previousIndex;
    }

    public void setPreviousIndex(int previousIndex) {
        this.previousIndex = previousIndex;
    }

    public int getNextIndex() {
        return nextIndex;
    }

    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }

    public PMMFileAccessoryData getAccessoryData() {
        return accessoryData;
    }

    public void setAccessoryData(PMMFileAccessoryData accessoryData) {
        this.accessoryData = accessoryData;
    }

    public byte getSelected() {
        return selected;
    }

    public void setSelected(byte selected) {
        this.selected = selected;
    }
}
