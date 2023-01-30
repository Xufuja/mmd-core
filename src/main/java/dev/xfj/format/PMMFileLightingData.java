package dev.xfj.format;

public class PMMFileLightingData { //The spreadsheet mentions that the total structure size is 4, this has to be a typo with the actual number being 24
    private float r;
    private float g;
    private float b;
    private float x;
    private float y;
    private float z;

    public PMMFileLightingData(float r, float g, float b, float x, float y, float z) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public float getG() {
        return g;
    }

    public void setG(float g) {
        this.g = g;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}
