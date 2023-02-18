package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import dev.xfj.types.vec.Vec3;

public class PMXFileMorphVertex implements PMXFileMorphType {
    private IndexType vertexIndex;
    private Vec3 translation;

    public IndexType getVertexIndex() {
        return vertexIndex;
    }

    public void setVertexIndex(IndexType vertexIndex) {
        this.vertexIndex = vertexIndex;
    }

    public Vec3 getTranslation() {
        return translation;
    }

    public void setTranslation(Vec3 translation) {
        this.translation = translation;
    }
}
