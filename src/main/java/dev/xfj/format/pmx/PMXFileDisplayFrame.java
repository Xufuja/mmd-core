package dev.xfj.format.pmx;

import java.util.List;

public class PMXFileDisplayFrame {
    private String displayFrameNameJapanese;
    private String displayFrameNameEnglish;
    private byte specialFlag;
    private int frameCount;
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

    public byte getSpecialFlag() {
        return specialFlag;
    }

    public void setSpecialFlag(byte specialFlag) {
        this.specialFlag = specialFlag;
    }

    public int getFrameCount() {
        return frameCount;
    }

    public void setFrameCount(int frameCount) {
        this.frameCount = frameCount;
    }

    public List<PMXFileDisplayFrameData> getFrames() {
        return frames;
    }

    public void setFrames(List<PMXFileDisplayFrameData> frames) {
        this.frames = frames;
    }
}
