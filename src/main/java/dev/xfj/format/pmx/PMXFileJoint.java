package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import org.joml.Vector3f;

public class PMXFileJoint {
    private String jointNameJapanese;
    private String jointNameEnglish;
    private Byte type;
    private IndexType<?> rigidBodyIndexA;
    private IndexType<?> rigidBodyIndexB;
    private Vector3f position;
    private Vector3f rotation;
    private Vector3f positionMinimum;
    private Vector3f positionMaximum;
    private Vector3f rotationMinimum;
    private Vector3f rotationMaximum;
    private Vector3f positionSpring;
    private Vector3f rotationSpring;

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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
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

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public Vector3f getRotation() {
        return rotation;
    }

    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }

    public Vector3f getPositionMinimum() {
        return positionMinimum;
    }

    public void setPositionMinimum(Vector3f positionMinimum) {
        this.positionMinimum = positionMinimum;
    }

    public Vector3f getPositionMaximum() {
        return positionMaximum;
    }

    public void setPositionMaximum(Vector3f positionMaximum) {
        this.positionMaximum = positionMaximum;
    }

    public Vector3f getRotationMinimum() {
        return rotationMinimum;
    }

    public void setRotationMinimum(Vector3f rotationMinimum) {
        this.rotationMinimum = rotationMinimum;
    }

    public Vector3f getRotationMaximum() {
        return rotationMaximum;
    }

    public void setRotationMaximum(Vector3f rotationMaximum) {
        this.rotationMaximum = rotationMaximum;
    }

    public Vector3f getPositionSpring() {
        return positionSpring;
    }

    public void setPositionSpring(Vector3f positionSpring) {
        this.positionSpring = positionSpring;
    }

    public Vector3f getRotationSpring() {
        return rotationSpring;
    }

    public void setRotationSpring(Vector3f rotationSpring) {
        this.rotationSpring = rotationSpring;
    }
}
