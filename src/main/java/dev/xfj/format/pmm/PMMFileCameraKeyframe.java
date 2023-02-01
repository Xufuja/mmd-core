package dev.xfj.format.pmm;

public class PMMFileCameraKeyframe {
    private int keyframePosition;
    private int previousIndex;
    private int nextIndex;
    private float distance;
    private float eyePositionX;
    private float eyePositionY;
    private float eyePositionZ;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private int trackedModelIndex;
    private int trackedModelBoneIndex;
    private PMMFileKeyframeInterpolation eyeInterpolationX;
    private PMMFileKeyframeInterpolation eyeInterpolationY;
    private PMMFileKeyframeInterpolation eyeInterpolationZ;
    private PMMFileKeyframeInterpolation interpolationRotation;
    private PMMFileKeyframeInterpolation interpolationDistance;
    private PMMFileKeyframeInterpolation interpolationAngleOfView;
    private byte orthographicCameraEnabled;
    private int angleOfView;
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

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
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

    public int getTrackedModelIndex() {
        return trackedModelIndex;
    }

    public void setTrackedModelIndex(int trackedModelIndex) {
        this.trackedModelIndex = trackedModelIndex;
    }

    public int getTrackedModelBoneIndex() {
        return trackedModelBoneIndex;
    }

    public void setTrackedModelBoneIndex(int trackedModelBoneIndex) {
        this.trackedModelBoneIndex = trackedModelBoneIndex;
    }

    public PMMFileKeyframeInterpolation getEyeInterpolationX() {
        return eyeInterpolationX;
    }

    public void setEyeInterpolationX(PMMFileKeyframeInterpolation eyeInterpolationX) {
        this.eyeInterpolationX = eyeInterpolationX;
    }

    public PMMFileKeyframeInterpolation getEyeInterpolationY() {
        return eyeInterpolationY;
    }

    public void setEyeInterpolationY(PMMFileKeyframeInterpolation eyeInterpolationY) {
        this.eyeInterpolationY = eyeInterpolationY;
    }

    public PMMFileKeyframeInterpolation getEyeInterpolationZ() {
        return eyeInterpolationZ;
    }

    public void setEyeInterpolationZ(PMMFileKeyframeInterpolation eyeInterpolationZ) {
        this.eyeInterpolationZ = eyeInterpolationZ;
    }

    public PMMFileKeyframeInterpolation getInterpolationRotation() {
        return interpolationRotation;
    }

    public void setInterpolationRotation(PMMFileKeyframeInterpolation interpolationRotation) {
        this.interpolationRotation = interpolationRotation;
    }

    public PMMFileKeyframeInterpolation getInterpolationDistance() {
        return interpolationDistance;
    }

    public void setInterpolationDistance(PMMFileKeyframeInterpolation interpolationDistance) {
        this.interpolationDistance = interpolationDistance;
    }

    public PMMFileKeyframeInterpolation getInterpolationAngleOfView() {
        return interpolationAngleOfView;
    }

    public void setInterpolationAngleOfView(PMMFileKeyframeInterpolation interpolationAngleOfView) {
        this.interpolationAngleOfView = interpolationAngleOfView;
    }

    public byte getOrthographicCameraEnabled() {
        return orthographicCameraEnabled;
    }

    public void setOrthographicCameraEnabled(byte orthographicCameraEnabled) {
        this.orthographicCameraEnabled = orthographicCameraEnabled;
    }

    public int getAngleOfView() {
        return angleOfView;
    }

    public void setAngleOfView(int angleOfView) {
        this.angleOfView = angleOfView;
    }

    public byte getSelected() {
        return selected;
    }

    public void setSelected(byte selected) {
        this.selected = selected;
    }
}
