package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import org.joml.Vector3f;

public class PMXFileMorphImpulse implements PMXFileMorphType {
    private IndexType<?> rigidBodyIndex;
    private Byte localFlag;
    private Vector3f movementSpeed;
    private Vector3f rotationTorque;

    public IndexType<?> getRigidBodyIndex() {
        return rigidBodyIndex;
    }

    public void setRigidBodyIndex(IndexType<?> rigidBodyIndex) {
        this.rigidBodyIndex = rigidBodyIndex;
    }

    public Byte getLocalFlag() {
        return localFlag;
    }

    public void setLocalFlag(Byte localFlag) {
        this.localFlag = localFlag;
    }

    public Vector3f getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(Vector3f movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public Vector3f getRotationTorque() {
        return rotationTorque;
    }

    public void setRotationTorque(Vector3f rotationTorque) {
        this.rotationTorque = rotationTorque;
    }
}
