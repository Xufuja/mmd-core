package dev.xfj.format.pmm;

public class PMMFileModelMorphKeyframeWithIndex {
    private int dataIndex;
    private PMMFileModelMorphKeyframe morphKeyframeData;

    public int getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(int dataIndex) {
        this.dataIndex = dataIndex;
    }

    public PMMFileModelMorphKeyframe getBoneKeyframeData() {
        return morphKeyframeData;
    }

    public void setMorphKeyframeData(PMMFileModelMorphKeyframe morphKeyframeData) {
        this.morphKeyframeData = morphKeyframeData;
    }
}
