package dev.xfj.format;

public class PMMFileLightingKeyframe {
    private int keyframePosition;
    private int previousIndex;
    private int nextIndex;
    private PMMFileLightingData lightingData;
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

    public PMMFileLightingData getLightingData() {
        return lightingData;
    }

    public void setLightingData(PMMFileLightingData lightingData) {
        this.lightingData = lightingData;
    }

    public byte getSelected() {
        return selected;
    }

    public void setSelected(byte selected) {
        this.selected = selected;
    }
}
