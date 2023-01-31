package dev.xfj.format;

public class PMMFileAccessoryData {
    private byte opacityAndVisibility;
    private int parentModelIndex;
    private int parentBoneIndex;
    private float translationX;
    private float translationY;
    private float translationZ;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scale;
    private byte shadowEnabled;

    public PMMFileAccessoryData(byte opacityAndVisibility, int parentModelIndex, int parentBoneIndex, float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float scale, byte shadowEnabled) {
        this.opacityAndVisibility = opacityAndVisibility;
        this.parentModelIndex = parentModelIndex;
        this.parentBoneIndex = parentBoneIndex;
        this.translationX = translationX;
        this.translationY = translationY;
        this.translationZ = translationZ;
        this.rotationX = rotationX;
        this.rotationY = rotationY;
        this.rotationZ = rotationZ;
        this.scale = scale;
        this.shadowEnabled = shadowEnabled;
    }

    public byte getOpacityAndVisibility() {
        return opacityAndVisibility;
    }

    public void setOpacityAndVisibility(byte opacityAndVisibility) {
        this.opacityAndVisibility = opacityAndVisibility;
    }

    public int getParentModelIndex() {
        return parentModelIndex;
    }

    public void setParentModelIndex(int parentModelIndex) {
        this.parentModelIndex = parentModelIndex;
    }

    public int getParentBoneIndex() {
        return parentBoneIndex;
    }

    public void setParentBoneIndex(int parentBoneIndex) {
        this.parentBoneIndex = parentBoneIndex;
    }

    public float getTranslationX() {
        return translationX;
    }

    public void setTranslationX(float translationX) {
        this.translationX = translationX;
    }

    public float getTranslationY() {
        return translationY;
    }

    public void setTranslationY(float translationY) {
        this.translationY = translationY;
    }

    public float getTranslationZ() {
        return translationZ;
    }

    public void setTranslationZ(float translationZ) {
        this.translationZ = translationZ;
    }

    public float getRotationX() {
        return rotationX;
    }

    public void setRotationX(float rotationX) {
        this.rotationX = rotationX;
    }

    public float getRotationY() {
        return rotationY;
    }

    public void setRotationY(float rotationY) {
        this.rotationY = rotationY;
    }

    public float getRotationZ() {
        return rotationZ;
    }

    public void setRotationZ(float rotationZ) {
        this.rotationZ = rotationZ;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public byte getShadowEnabled() {
        return shadowEnabled;
    }

    public void setShadowEnabled(byte shadowEnabled) {
        this.shadowEnabled = shadowEnabled;
    }
}
