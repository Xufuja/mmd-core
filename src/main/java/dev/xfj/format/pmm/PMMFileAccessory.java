package dev.xfj.format.pmm;

import java.util.List;

public class PMMFileAccessory {
    private byte accessoryIndex;
    private String accessoryName;
    private String accessoryFilePath;
    private byte renderOrder;
    private PMMFileAccessoryKeyframe accessoryInitialKeyframe;
    private int accessoryKeyframeCount;
    private List<PMMFileAccessoryKeyframeWithIndex> accessoryKeyframes;
    private PMMFileAccessoryData currentAccessoryData;
    private byte blend;

    public byte getAccessoryIndex() {
        return accessoryIndex;
    }

    public void setAccessoryIndex(byte accessoryIndex) {
        this.accessoryIndex = accessoryIndex;
    }

    public String getAccessoryName() {
        return accessoryName;
    }

    public void setAccessoryName(String accessoryName) {
        this.accessoryName = accessoryName;
    }

    public String getAccessoryFilePath() {
        return accessoryFilePath;
    }

    public void setAccessoryFilePath(String accessoryFilePath) {
        this.accessoryFilePath = accessoryFilePath;
    }

    public byte getRenderOrder() {
        return renderOrder;
    }

    public void setRenderOrder(byte renderOrder) {
        this.renderOrder = renderOrder;
    }

    public PMMFileAccessoryKeyframe getAccessoryInitialKeyframe() {
        return accessoryInitialKeyframe;
    }

    public void setAccessoryInitialKeyframe(PMMFileAccessoryKeyframe accessoryInitialKeyframe) {
        this.accessoryInitialKeyframe = accessoryInitialKeyframe;
    }

    public int getAccessoryKeyframeCount() {
        return accessoryKeyframeCount;
    }

    public void setAccessoryKeyframeCount(int accessoryKeyframeCount) {
        this.accessoryKeyframeCount = accessoryKeyframeCount;
    }

    public List<PMMFileAccessoryKeyframeWithIndex> getAccessoryKeyframes() {
        return accessoryKeyframes;
    }

    public void setAccessoryKeyframes(List<PMMFileAccessoryKeyframeWithIndex> accessoryKeyframes) {
        this.accessoryKeyframes = accessoryKeyframes;
    }

    public PMMFileAccessoryData getCurrentAccessoryData() {
        return currentAccessoryData;
    }

    public void setCurrentAccessoryData(PMMFileAccessoryData currentAccessoryData) {
        this.currentAccessoryData = currentAccessoryData;
    }

    public byte getBlend() {
        return blend;
    }

    public void setBlend(byte blend) {
        this.blend = blend;
    }
}
