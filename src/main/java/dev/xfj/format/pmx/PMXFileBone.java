package dev.xfj.format.pmx;

import dev.xfj.vec.Vec3;

import java.util.List;

public class PMXFileBone {
    private String boneNameJapanese;
    private String bonenameEnglish;
    private Vec3 position;
    private Object parentBoneIndex;
    private int layer;
    private List<Integer> flags;

    public String getBoneNameJapanese() {
        return boneNameJapanese;
    }

    public void setBoneNameJapanese(String boneNameJapanese) {
        this.boneNameJapanese = boneNameJapanese;
    }

    public String getBonenameEnglish() {
        return bonenameEnglish;
    }

    public void setBonenameEnglish(String bonenameEnglish) {
        this.bonenameEnglish = bonenameEnglish;
    }

    public Vec3 getPosition() {
        return position;
    }

    public void setPosition(Vec3 position) {
        this.position = position;
    }

    public Object getParentBoneIndex() {
        return parentBoneIndex;
    }

    public void setParentBoneIndex(Object parentBoneIndex) {
        this.parentBoneIndex = parentBoneIndex;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public List<Integer> getFlags() {
        return flags;
    }

    public void setFlags(List<Integer> flags) {
        this.flags = flags;
    }
}
