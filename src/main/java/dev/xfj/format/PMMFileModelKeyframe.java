package dev.xfj.format;

public class PMMFileModelKeyframe {
    private int keyframePosition;
    private int previousIndex;
    private int nextIndex;
    private PMMFileKeyframeInterpolation interpolationX;
    private PMMFileKeyframeInterpolation interpolationY;
    private PMMFileKeyframeInterpolation interpolationZ;
    private PMMFileKeyframeInterpolation interpolationRotation;
    private float translationX;
    private float translationY;
    private float translationZ;
    //Rotation is a quaternion
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float rotationW;
    private byte selected;
    private byte physicsDisabled;

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

    public PMMFileKeyframeInterpolation getInterpolationX() {
        return interpolationX;
    }

    public void setInterpolationX(PMMFileKeyframeInterpolation interpolationX) {
        this.interpolationX = interpolationX;
    }

    public PMMFileKeyframeInterpolation getInterpolationY() {
        return interpolationY;
    }

    public void setInterpolationY(PMMFileKeyframeInterpolation interpolationY) {
        this.interpolationY = interpolationY;
    }

    public PMMFileKeyframeInterpolation getInterpolationZ() {
        return interpolationZ;
    }

    public void setInterpolationZ(PMMFileKeyframeInterpolation interpolationZ) {
        this.interpolationZ = interpolationZ;
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

    public float getRotationW() {
        return rotationW;
    }

    public void setRotationW(float rotationW) {
        this.rotationW = rotationW;
    }

    public byte getSelected() {
        return selected;
    }

    public void setSelected(byte selected) {
        this.selected = selected;
    }

    public byte getPhysicsDisabled() {
        return physicsDisabled;
    }

    public void setPhysicsDisabled(byte physicsDisabled) {
        this.physicsDisabled = physicsDisabled;
    }

    public PMMFileKeyframeInterpolation getInterpolationRotation() {
        return interpolationRotation;
    }

    public void setInterpolationRotation(PMMFileKeyframeInterpolation interpolationRotation) {
        this.interpolationRotation = interpolationRotation;
    }
}
