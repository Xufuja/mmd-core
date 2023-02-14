package dev.xfj.format.pmx;

import dev.xfj.vec.Vec3;

public class PMXFileMorphImpulse {
    private Object rigidBodyIndex;
    private byte localFlag;
    private Vec3 movementSpeed;
    private Vec3 rotationTorque;

    public Object getRigidBodyIndex() {
        return rigidBodyIndex;
    }

    public void setRigidBodyIndex(Object rigidBodyIndex) {
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
