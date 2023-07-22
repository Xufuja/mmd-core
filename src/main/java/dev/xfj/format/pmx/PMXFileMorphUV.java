package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import org.joml.Vector4f;

public class PMXFileMorphUV implements PMXFileMorphType {
    private IndexType<?> vertexIndex;
    private Vector4f floats;

    public IndexType<?> getVertexIndex() {
        return vertexIndex;
    }

    public void setVertexIndex(IndexType<?> vertexIndex) {
        this.vertexIndex = vertexIndex;
    }

    public Vector4f getFloats() {
        return floats;
    }

    public void setFloats(Vector4f floats) {
        this.floats = floats;
    }
}
