package dev.xfj.format.pmm;

public class PMMFileModelKeyframeConfigurationRelationCurrent {
    private int keyframePositionRelationBegin;
    private int keyframePositionRelationEnd;
    private int parentModelIndex;
    private int parentBoneIndex;

    public int getKeyframePositionRelationBegin() {
        return keyframePositionRelationBegin;
    }

    public void setKeyframePositionRelationBegin(int keyframePositionRelationBegin) {
        this.keyframePositionRelationBegin = keyframePositionRelationBegin;
    }

    public int getKeyframePositionRelationEnd() {
        return keyframePositionRelationEnd;
    }

    public void setKeyframePositionRelationEnd(int keyframePositionRelationEnd) {
        this.keyframePositionRelationEnd = keyframePositionRelationEnd;
    }

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
