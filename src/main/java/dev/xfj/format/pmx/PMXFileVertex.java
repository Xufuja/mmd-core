package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

public class PMXFileVertex {
    private Vector3f position;
    private Vector3f normal;
    private Vector2f uv;
    private List<Vector4f> additionalVector4f;
    private byte weightDeformType;
    private List<IndexType<?>> boneIndices;
    private List<Float> boneWeights;
    private Vector3f c;
    private Vector3f r0;
    private Vector3f r1;
    private float edgeScale;

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public Vector3f getNormal() {
        return normal;
    }

    public void setNormal(Vector3f normal) {
        this.normal = normal;
    }

    public Vector2f getUv() {
        return uv;
    }

    public void setUv(Vector2f uv) {
        this.uv = uv;
    }

    public List<Vector4f> getAdditionalVector4f() {
        return additionalVector4f;
    }

    public void setAdditionalVec4(List<Vector4f> additionalVector4f) {
        this.additionalVector4f = additionalVector4f;
    }

    public byte getWeightDeformType() {
        return weightDeformType;
    }

    public void setWeightDeformType(byte weightDeformType) {
        this.weightDeformType = weightDeformType;
    }

    public List<IndexType<?>> getBoneIndices() {
        return boneIndices;
    }

    public void setBoneIndices(List<IndexType<?>> boneIndices) {
        this.boneIndices = boneIndices;
    }

    public List<Float> getBoneWeights() {
        return boneWeights;
    }

    public void setBoneWeights(List<Float> boneWeights) {
        this.boneWeights = boneWeights;
    }

    public Vector3f getC() {
        return c;
    }

    public void setC(Vector3f c) {
        this.c = c;
    }

    public Vector3f getR0() {
        return r0;
    }

    public void setR0(Vector3f r0) {
        this.r0 = r0;
    }

    public Vector3f getR1() {
        return r1;
    }

    public void setR1(Vector3f r1) {
        this.r1 = r1;
    }

    public float getEdgeScale() {
        return edgeScale;
    }

    public void setEdgeScale(float edgeScale) {
        this.edgeScale = edgeScale;
    }
}
