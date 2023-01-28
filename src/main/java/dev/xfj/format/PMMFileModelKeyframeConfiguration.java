package dev.xfj.format;

public class PMMFileModelKeyframeConfiguration {
    private int keyframePosition;
    private int previousIndex;
    private int nextIndex;
    private byte visible;

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

    public byte getVisible() {
        return visible;
    }

    public void setVisible(byte visible) {
        this.visible = visible;
    }
}
