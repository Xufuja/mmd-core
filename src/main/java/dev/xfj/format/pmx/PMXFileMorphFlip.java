package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;

public class PMXFileMorphFlip implements PMXFileMorphType {
    private IndexType<?> morphIndex;
    private Float influence;

    public IndexType<?> getMorphIndex() {
        return morphIndex;
    }

    public void setMorphIndex(IndexType<?> morphIndex) {
        this.morphIndex = morphIndex;
    }

    public Float getInfluence() {
        return influence;
    }

    public void setInfluence(Float influence) {
        this.influence = influence;
    }
}
