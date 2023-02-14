package dev.xfj.format.pmx;

import dev.xfj.vec.Vec3;
import dev.xfj.vec.Vec4;

public class PMXFileMorphBone {
    private Object boneIndex;
    private Vec3 translation;
    private Vec4 rotation;

    public Object getBoneIndex() {
        return boneIndex;
    }

    public void setBoneIndex(Object boneIndex) {
        this.boneIndex = boneIndex;
    }

    public Vec3 getTranslation() {
        return translation;
    }

    public void setTranslation(Vec3 translation) {
        this.translation = translation;
    }

    public Vec4 getRotation() {
        return rotation;
    }

    public void setRotation(Vec4 rotation) {
        this.rotation = rotation;
    }
}
