package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import dev.xfj.types.vec.Vec3;

public class PMXFileMorphImpulse implements PMXFileMorphType {
    private IndexType<?> rigidBodyIndex;
    private byte localFlag;
    private Vec3 movementSpeed;
    private Vec3 rotationTorque;

    public IndexType<?> getRigidBodyIndex() {
        return rigidBodyIndex;
    }

    public void setRigidBodyIndex(IndexType<?> rigidBodyIndex) {
        this.rigidBodyIndex = rigidBodyIndex;
    }

    public byte getLocalFlag() {
        return localFlag;
    }

    public void setLocalFlag(byte localFlag) {
        this.localFlag = localFlag;
    }

    public Vec3 getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(Vec3 movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public Vec3 getRotationTorque() {
        return rotationTorque;
    }

    public void setRotationTorque(Vec3 rotationTorque) {
        this.rotationTorque = rotationTorque;
    }
}
