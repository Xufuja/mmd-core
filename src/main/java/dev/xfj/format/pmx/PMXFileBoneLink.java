package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import org.joml.Vector3f;

public class PMXFileBoneLink {
    private IndexType<?> boneIndex;
    private Byte hasLimits;
    private Vector3f limitMin;
    private Vector3f limitMax;

    public IndexType<?> getBoneIndex() {
        return boneIndex;
    }

    public void setBoneIndex(IndexType<?> boneIndex) {
        this.boneIndex = boneIndex;
    }

    public Byte getHasLimits() {
        return hasLimits;
    }

    public void setHasLimits(Byte hasLimits) {
        this.hasLimits = hasLimits;
    }

    public Vector3f getLimitMin() {
        return limitMin;
    }

    public void setLimitMin(Vector3f limitMin) {
        this.limitMin = limitMin;
    }

    public Vector3f getLimitMax() {
        return limitMax;
    }

    public void setLimitMax(Vector3f limitMax) {
        this.limitMax = limitMax;
    }
}
