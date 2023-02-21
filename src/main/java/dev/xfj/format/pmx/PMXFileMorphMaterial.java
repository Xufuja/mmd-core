package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import dev.xfj.types.vec.Vec3;
import dev.xfj.types.vec.Vec4;

public class PMXFileMorphMaterial implements PMXFileMorphType {
    private IndexType<?> materialIndex;
    private Byte operationType;
    private Vec4 diffuse;
    private Vec3 specular;
    private Float specularity;
    private Vec3 ambient;
    private Vec4 edgeColor;
    private Float edgeSize;
    private Vec4 textureTint;
    private Vec4 environmentTint;
    private Vec4 toonTint;

    public IndexType<?> getMaterialIndex() {
        return materialIndex;
    }

    public void setMaterialIndex(IndexType<?> materialIndex) {
        this.materialIndex = materialIndex;
    }

    public Byte getOperationType() {
        return operationType;
    }

    public void setOperationType(Byte operationType) {
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

    public Float getSpecularity() {
        return specularity;
    }

    public void setSpecularity(Float specularity) {
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

    public Float getEdgeSize() {
        return edgeSize;
    }

    public void setEdgeSize(Float edgeSize) {
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
