package dev.xfj.format.pmm;

import java.util.List;

public class PMMFileSelfShadow {
    private float selfShadowDistance;
    private PMMFileSelfShadowKeyframe selfShadowInitialKeyframe;
    private int selfShadowKeyframeCount;
    private List<PMMFileSelfShadowKeyframeWithIndex> selfShadowKeyframes;

    public float getSelfShadowDistance() {
        return selfShadowDistance;
    }

    public void setSelfShadowDistance(float selfShadowDistance) {
        this.selfShadowDistance = selfShadowDistance;
    }

    public PMMFileSelfShadowKeyframe getSelfShadowInitialKeyframe() {
        return selfShadowInitialKeyframe;
    }

    public void setSelfShadowInitialKeyframe(PMMFileSelfShadowKeyframe selfShadowInitialKeyframe) {
        this.selfShadowInitialKeyframe = selfShadowInitialKeyframe;
    }

    public int getSelfShadowKeyframeCount() {
        return selfShadowKeyframeCount;
    }

    public void setSelfShadowKeyframeCount(int selfShadowKeyframeCount) {
        this.selfShadowKeyframeCount = selfShadowKeyframeCount;
    }

    public List<PMMFileSelfShadowKeyframeWithIndex> getSelfShadowKeyframes() {
        return selfShadowKeyframes;
    }

    public void setSelfShadowKeyframes(List<PMMFileSelfShadowKeyframeWithIndex> selfShadowKeyframes) {
        this.selfShadowKeyframes = selfShadowKeyframes;
    }
}
