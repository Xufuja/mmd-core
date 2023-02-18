package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import dev.xfj.types.vec.Vec4;

public class PMXFileMorphUV implements PMXFileMorphType {
    private IndexType vertexIndex;
    private Vec4 floats;

    public IndexType getVertexIndex() {
        return vertexIndex;
    }

    public void setVertexIndex(IndexType vertexIndex) {
        this.vertexIndex = vertexIndex;
    }

    public Vec4 getFloats() {
        return floats;
    }

    public void setFloats(Vec4 floats) {
        this.floats = floats;
    }
}
