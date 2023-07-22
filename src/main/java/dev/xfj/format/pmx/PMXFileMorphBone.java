package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import org.joml.Vector3f;
import org.joml.Vector4f;

public class PMXFileMorphBone implements PMXFileMorphType {
    private IndexType<?> boneIndex;
    private Vector3f translation;
    private Vector4f rotation;

    public IndexType<?> getBoneIndex() {
        return boneIndex;
    }

    public void setBoneIndex(IndexType<?> boneIndex) {
        this.boneIndex = boneIndex;
    }

    public Vector3f getTranslation() {
        return translation;
    }

    public void setTranslation(Vector3f translation) {
        this.translation = translation;
    }

    public Vector4f getRotation() {
        return rotation;
    }

    public void setRotation(Vector4f rotation) {
        this.rotation = rotation;
    }
}
