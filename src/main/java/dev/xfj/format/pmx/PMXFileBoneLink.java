package dev.xfj.format.pmx;

import dev.xfj.vec.Vec3;

public class PMXFileBoneLink {
    private Object boneIndex;
    private byte hasLimits;
    private Vec3 limitMin;
    private Vec3 limitMax;

    public Object getBoneIndex() {
        return boneIndex;
    }

    public void setBoneIndex(Object boneIndex) {
        this.boneIndex = boneIndex;
    }

    public byte getHasLimits() {
        return hasLimits;
    }

    public void setHasLimits(byte hasLimits) {
        this.hasLimits = hasLimits;
    }

    public Vec3 getLimitMin() {
        return limitMin;
    }

    public void setLimitMin(Vec3 limitMin) {
        this.limitMin = limitMin;
    }

    public Vec3 getLimitMax() {
        return limitMax;
    }

    public void setLimitMax(Vec3 limitMax) {
        this.limitMax = limitMax;
    }
}
