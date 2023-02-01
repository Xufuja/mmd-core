package dev.xfj.format.pmm;

import java.util.List;

public class PMMFileCamera {
    private PMMFileCameraKeyframe cameraInitialKeyframe;
    private int cameraKeyframeCount;
    private List<PMMFileCameraKeyframeWithIndex> cameraKeyframes;
    private float eyePositionX;
    private float eyePositionY;
    private float eyePositionZ;
    private float targetPositionX;
    private float targetPositionY;
    private float targetPositionZ;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private byte orthographicCameraEnabled;

    public PMMFileCameraKeyframe getCameraInitialKeyframe() {
        return cameraInitialKeyframe;
    }

    public void setCameraInitialKeyframe(PMMFileCameraKeyframe cameraInitialKeyframe) {
        this.cameraInitialKeyframe = cameraInitialKeyframe;
    }

    public int getCameraKeyframeCount() {
        return cameraKeyframeCount;
    }

    public void setCameraKeyframeCount(int cameraKeyframeCount) {
        this.cameraKeyframeCount = cameraKeyframeCount;
    }

    public List<PMMFileCameraKeyframeWithIndex> getCameraKeyframes() {
        return cameraKeyframes;
    }

    public void setCameraKeyframes(List<PMMFileCameraKeyframeWithIndex> cameraKeyframes) {
        this.cameraKeyframes = cameraKeyframes;
    }

    public float getEyePositionX() {
        return eyePositionX;
    }

    public void setEyePositionX(float eyePositionX) {
        this.eyePositionX = eyePositionX;
    }

    public float getEyePositionY() {
        return eyePositionY;
    }

    public void setEyePositionY(float eyePositionY) {
        this.eyePositionY = eyePositionY;
    }

    public float getEyePositionZ() {
        return eyePositionZ;
    }

    public void setEyePositionZ(float eyePositionZ) {
        this.eyePositionZ = eyePositionZ;
    }

    public float getTargetPositionX() {
        return targetPositionX;
    }

    public void setTargetPositionX(float targetPositionX) {
        this.targetPositionX = targetPositionX;
    }

    public float getTargetPositionY() {
        return targetPositionY;
    }

    public void setTargetPositionY(float targetPositionY) {
        this.targetPositionY = targetPositionY;
    }

    public float getTargetPositionZ() {
        return targetPositionZ;
    }

    public void setTargetPositionZ(float targetPositionZ) {
        this.targetPositionZ = targetPositionZ;
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

    public byte getOrthographicCameraEnabled() {
        return orthographicCameraEnabled;
    }

    public void setOrthographicCameraEnabled(byte orthographicCameraEnabled) {
        this.orthographicCameraEnabled = orthographicCameraEnabled;
    }
}
