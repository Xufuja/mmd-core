package dev.xfj.format.pmx;

import dev.xfj.vec.Vec3;

public class PMXFileMorphVertex {
    private Object vertexIndex;
    private Vec3 translation;

    public Object getVertexIndex() {
        return vertexIndex;
    }

    public void setVertexIndex(Object vertexIndex) {
        this.vertexIndex = vertexIndex;
    }

    public Vec3 getTranslation() {
        return translation;
    }

    public void setTranslation(Vec3 translation) {
        this.translation = translation;
    }
}
