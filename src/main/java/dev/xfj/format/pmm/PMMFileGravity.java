package dev.xfj.format.pmm;

import java.util.List;

public class PMMFileGravity {
    private float acceleration;
    private int noiseAmount;
    private float directionX;
    private float directionY;
    private float directionZ;
    private byte addNoise;
    private PMMFileGravityKeyframe gravityInitialKeyframe;
    private int gravityKeyframeCount;
    private List<PMMFileGravityKeyframeWithIndex> gravityKeyframes;

    public float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    public int getNoiseAmount() {
        return noiseAmount;
    }

    public void setNoiseAmount(int noiseAmount) {
        this.noiseAmount = noiseAmount;
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

    public byte getAddNoise() {
        return addNoise;
    }

    public void setAddNoise(byte addNoise) {
        this.addNoise = addNoise;
    }

    public PMMFileGravityKeyframe getGravityInitialKeyframe() {
        return gravityInitialKeyframe;
    }

    public void setGravityInitialKeyframe(PMMFileGravityKeyframe gravityInitialKeyframe) {
        this.gravityInitialKeyframe = gravityInitialKeyframe;
    }

    public int getGravityKeyframeCount() {
        return gravityKeyframeCount;
    }

    public void setGravityKeyframeCount(int gravityKeyframeCount) {
        this.gravityKeyframeCount = gravityKeyframeCount;
    }

    public List<PMMFileGravityKeyframeWithIndex> getGravityKeyframes() {
        return gravityKeyframes;
    }

    public void setGravityKeyframes(List<PMMFileGravityKeyframeWithIndex> gravityKeyframes) {
        this.gravityKeyframes = gravityKeyframes;
    }
}
