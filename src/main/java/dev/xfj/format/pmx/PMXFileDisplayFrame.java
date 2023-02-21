package dev.xfj.format.pmx;

import java.util.List;

public class PMXFileDisplayFrame {
    private String displayFrameNameJapanese;
    private String displayFrameNameEnglish;
    private Byte specialFlag;
    private Integer frameCount;
    private List<PMXFileDisplayFrameData> frames;

    public String getDisplayFrameNameJapanese() {
        return displayFrameNameJapanese;
    }

    public void setDisplayFrameNameJapanese(String displayFrameNameJapanese) {
        this.displayFrameNameJapanese = displayFrameNameJapanese;
    }

    public String getDisplayFrameNameEnglish() {
        return displayFrameNameEnglish;
    }

    public void setDisplayFrameNameEnglish(String displayFrameNameEnglish) {
        this.displayFrameNameEnglish = displayFrameNameEnglish;
    }

    public Byte getSpecialFlag() {
        return specialFlag;
    }

    public void setSpecialFlag(Byte specialFlag) {
        this.specialFlag = specialFlag;
    }

    public Integer getFrameCount() {
        return frameCount;
    }

    public void setFrameCount(Integer frameCount) {
        this.frameCount = frameCount;
    }

    public List<PMXFileDisplayFrameData> getFrames() {
        return frames;
    }

    public void setFrames(List<PMXFileDisplayFrameData> frames) {
        this.frames = frames;
    }
}
