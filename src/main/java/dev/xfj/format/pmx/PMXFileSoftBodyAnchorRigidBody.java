package dev.xfj.format.pmx;

public class PMXFileSoftBodyAnchorRigidBody {
    private Object rigidBodyIndex;
    private Object vertexIndex;
    private byte nearMode;

    public Object getRigidBodyIndex() {
        return rigidBodyIndex;
    }

    public void setRigidBodyIndex(Object rigidBodyIndex) {
        this.rigidBodyIndex = rigidBodyIndex;
    }

    public Object getVertexIndex() {
        return vertexIndex;
    }

    public void setVertexIndex(Object vertexIndex) {
        this.vertexIndex = vertexIndex;
    }

    public byte getNearMode() {
        return nearMode;
    }

    public void setNearMode(byte nearMode) {
        this.nearMode = nearMode;
    }
}
