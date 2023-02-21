package dev.xfj.format.pmx;

import java.util.List;

public class PMXFileMorph {
    private String morphNameJapanese;
    private String morphNameEnglish;
    private Byte panelType;
    private Byte morphType;
    private Integer offsetSize;
    private List<PMXFileMorphType> offsetData;

    public String getMorphNameJapanese() {
        return morphNameJapanese;
    }

    public void setMorphNameJapanese(String morphNameJapanese) {
        this.morphNameJapanese = morphNameJapanese;
    }

    public String getMorphNameEnglish() {
        return morphNameEnglish;
    }

    public void setMorphNameEnglish(String morphNameEnglish) {
        this.morphNameEnglish = morphNameEnglish;
    }

    public Byte getPanelType() {
        return panelType;
    }

    public void setPanelType(Byte panelType) {
        this.panelType = panelType;
    }

    public Byte getMorphType() {
        return morphType;
    }

    public void setMorphType(Byte morphType) {
        this.morphType = morphType;
    }

    public Integer getOffsetSize() {
        return offsetSize;
    }

    public void setOffsetSize(Integer offsetSize) {
        this.offsetSize = offsetSize;
    }

    public List<PMXFileMorphType> getOffsetData() {
        return offsetData;
    }

    public void setOffsetData(List<PMXFileMorphType> offsetData) {
        this.offsetData = offsetData;
    }
}
