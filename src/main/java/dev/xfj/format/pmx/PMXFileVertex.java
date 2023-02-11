package dev.xfj.format.pmx;

import dev.xfj.vec.Vec2;
import dev.xfj.vec.Vec3;
import dev.xfj.vec.Vec4;

import java.util.List;

public class PMXFileVertex {
    private Vec3 position;
    private Vec3 normal;
    private Vec2 uv;
    private List<Vec4> additionalVec4;
    private byte weightDeformType;
    private List<Object> boneIndices;
    private List<Float> boneWeights;
    private Vec3 c;
    private Vec3 r0;
    private Vec3 r1;
    private float edgeScale;

    public Vec3 getPosition() {
        return position;
    }

    public void setPosition(Vec3 position) {
        this.position = position;
    }

    public Vec3 getNormal() {
        return normal;
    }

    public void setNormal(Vec3 normal) {
        this.normal = normal;
    }

    public Vec2 getUv() {
        return uv;
    }

    public void setUv(Vec2 uv) {
        this.uv = uv;
    }

    public List<Vec4> getAdditionalVec4() {
        return additionalVec4;
    }

    public void setAdditionalVec4(List<Vec4> additionalVec4) {
        this.additionalVec4 = additionalVec4;
    }

    public byte getWeightDeformType() {
        return weightDeformType;
    }

    public void setWeightDeformType(byte weightDeformType) {
        this.weightDeformType = weightDeformType;
    }

    public List<Object> getBoneIndices() {
        return boneIndices;
    }

    public void setBoneIndices(List<Object> boneIndices) {
        this.boneIndices = boneIndices;
    }

    public List<Float> getBoneWeights() {
        return boneWeights;
    }

    public void setBoneWeights(List<Float> boneWeights) {
        this.boneWeights = boneWeights;
    }

    public Vec3 getC() {
        return c;
    }

    public void setC(Vec3 c) {
        this.c = c;
    }

    public Vec3 getR0() {
        return r0;
    }

    public void setR0(Vec3 r0) {
        this.r0 = r0;
    }

    public Vec3 getR1() {
        return r1;
    }

    public void setR1(Vec3 r1) {
        this.r1 = r1;
    }

    public float getEdgeScale() {
        return edgeScale;
    }

    public void setEdgeScale(float edgeScale) {
        this.edgeScale = edgeScale;
    }
}
