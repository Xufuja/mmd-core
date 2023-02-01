package dev.xfj.format.pmm;

public class PMMFileModelBone {
    private float translationX;
    private float translationY;
    private float translationZ;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float rotationW;
    private byte operationUncommitted;
    private byte physicsDisabled;
    private byte rowSelected;

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

    public byte getOperationUncommitted() {
        return operationUncommitted;
    }

    public void setOperationUncommitted(byte operationUncommitted) {
        this.operationUncommitted = operationUncommitted;
    }

    public byte getPhysicsDisabled() {
        return physicsDisabled;
    }

    public void setPhysicsDisabled(byte physicsDisabled) {
        this.physicsDisabled = physicsDisabled;
    }

    public byte getRowSelected() {
        return rowSelected;
    }

    public void setRowSelected(byte rowSelected) {
        this.rowSelected = rowSelected;
    }
}
