package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import dev.xfj.types.vec.Vec3;

public class PMXFileRigidBody {
    private String rigidBodyNameJapanese;
    private String rigidBodyNameEnglish;
    private IndexType relatedBoneIndex;
    private byte groupId;
    private short nonCollisionGroup;
    private byte shape;
    private Vec3 shapeSize;
    private Vec3 shapePosition;
    private Vec3 shapeRotation;
    private float mass;
    private float moveAttenuation;
    private float rotationDamping;
    private float repulsion;
    private float frictionForce;
    private byte physicsMode;

    public String getRigidBodyNameJapanese() {
        return rigidBodyNameJapanese;
    }

    public void setRigidBodyNameJapanese(String rigidBodyNameJapanese) {
        this.rigidBodyNameJapanese = rigidBodyNameJapanese;
    }

    public String getRigidBodyNameEnglish() {
        return rigidBodyNameEnglish;
    }

    public void setRigidBodyNameEnglish(String rigidBodyNameEnglish) {
        this.rigidBodyNameEnglish = rigidBodyNameEnglish;
    }

    public IndexType getRelatedBoneIndex() {
        return relatedBoneIndex;
    }

    public void setRelatedBoneIndex(IndexType relatedBoneIndex) {
        this.relatedBoneIndex = relatedBoneIndex;
    }

    public byte getGroupId() {
        return groupId;
    }

    public void setGroupId(byte groupId) {
        this.groupId = groupId;
    }

    public short getNonCollisionGroup() {
        return nonCollisionGroup;
    }

    public void setNonCollisionGroup(short nonCollisionGroup) {
        this.nonCollisionGroup = nonCollisionGroup;
    }

    public byte getShape() {
        return shape;
    }

    public void setShape(byte shape) {
        this.shape = shape;
    }

    public Vec3 getShapeSize() {
        return shapeSize;
    }

    public void setShapeSize(Vec3 shapeSize) {
        this.shapeSize = shapeSize;
    }

    public Vec3 getShapePosition() {
        return shapePosition;
    }

    public void setShapePosition(Vec3 shapePosition) {
        this.shapePosition = shapePosition;
    }

    public Vec3 getShapeRotation() {
        return shapeRotation;
    }

    public void setShapeRotation(Vec3 shapeRotation) {
        this.shapeRotation = shapeRotation;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public float getMoveAttenuation() {
        return moveAttenuation;
    }

    public void setMoveAttenuation(float moveAttenuation) {
        this.moveAttenuation = moveAttenuation;
    }

    public float getRotationDamping() {
        return rotationDamping;
    }

    public void setRotationDamping(float rotationDamping) {
        this.rotationDamping = rotationDamping;
    }

    public float getRepulsion() {
        return repulsion;
    }

    public void setRepulsion(float repulsion) {
        this.repulsion = repulsion;
    }

    public float getFrictionForce() {
        return frictionForce;
    }

    public void setFrictionForce(float frictionForce) {
        this.frictionForce = frictionForce;
    }

    public byte getPhysicsMode() {
        return physicsMode;
    }

    public void setPhysicsMode(byte physicsMode) {
        this.physicsMode = physicsMode;
    }
}
