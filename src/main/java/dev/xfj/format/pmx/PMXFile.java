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
}
