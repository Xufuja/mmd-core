package dev.xfj.format.pmx;

public class PMXFileGlobals {
    private byte textEncoding;
    private byte additionalVec4Count;
    private byte vertexIndexSize;
    private byte textureIndexSize;
    private byte materialIndexSize;
    private byte boneIndexSize;
    private byte morphIndexSize;
    private byte rigidBodyIndexSize;

    public byte getTextEncoding() {
        return textEncoding;
    }

    public void setTextEncoding(byte textEncoding) {
        this.textEncoding = textEncoding;
    }

    public byte getAdditionalVec4Count() {
        return additionalVec4Count;
    }

    public void setAdditionalVec4Count(byte additionalVec4Count) {
        this.additionalVec4Count = additionalVec4Count;
    }

    public byte getVertexIndexSize() {
        return vertexIndexSize;
    }

    public void setVertexIndexSize(byte vertexIndexSize) {
        this.vertexIndexSize = vertexIndexSize;
    }

    public byte getTextureIndexSize() {
        return textureIndexSize;
    }

    public void setTextureIndexSize(byte textureIndexSize) {
        this.textureIndexSize = textureIndexSize;
    }

    public byte getMaterialIndexSize() {
        return materialIndexSize;
    }

    public void setMaterialIndexSize(byte materialIndexSize) {
        this.materialIndexSize = materialIndexSize;
    }

    public byte getBoneIndexSize() {
        return boneIndexSize;
    }

    public void setBoneIndexSize(byte boneIndexSize) {
        this.boneIndexSize = boneIndexSize;
    }

    public byte getMorphIndexSize() {
        return morphIndexSize;
    }

    public void setMorphIndexSize(byte morphIndexSize) {
        this.morphIndexSize = morphIndexSize;
    }

    public byte getRigidBodyIndexSize() {
        return rigidBodyIndexSize;
    }

    public void setRigidBodyIndexSize(byte rigidBodyIndexSize) {
        this.rigidBodyIndexSize = rigidBodyIndexSize;
    }
}
