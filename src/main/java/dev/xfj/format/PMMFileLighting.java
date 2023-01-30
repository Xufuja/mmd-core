package dev.xfj.format;

import java.util.List;

public class PMMFileLighting {
    private PMMFileLightingKeyframe lightingInitialKeyframe;
    private int lightingKeyframeCount;
    private List<PMMFileLightingKeyframeWithIndex> lightingKeyframes;
    private PMMFileLightingData currentLightingData;

    public PMMFileLightingKeyframe getLightingInitialKeyframe() {
        return lightingInitialKeyframe;
    }

    public void setLightingInitialKeyframe(PMMFileLightingKeyframe lightingInitialKeyframe) {
        this.lightingInitialKeyframe = lightingInitialKeyframe;
    }

    public int getLightingKeyframeCount() {
        return lightingKeyframeCount;
    }

    public void setLightingKeyframeCount(int lightingKeyframeCount) {
        this.lightingKeyframeCount = lightingKeyframeCount;
    }

    public List<PMMFileLightingKeyframeWithIndex> getLightingKeyframes() {
        return lightingKeyframes;
    }

    public void setLightingKeyframes(List<PMMFileLightingKeyframeWithIndex> lightingKeyframes) {
        this.lightingKeyframes = lightingKeyframes;
    }

    public PMMFileLightingData getCurrentLightingData() {
        return currentLightingData;
    }

    public void setCurrentLightingData(PMMFileLightingData currentLightingData) {
        this.currentLightingData = currentLightingData;
    }
}
