package dev.xfj.format.pmx;

import java.util.List;

public class PMXFile {
    private String signature;
    private float version;
    private byte globalsCount;
    private PMXFileGlobals globals;
    private String modelNameJapanese;
    private String modelNameEnglish;
    private String commentsJapanese;
    private String commentsEnglish;
    private int vertextCount;
    private List<PMXFileVertex> vertices;
    private int surfaceCount;
    private List<PMXFileVertexIndex> surfaces;
    private int textureCount;
    private List<String> texturePaths;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    public byte getGlobalsCount() {
        return globalsCount;
    }

    public void setGlobalsCount(byte globalsCount) {
        this.globalsCount = globalsCount;
    }

    public PMXFileGlobals getGlobals() {
        return globals;
    }

    public void setGlobals(PMXFileGlobals globals) {
        this.globals = globals;
    }

    public String getModelNameJapanese() {
        return modelNameJapanese;
    }

    public void setModelNameJapanese(String modelNameJapanese) {
        this.modelNameJapanese = modelNameJapanese;
    }

    public String getModelNameEnglish() {
        return modelNameEnglish;
    }

    public void setModelNameEnglish(String modelNameEnglish) {
        this.modelNameEnglish = modelNameEnglish;
    }

    public String getCommentsJapanese() {
        return commentsJapanese;
    }

    public void setCommentsJapanese(String commentsJapanese) {
        this.commentsJapanese = commentsJapanese;
    }

    public String getCommentsEnglish() {
        return commentsEnglish;
    }

    public void setCommentsEnglish(String commentsEnglish) {
        this.commentsEnglish = commentsEnglish;
    }

    public int getVertextCount() {
        return vertextCount;
    }

    public void setVertextCount(int vertextCount) {
        this.vertextCount = vertextCount;
    }

    public List<PMXFileVertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<PMXFileVertex> vertices) {
        this.vertices = vertices;
    }

    public int getSurfaceCount() {
        return surfaceCount;
    }

    public void setSurfaceCount(int surfaceCount) {
        this.surfaceCount = surfaceCount;
    }

    public List<PMXFileVertexIndex> getSurfaces() {
        return surfaces;
    }

    public void setSurfaces(List<PMXFileVertexIndex> surfaces) {
        this.surfaces = surfaces;
    }

    public int getTextureCount() {
        return textureCount;
    }

    public void setTextureCount(int textureCount) {
        this.textureCount = textureCount;
    }

    public List<String> getTexturePaths() {
        return texturePaths;
    }

    public void setTexturePaths(List<String> texturePaths) {
        this.texturePaths = texturePaths;
    }
}
