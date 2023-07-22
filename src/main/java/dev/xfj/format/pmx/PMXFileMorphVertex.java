package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import org.joml.Vector3f;

public class PMXFileMorphVertex implements PMXFileMorphType {
    private IndexType<?> vertexIndex;
    private Vector3f translation;

    public IndexType<?> getVertexIndex() {
        return vertexIndex;
    }

    public void setVertexIndex(IndexType<?> vertexIndex) {
        this.vertexIndex = vertexIndex;
    }

    public Vector3f getTranslation() {
        return translation;
    }

    public void setTranslation(Vector3f translation) {
        this.translation = translation;
    }
}
