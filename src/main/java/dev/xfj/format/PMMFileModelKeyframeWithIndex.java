package dev.xfj.format;

public class PMMFileModelKeyframeWithIndex {
    private int dataIndex;
    private PMMFileModelKeyframe boneKeyframeData;

    public int getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(int dataIndex) {
        this.dataIndex = dataIndex;
    }

    public PMMFileModelKeyframe getBoneKeyframeData() {
        return boneKeyframeData;
    }

    public void setBoneKeyframeData(PMMFileModelKeyframe boneKeyframeData) {
        this.boneKeyframeData = boneKeyframeData;
    }
}
