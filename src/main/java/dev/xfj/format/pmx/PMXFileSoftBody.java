package dev.xfj.format.pmx;

import java.util.List;

public class PMXFileSoftBody {
    private String softBodyNameJapanese;
    private String softBodyNameEnglish;
    private byte shape;
    private Object materialIndex;
    private byte groupId;
    private short nonCollisionGroup;
    private byte flags;
    private int bLinkCreateDistance;
    private int clusterCount;
    private float totalMass;
    private float collisionMargin;
    private int aerodynamicsModel;
    private float velocityCorrectionFactor;
    private float dampingCoefficient;
    private float dragCoefficient;
    private float liftCoefficient;
    private float pressureCoefficient;
    private float volumeConversationCoefficient;
    private float dynamicFrictionCoefficient;
    private float poseMatchingCoefficient;
    private float rigidContactHardness;
    private float kineticContactHardness;
    private float softContactHardness;
    private float anchorHardness;
    private float softRigidHardness;
    private float softKineticHardness;
    private float softSoftHardness;
    private float softRigidImpulseSplit;
    private float softKineticImpulseSplit;
    private float softSoftImpulseSplit;
    private int velocitySolverIterations;
    private int positionSolverIterations;
    private int driftSolverIterations;
    private int clusterSolverIterations;
    private int linearStiffnessCoefficient;
    private int angularStiffnessCoefficient;
    private int volumeStiffnessCoefficient;
    private int anchorRigidBodyCount;
    private List<PMXFileSoftBodyAnchorRigidBody> anchorRigidBodies;
    private int vertexPinCount;
    private List<Object> vertexPins;

    public String getSoftBodyNameJapanese() {
        return softBodyNameJapanese;
    }

    public void setSoftBodyNameJapanese(String softBodyNameJapanese) {
        this.softBodyNameJapanese = softBodyNameJapanese;
    }

    public String getSoftBodyNameEnglish() {
        return softBodyNameEnglish;
    }

    public void setSoftBodyNameEnglish(String softBodyNameEnglish) {
        this.softBodyNameEnglish = softBodyNameEnglish;
    }

    public byte getShape() {
        return shape;
    }

    public void setShape(byte shape) {
        this.shape = shape;
    }

    public Object getMaterialIndex() {
        return materialIndex;
    }

