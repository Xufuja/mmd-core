package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;

public class PMXFileSoftBodyAnchorRigidBody {
    private IndexType<?> rigidBodyIndex;
    private IndexType<?> vertexIndex;
    private byte nearMode;

    public IndexType<?> getRigidBodyIndex() {
        return rigidBodyIndex;
    }

    public void setRigidBodyIndex(IndexType<?> rigidBodyIndex) {
        this.rigidBodyIndex = rigidBodyIndex;
    }

    public IndexType<?> getVertexIndex() {
        return vertexIndex;
    }

    public void setVertexIndex(IndexType<?> vertexIndex) {
        this.vertexIndex = vertexIndex;
    }

    public byte getNearMode() {
        return nearMode;
    }

    public void setNearMode(byte nearMode) {
        this.nearMode = nearMode;
    }
}
