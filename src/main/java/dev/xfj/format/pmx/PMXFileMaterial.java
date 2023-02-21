package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import dev.xfj.types.vec.Vec3;
import dev.xfj.types.vec.Vec4;

public class PMXFileMaterial {
    private String materialNameJapanese;
    private String materialNameEnglish;
    private Vec4 diffuseColor;
    private Vec3 specularColor;
    private Float specularStrength;
    private Vec3 ambientColor;
    private Byte materialFlags;
    private Vec4 edgeColor;
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

    public Vec4 getDiffuseColor() {
        return diffuseColor;
    }

    public void setDiffuseColor(Vec4 diffuseColor) {
        this.diffuseColor = diffuseColor;
    }

    public Vec3 getSpecularColor() {
        return specularColor;
    }

    public void setSpecularColor(Vec3 specularColor) {
        this.specularColor = specularColor;
    }

    public Float getSpecularStrength() {
        return specularStrength;
    }

    public void setSpecularStrength(Float specularStrength) {
        this.specularStrength = specularStrength;
    }

    public Vec3 getAmbientColor() {
        return ambientColor;
    }

    public void setAmbientColor(Vec3 ambientColor) {
        this.ambientColor = ambientColor;
    }

    public Byte getMaterialFlags() {
        return materialFlags;
    }

    public void setMaterialFlags(Byte materialFlags) {
        this.materialFlags = materialFlags;
    }

    public Vec4 getEdgeColor() {
        return edgeColor;
    }

    public void setEdgeColor(Vec4 edgeColor) {
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