    public void setMaterialIndex(Object materialIndex) {
        this.materialIndex = materialIndex;
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

    public byte getFlags() {
        return flags;
    }

    public void setFlags(byte flags) {
        this.flags = flags;
    }

    public int getbLinkCreateDistance() {
        return bLinkCreateDistance;
    }

    public void setbLinkCreateDistance(int bLinkCreateDistance) {
        this.bLinkCreateDistance = bLinkCreateDistance;
    }

    public int getClusterCount() {
        return clusterCount;
    }

    public void setClusterCount(int clusterCount) {
        this.clusterCount = clusterCount;
    }

    public float getTotalMass() {
        return totalMass;
    }

    public void setTotalMass(float totalMass) {
        this.totalMass = totalMass;
    }

    public float getCollisionMargin() {
        return collisionMargin;
    }

    public void setCollisionMargin(float collisionMargin) {
        this.collisionMargin = collisionMargin;
    }

    public int getAerodynamicsModel() {
        return aerodynamicsModel;
    }

    public void setAerodynamicsModel(int aerodynamicsModel) {
        this.aerodynamicsModel = aerodynamicsModel;
    }

    public float getVelocityCorrectionFactor() {
        return velocityCorrectionFactor;
    }

    public void setVelocityCorrectionFactor(float velocityCorrectionFactor) {
        this.velocityCorrectionFactor = velocityCorrectionFactor;
    }

    public float getDampingCoefficient() {
        return dampingCoefficient;
    }

    public void setDampingCoefficient(float dampingCoefficient) {
        this.dampingCoefficient = dampingCoefficient;
    }

    public float getDragCoefficient() {
        return dragCoefficient;
    }

    public void setDragCoefficient(float dragCoefficient) {
        this.dragCoefficient = dragCoefficient;
    }

    public float getLiftCoefficient() {
        return liftCoefficient;
    }

    public void setLiftCoefficient(float liftCoefficient) {
        this.liftCoefficient = liftCoefficient;
    }

    public float getPressureCoefficient() {
        return pressureCoefficient;
    }

    public void setPressureCoefficient(float pressureCoefficient) {
        this.pressureCoefficient = pressureCoefficient;
    }

    public float getVolumeConversationCoefficient() {
        return volumeConversationCoefficient;
    }

    public void setVolumeConversationCoefficient(float volumeConversationCoefficient) {
        this.volumeConversationCoefficient = volumeConversationCoefficient;
    }

    public float getDynamicFrictionCoefficient() {
        return dynamicFrictionCoefficient;
    }

    public void setDynamicFrictionCoefficient(float dynamicFrictionCoefficient) {
        this.dynamicFrictionCoefficient = dynamicFrictionCoefficient;
    }

    public float getPoseMatchingCoefficient() {
        return poseMatchingCoefficient;
    }

    public void setPoseMatchingCoefficient(float poseMatchingCoefficient) {
        this.poseMatchingCoefficient = poseMatchingCoefficient;
    }

    public float getRigidContactHardness() {
        return rigidContactHardness;
    }

    public void setRigidContactHardness(float rigidContactHardness) {
        this.rigidContactHardness = rigidContactHardness;
    }

    public float getKineticContactHardness() {
        return kineticContactHardness;
    }

    public void setKineticContactHardness(float kineticContactHardness) {
        this.kineticContactHardness = kineticContactHardness;
    }

    public float getSoftContactHardness() {
        return softContactHardness;
    }

    public void setSoftContactHardness(float softContactHardness) {
        this.softContactHardness = softContactHardness;
    }

    public float getAnchorHardness() {
        return anchorHardness;
    }

    public void setAnchorHardness(float anchorHardness) {
        this.anchorHardness = anchorHardness;
    }

    public float getSoftRigidHardness() {
        return softRigidHardness;
    }

    public void setSoftRigidHardness(float softRigidHardness) {
        this.softRigidHardness = softRigidHardness;
    }

    public float getSoftKineticHardness() {
        return softKineticHardness;
    }

    public void setSoftKineticHardness(float softKineticHardness) {
        this.softKineticHardness = softKineticHardness;
    }

    public float getSoftSoftHardness() {
        return softSoftHardness;
    }

    public void setSoftSoftHardness(float softSoftHardness) {
        this.softSoftHardness = softSoftHardness;
    }

    public float getSoftRigidImpulseSplit() {
        return softRigidImpulseSplit;
    }

    public void setSoftRigidImpulseSplit(float softRigidImpulseSplit) {
        this.softRigidImpulseSplit = softRigidImpulseSplit;
    }

    public float getSoftKineticImpulseSplit() {
        return softKineticImpulseSplit;
    }

    public void setSoftKineticImpulseSplit(float softKineticImpulseSplit) {
        this.softKineticImpulseSplit = softKineticImpulseSplit;
    }

    public float getSoftSoftImpulseSplit() {
        return softSoftImpulseSplit;
    }

    public void setSoftSoftImpulseSplit(float softSoftImpulseSplit) {
        this.softSoftImpulseSplit = softSoftImpulseSplit;
    }

    public int getVelocitySolverIterations() {
        return velocitySolverIterations;
    }

    public void setVelocitySolverIterations(int velocitySolverIterations) {
        this.velocitySolverIterations = velocitySolverIterations;
    }

    public int getPositionSolverIterations() {
        return positionSolverIterations;
    }

    public void setPositionSolverIterations(int positionSolverIterations) {
        this.positionSolverIterations = positionSolverIterations;
    }

    public int getDriftSolverIterations() {
        return driftSolverIterations;
    }

    public void setDriftSolverIterations(int driftSolverIterations) {
        this.driftSolverIterations = driftSolverIterations;
    }

    public int getClusterSolverIterations() {
        return clusterSolverIterations;
    }

    public void setClusterSolverIterations(int clusterSolverIterations) {
        this.clusterSolverIterations = clusterSolverIterations;
    }

    public int getLinearStiffnessCoefficient() {
        return linearStiffnessCoefficient;
    }

    public void setLinearStiffnessCoefficient(int linearStiffnessCoefficient) {
        this.linearStiffnessCoefficient = linearStiffnessCoefficient;
    }

    public int getAngularStiffnessCoefficient() {
        return angularStiffnessCoefficient;
    }

    public void setAngularStiffnessCoefficient(int angularStiffnessCoefficient) {
        this.angularStiffnessCoefficient = angularStiffnessCoefficient;
    }

    public int getVolumeStiffnessCoefficient() {
        return volumeStiffnessCoefficient;
    }

    public void setVolumeStiffnessCoefficient(int volumeStiffnessCoefficient) {
        this.volumeStiffnessCoefficient = volumeStiffnessCoefficient;
    }

    public int getAnchorRigidBodyCount() {
        return anchorRigidBodyCount;
    }

    public void setAnchorRigidBodyCount(int anchorRigidBodyCount) {
        this.anchorRigidBodyCount = anchorRigidBodyCount;
    }

    public List<PMXFileSoftBodyAnchorRigidBody> getAnchorRigidBodies() {
        return anchorRigidBodies;
    }

    public void setAnchorRigidBodies(List<PMXFileSoftBodyAnchorRigidBody> anchorRigidBodies) {
        this.anchorRigidBodies = anchorRigidBodies;
    }

    public int getVertexPinCount() {
        return vertexPinCount;
    }

    public void setVertexPinCount(int vertexPinCount) {
        this.vertexPinCount = vertexPinCount;
    }

    public List<Object> getVertexPins() {
        return vertexPins;
    }

    public void setVertexPins(List<Object> vertexPins) {
        this.vertexPins = vertexPins;
    }
}
