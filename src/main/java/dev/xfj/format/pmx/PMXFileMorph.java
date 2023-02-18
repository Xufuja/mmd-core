package dev.xfj.format.pmx;

import java.util.List;

public class PMXFileMorph {
    private String morphNameJapanese;
    private String morphNameEnglish;
    private byte panelType;
    private byte morphType;
    private int offsetSize;
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

    public byte getPanelType() {
        return panelType;
    }

    public void setPanelType(byte panelType) {
        this.panelType = panelType;
    }

    public byte getMorphType() {
        return morphType;
    }

    public void setMorphType(byte morphType) {
        this.morphType = morphType;
    }

    public int getOffsetSize() {
        return offsetSize;
    }

    public void setOffsetSize(int offsetSize) {
        this.offsetSize = offsetSize;
    }

    public List<PMXFileMorphType> getOffsetData() {
        return offsetData;
    }

    public void setOffsetData(List<PMXFileMorphType> offsetData) {
        this.offsetData = offsetData;
    }
}
