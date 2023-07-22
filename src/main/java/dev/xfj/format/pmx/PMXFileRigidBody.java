package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import org.joml.Vector3f;

public class PMXFileRigidBody {
    private String rigidBodyNameJapanese;
    private String rigidBodyNameEnglish;
    private IndexType<?> relatedBoneIndex;
    private Byte groupId;
    private Short nonCollisionGroup;
    private Byte shape;
    private Vector3f shapeSize;
    private Vector3f shapePosition;
    private Vector3f shapeRotation;
    private Float mass;
    private Float moveAttenuation;
    private Float rotationDamping;
    private Float repulsion;
    private Float frictionForce;
    private Byte physicsMode;

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

    public IndexType<?> getRelatedBoneIndex() {
        return relatedBoneIndex;
    }

    public void setRelatedBoneIndex(IndexType<?> relatedBoneIndex) {
        this.relatedBoneIndex = relatedBoneIndex;
    }

    public Byte getGroupId() {
        return groupId;
    }

    public void setGroupId(Byte groupId) {
        this.groupId = groupId;
    }

    public Short getNonCollisionGroup() {
        return nonCollisionGroup;
    }

    public void setNonCollisionGroup(Short nonCollisionGroup) {
        this.nonCollisionGroup = nonCollisionGroup;
    }

    public Byte getShape() {
        return shape;
    }

    public void setShape(Byte shape) {
        this.shape = shape;
    }

    public Vector3f getShapeSize() {
        return shapeSize;
    }

    public void setShapeSize(Vector3f shapeSize) {
        this.shapeSize = shapeSize;
    }

    public Vector3f getShapePosition() {
        return shapePosition;
    }

    public void setShapePosition(Vector3f shapePosition) {
        this.shapePosition = shapePosition;
    }

    public Vector3f getShapeRotation() {
        return shapeRotation;
    }

    public void setShapeRotation(Vector3f shapeRotation) {
        this.shapeRotation = shapeRotation;
    }

    public Float getMass() {
        return mass;
    }

    public void setMass(Float mass) {
        this.mass = mass;
    }

    public Float getMoveAttenuation() {
        return moveAttenuation;
    }

    public void setMoveAttenuation(Float moveAttenuation) {
        this.moveAttenuation = moveAttenuation;
    }

    public Float getRotationDamping() {
        return rotationDamping;
    }

    public void setRotationDamping(Float rotationDamping) {
        this.rotationDamping = rotationDamping;
    }

    public Float getRepulsion() {
        return repulsion;
    }

    public void setRepulsion(Float repulsion) {
        this.repulsion = repulsion;
    }

    public Float getFrictionForce() {
        return frictionForce;
    }

    public void setFrictionForce(Float frictionForce) {
        this.frictionForce = frictionForce;
    }

    public Byte getPhysicsMode() {
        return physicsMode;
    }

    public void setPhysicsMode(Byte physicsMode) {
        this.physicsMode = physicsMode;
    }
}
