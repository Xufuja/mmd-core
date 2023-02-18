package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import dev.xfj.types.vec.Vec3;

public class PMXFileJoint {
    private String jointNameJapanese;
    private String jointNameEnglish;
    private byte type;
    private IndexType<?> rigidBodyIndexA;
    private IndexType<?> rigidBodyIndexB;
    private Vec3 position;
    private Vec3 rotation;
    private Vec3 positionMinimum;
    private Vec3 positionMaximum;
    private Vec3 rotationMinimum;
    private Vec3 rotationMaximum;
    private Vec3 positionSpring;
    private Vec3 rotationSpring;

    public String getJointNameJapanese() {
        return jointNameJapanese;
    }

    public void setJointNameJapanese(String jointNameJapanese) {
        this.jointNameJapanese = jointNameJapanese;
    }

    public String getJointNameEnglish() {
        return jointNameEnglish;
    }

    public void setJointNameEnglish(String jointNameEnglish) {
        this.jointNameEnglish = jointNameEnglish;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public IndexType<?> getRigidBodyIndexA() {
        return rigidBodyIndexA;
    }

    public void setRigidBodyIndexA(IndexType<?> rigidBodyIndexA) {
        this.rigidBodyIndexA = rigidBodyIndexA;
    }

    public IndexType<?> getRigidBodyIndexB() {
        return rigidBodyIndexB;
    }

    public void setRigidBodyIndexB(IndexType<?> rigidBodyIndexB) {
        this.rigidBodyIndexB = rigidBodyIndexB;
    }

    public Vec3 getPosition() {
        return position;
    }

    public void setPosition(Vec3 position) {
        this.position = position;
    }

    public Vec3 getRotation() {
        return rotation;
    }

    public void setRotation(Vec3 rotation) {
        this.rotation = rotation;
    }

    public Vec3 getPositionMinimum() {
        return positionMinimum;
    }

    public void setPositionMinimum(Vec3 positionMinimum) {
        this.positionMinimum = positionMinimum;
    }

    public Vec3 getPositionMaximum() {
        return positionMaximum;
    }

    public void setPositionMaximum(Vec3 positionMaximum) {
        this.positionMaximum = positionMaximum;
    }

    public Vec3 getRotationMinimum() {
        return rotationMinimum;
    }

    public void setRotationMinimum(Vec3 rotationMinimum) {
        this.rotationMinimum = rotationMinimum;
    }

    public Vec3 getRotationMaximum() {
        return rotationMaximum;
    }

    public void setRotationMaximum(Vec3 rotationMaximum) {
        this.rotationMaximum = rotationMaximum;
    }

    public Vec3 getPositionSpring() {
        return positionSpring;
    }

    public void setPositionSpring(Vec3 positionSpring) {
        this.positionSpring = positionSpring;
    }

    public Vec3 getRotationSpring() {
        return rotationSpring;
    }

    public void setRotationSpring(Vec3 rotationSpring) {
        this.rotationSpring = rotationSpring;
    }
}
