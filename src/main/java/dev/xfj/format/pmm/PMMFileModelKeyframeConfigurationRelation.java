package dev.xfj.format.pmm;

public class PMMFileModelKeyframeConfigurationRelation {
    private int parentModelIndex;
    private int parentBoneIndex;

    public int getParentModelIndex() {
        return parentModelIndex;
    }

    public void setParentModelIndex(int parentModelIndex) {
        this.parentModelIndex = parentModelIndex;
    }

    public int getParentBoneIndex() {
        return parentBoneIndex;
    }

    public void setParentBoneIndex(int parentBoneIndex) {
        this.parentBoneIndex = parentBoneIndex;
    }
}
