package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import dev.xfj.types.vec.Vec3;
import dev.xfj.types.vec.Vec4;

public class PMXFileMorphBone implements PMXFileMorphType {
    private IndexType<?> boneIndex;
    private Vec3 translation;
    private Vec4 rotation;

    public IndexType<?> getBoneIndex() {
        return boneIndex;
    }

    public void setBoneIndex(IndexType<?> boneIndex) {
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
