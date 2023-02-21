package dev.xfj.format.pmx;

public class PMXFileGlobals {
    private Byte textEncoding;
    private Byte additionalVec4Count;
    private Byte vertexIndexSize;
    private Byte textureIndexSize;
    private Byte materialIndexSize;
    private Byte boneIndexSize;
    private Byte morphIndexSize;
    private Byte rigidBodyIndexSize;

    public Byte getTextEncoding() {
        return textEncoding;
    }

    public void setTextEncoding(Byte textEncoding) {
        this.textEncoding = textEncoding;
    }

    public Byte getAdditionalVec4Count() {
        return additionalVec4Count;
    }

    public void setAdditionalVec4Count(Byte additionalVec4Count) {
        this.additionalVec4Count = additionalVec4Count;
    }

    public Byte getVertexIndexSize() {
        return vertexIndexSize;
    }

    public void setVertexIndexSize(Byte vertexIndexSize) {
        this.vertexIndexSize = vertexIndexSize;
    }

    public Byte getTextureIndexSize() {
        return textureIndexSize;
    }

    public void setTextureIndexSize(Byte textureIndexSize) {
        this.textureIndexSize = textureIndexSize;
    }

    public Byte getMaterialIndexSize() {
        return materialIndexSize;
    }

    public void setMaterialIndexSize(Byte materialIndexSize) {
        this.materialIndexSize = materialIndexSize;
    }

    public Byte getBoneIndexSize() {
        return boneIndexSize;
    }

    public void setBoneIndexSize(Byte boneIndexSize) {
        this.boneIndexSize = boneIndexSize;
    }

    public Byte getMorphIndexSize() {
        return morphIndexSize;
    }

    public void setMorphIndexSize(Byte morphIndexSize) {
        this.morphIndexSize = morphIndexSize;
    }

    public Byte getRigidBodyIndexSize() {
        return rigidBodyIndexSize;
    }

    public void setRigidBodyIndexSize(Byte rigidBodyIndexSize) {
        this.rigidBodyIndexSize = rigidBodyIndexSize;
    }
}
