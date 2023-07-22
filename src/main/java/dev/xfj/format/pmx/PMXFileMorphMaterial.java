package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import org.joml.Vector3f;
import org.joml.Vector4f;;

public class PMXFileMorphMaterial implements PMXFileMorphType {
    private IndexType<?> materialIndex;
    private Byte operationType;
    private Vector4f diffuse;
    private Vector3f specular;
    private Float specularity;
    private Vector3f ambient;
    private Vector4f edgeColor;
    private Float edgeSize;
    private Vector4f textureTint;
    private Vector4f environmentTint;
    private Vector4f toonTint;

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

    public Vector4f getDiffuse() {
        return diffuse;
    }

    public void setDiffuse(Vector4f diffuse) {
        this.diffuse = diffuse;
    }

    public Vector3f getSpecular() {
        return specular;
    }

    public void setSpecular(Vector3f specular) {
        this.specular = specular;
    }

    public Float getSpecularity() {
        return specularity;
    }

    public void setSpecularity(Float specularity) {
        this.specularity = specularity;
    }

    public Vector3f getAmbient() {
        return ambient;
    }

    public void setAmbient(Vector3f ambient) {
        this.ambient = ambient;
    }

    public Vector4f getEdgeColor() {
        return edgeColor;
    }

    public void setEdgeColor(Vector4f edgeColor) {
        this.edgeColor = edgeColor;
    }

    public Float getEdgeSize() {
        return edgeSize;
    }

    public void setEdgeSize(Float edgeSize) {
        this.edgeSize = edgeSize;
    }

    public Vector4f getTextureTint() {
        return textureTint;
    }

    public void setTextureTint(Vector4f textureTint) {
        this.textureTint = textureTint;
    }

    public Vector4f getEnvironmentTint() {
        return environmentTint;
    }

    public void setEnvironmentTint(Vector4f environmentTint) {
        this.environmentTint = environmentTint;
    }

    public Vector4f getToonTint() {
        return toonTint;
    }

    public void setToonTint(Vector4f toonTint) {
        this.toonTint = toonTint;
    }
}
