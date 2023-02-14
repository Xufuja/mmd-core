package dev.xfj.format.pmx;

import dev.xfj.vec.Vec3;
import dev.xfj.vec.Vec4;

public class PMXFileMorphMaterial {
    private Object materialIndex;
    private byte operationType;
    private Vec4 diffuse;
    private Vec3 specular;
    private float specularity;
    private Vec3 ambient;
    private Vec4 edgeColor;
    private float edgeSize;
    private Vec4 textureTint;
    private Vec4 environmentTint;
    private Vec4 toonTint;

    public Object getMaterialIndex() {
        return materialIndex;
    }

    public void setMaterialIndex(Object materialIndex) {
        this.materialIndex = materialIndex;
    }

    public byte getOperationType() {
        return operationType;
    }

    public void setOperationType(byte operationType) {
        this.operationType = operationType;
    }

    public Vec4 getDiffuse() {
        return diffuse;
    }

    public void setDiffuse(Vec4 diffuse) {
        this.diffuse = diffuse;
    }

    public Vec3 getSpecular() {
        return specular;
    }

    public void setSpecular(Vec3 specular) {
        this.specular = specular;
    }

    public float getSpecularity() {
        return specularity;
    }

    public void setSpecularity(float specularity) {
        this.specularity = specularity;
    }

    public Vec3 getAmbient() {
        return ambient;
    }

    public void setAmbient(Vec3 ambient) {
        this.ambient = ambient;
    }

    public Vec4 getEdgeColor() {
        return edgeColor;
    }

    public void setEdgeColor(Vec4 edgeColor) {
        this.edgeColor = edgeColor;
    }

    public float getEdgeSize() {
        return edgeSize;
    }

    public void setEdgeSize(float edgeSize) {
        this.edgeSize = edgeSize;
    }

    public Vec4 getTextureTint() {
        return textureTint;
    }

    public void setTextureTint(Vec4 textureTint) {
        this.textureTint = textureTint;
    }

    public Vec4 getEnvironmentTint() {
        return environmentTint;
    }

    public void setEnvironmentTint(Vec4 environmentTint) {
        this.environmentTint = environmentTint;
    }

    public Vec4 getToonTint() {
        return toonTint;
    }

    public void setToonTint(Vec4 toonTint) {
        this.toonTint = toonTint;
    }
}
