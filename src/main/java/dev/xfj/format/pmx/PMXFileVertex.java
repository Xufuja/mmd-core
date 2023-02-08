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
}
