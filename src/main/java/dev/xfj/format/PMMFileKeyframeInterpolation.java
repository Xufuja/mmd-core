package dev.xfj.format;

public class PMMFileKeyframeInterpolation {
    private byte startX;
    private byte startY;
    private byte endX;
    private byte endY;

    public PMMFileKeyframeInterpolation(byte startX, byte startY, byte endX, byte endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public byte getStartX() {
        return startX;
    }

    public void setStartX(byte startX) {
        this.startX = startX;
    }

    public byte getStartY() {
        return startY;
    }

    public void setStartY(byte startY) {
        this.startY = startY;
    }

    public byte getEndX() {
        return endX;
    }

    public void setEndX(byte endX) {
        this.endX = endX;
    }

    public byte getEndY() {
        return endY;
    }

    public void setEndY(byte endY) {
        this.endY = endY;
    }
}
