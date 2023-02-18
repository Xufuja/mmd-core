package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;

public class PMXFileMorphFlip implements PMXFileMorphType {
    private IndexType<?> morphIndex;
    private float influence;

    public IndexType<?> getMorphIndex() {
        return morphIndex;
    }

    public void setMorphIndex(IndexType<?> morphIndex) {
        this.morphIndex = morphIndex;
    }

    public float getInfluence() {
        return influence;
    }

    public void setInfluence(float influence) {
        this.influence = influence;
    }
}
