package dev.xfj.format;

public class PMMFileGravityKeyframe {
    private int keyframePosition;
    private int previousIndex;
    private int nextIndex;
    private byte addNoise;
    private int noiseAmount;
    private float acceleration;
    private float directionX;
    private float directionY;
    private float directionZ;
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

    public byte getAddNoise() {
        return addNoise;
    }

    public void setAddNoise(byte addNoise) {
        this.addNoise = addNoise;
    }

    public int getNoiseAmount() {
        return noiseAmount;
    }

    public void setNoiseAmount(int noiseAmount) {
        this.noiseAmount = noiseAmount;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    public float getDirectionX() {
        return directionX;
    }

    public void setDirectionX(float directionX) {
        this.directionX = directionX;
    }

    public float getDirectionY() {
        return directionY;
    }

    public void setDirectionY(float directionY) {
        this.directionY = directionY;
    }

    public float getDirectionZ() {
        return directionZ;
    }

    public void setDirectionZ(float directionZ) {
        this.directionZ = directionZ;
    }

    public byte getSelected() {
        return selected;
    }

    public void setSelected(byte selected) {
        this.selected = selected;
    }
}
