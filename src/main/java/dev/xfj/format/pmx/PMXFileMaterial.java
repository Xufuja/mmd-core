package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import org.joml.Vector3f;
import org.joml.Vector4f;

public class PMXFileMaterial {
    private String materialNameJapanese;
    private String materialNameEnglish;
    private Vector4f diffuseColor;
    private Vector3f specularColor;
    private Float specularStrength;
    private Vector3f ambientColor;
    private Byte materialFlags;
    private Vector4f edgeColor;
    private Float edgeScale;
    private IndexType<?> textureIndex;
    private IndexType<?> environmentIndex;
    private Byte environmentBlendMode;
    private Byte toonReference;
    private Object toonValue;
    private String metaData;
    private Integer surfaceCount;

    public String getMaterialNameJapanese() {
        return materialNameJapanese;
    }

    public void setMaterialNameJapanese(String materialNameJapanese) {
        this.materialNameJapanese = materialNameJapanese;
    }

    public String getMaterialNameEnglish() {
        return materialNameEnglish;
    }

    public void setMaterialNameEnglish(String materialNameEnglish) {
        this.materialNameEnglish = materialNameEnglish;
    }

    public Vector4f getDiffuseColor() {
        return diffuseColor;
    }

    public void setDiffuseColor(Vector4f diffuseColor) {
        this.diffuseColor = diffuseColor;
    }

    public Vector3f getSpecularColor() {
        return specularColor;
    }

    public void setSpecularColor(Vector3f specularColor) {
        this.specularColor = specularColor;
    }

    public Float getSpecularStrength() {
        return specularStrength;
    }

    public void setSpecularStrength(Float specularStrength) {
        this.specularStrength = specularStrength;
    }

    public Vector3f getAmbientColor() {
        return ambientColor;
    }

    public void setAmbientColor(Vector3f ambientColor) {
        this.ambientColor = ambientColor;
    }

    public Byte getMaterialFlags() {
        return materialFlags;
    }

    public void setMaterialFlags(Byte materialFlags) {
        this.materialFlags = materialFlags;
    }

    public Vector4f getEdgeColor() {
        return edgeColor;
    }

    public void setEdgeColor(Vector4f edgeColor) {
        this.edgeColor = edgeColor;
    }

    public Float getEdgeScale() {
        return edgeScale;
    }

    public void setEdgeScale(Float edgeScale) {
        this.edgeScale = edgeScale;
    }

    public IndexType<?> getTextureIndex() {
        return textureIndex;
    }

    public void setTextureIndex(IndexType<?> textureIndex) {
        this.textureIndex = textureIndex;
    }

    public IndexType<?> getEnvironmentIndex() {
        return environmentIndex;
    }

    public void setEnvironmentIndex(IndexType<?> environmentIndex) {
        this.environmentIndex = environmentIndex;
    }

    public Byte getEnvironmentBlendMode() {
        return environmentBlendMode;
    }

    public void setEnvironmentBlendMode(Byte environmentBlendMode) {
        this.environmentBlendMode = environmentBlendMode;
    }

    public Byte getToonReference() {
        return toonReference;
    }

    public void setToonReference(Byte toonReference) {
        this.toonReference = toonReference;
    }

    public Object getToonValue() {
        return toonValue;
    }

    public void setToonValue(Object toonValue) {
        this.toonValue = toonValue;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    public Integer getSurfaceCount() {
        return surfaceCount;
    }

    public void setSurfaceCount(Integer surfaceCount) {
        this.surfaceCount = surfaceCount;
    }
}
