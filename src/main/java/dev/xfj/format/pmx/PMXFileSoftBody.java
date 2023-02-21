package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;

import java.util.List;

public class PMXFileSoftBody {
    private String softBodyNameJapanese;
    private String softBodyNameEnglish;
    private Byte shape;
    private IndexType<?> materialIndex;
    private Byte groupId;
    private Short nonCollisionGroup;
    private Byte flags;
    private Integer bLinkCreateDistance;
    private Integer clusterCount;
    private Float totalMass;
    private Float collisionMargin;
    private Integer aerodynamicsModel;
    private Float velocityCorrectionFactor;
    private Float dampingCoefficient;
    private Float dragCoefficient;
    private Float liftCoefficient;
    private Float pressureCoefficient;
    private Float volumeConversationCoefficient;
    private Float dynamicFrictionCoefficient;
    private Float poseMatchingCoefficient;
    private Float rigidContactHardness;
    private Float kineticContactHardness;
    private Float softContactHardness;
    private Float anchorHardness;
    private Float softRigidHardness;
    private Float softKineticHardness;
    private Float softSoftHardness;
    private Float softRigidImpulseSplit;
    private Float softKineticImpulseSplit;
    private Float softSoftImpulseSplit;
    private Integer velocitySolverIterations;
    private Integer positionSolverIterations;
    private Integer driftSolverIterations;
    private Integer clusterSolverIterations;
    private Integer linearStiffnessCoefficient;
    private Integer angularStiffnessCoefficient;
    private Integer volumeStiffnessCoefficient;
    private Integer anchorRigidBodyCount;
    private List<PMXFileSoftBodyAnchorRigidBody> anchorRigidBodies;
    private Integer vertexPinCount;
    private List<IndexType<?>> vertexPins;

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

    public Byte getShape() {
        return shape;
    }

    public void setShape(Byte shape) {
        this.shape = shape;
    }

    public IndexType<?> getMaterialIndex() {
        return materialIndex;
    }

    public void setMaterialIndex(IndexType<?> materialIndex) {
        this.materialIndex = materialIndex;
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

    public Byte getFlags() {
        return flags;
    }

    public void setFlags(Byte flags) {
        this.flags = flags;
    }

    public Integer getbLinkCreateDistance() {
        return bLinkCreateDistance;
    }

    public void setbLinkCreateDistance(Integer bLinkCreateDistance) {
        this.bLinkCreateDistance = bLinkCreateDistance;
    }

    public Integer getClusterCount() {
        return clusterCount;
    }

    public void setClusterCount(Integer clusterCount) {
        this.clusterCount = clusterCount;
    }

    public Float getTotalMass() {
        return totalMass;
    }

    public void setTotalMass(Float totalMass) {
        this.totalMass = totalMass;
    }

    public Float getCollisionMargin() {
        return collisionMargin;
    }

    public void setCollisionMargin(Float collisionMargin) {
        this.collisionMargin = collisionMargin;
    }

    public Integer getAerodynamicsModel() {
        return aerodynamicsModel;
    }

    public void setAerodynamicsModel(Integer aerodynamicsModel) {
        this.aerodynamicsModel = aerodynamicsModel;
    }

    public Float getVelocityCorrectionFactor() {
        return velocityCorrectionFactor;
    }

    public void setVelocityCorrectionFactor(Float velocityCorrectionFactor) {
        this.velocityCorrectionFactor = velocityCorrectionFactor;
    }

    public Float getDampingCoefficient() {
        return dampingCoefficient;
    }

    public void setDampingCoefficient(Float dampingCoefficient) {
        this.dampingCoefficient = dampingCoefficient;
    }

    public Float getDragCoefficient() {
        return dragCoefficient;
    }

    public void setDragCoefficient(Float dragCoefficient) {
        this.dragCoefficient = dragCoefficient;
    }

    public Float getLiftCoefficient() {
        return liftCoefficient;
    }

    public void setLiftCoefficient(Float liftCoefficient) {
        this.liftCoefficient = liftCoefficient;
    }

    public Float getPressureCoefficient() {
        return pressureCoefficient;
    }

    public void setPressureCoefficient(Float pressureCoefficient) {
        this.pressureCoefficient = pressureCoefficient;
    }

    public Float getVolumeConversationCoefficient() {
        return volumeConversationCoefficient;
    }

    public void setVolumeConversationCoefficient(Float volumeConversationCoefficient) {
        this.volumeConversationCoefficient = volumeConversationCoefficient;
    }

    public Float getDynamicFrictionCoefficient() {
        return dynamicFrictionCoefficient;
    }

    public void setDynamicFrictionCoefficient(Float dynamicFrictionCoefficient) {
        this.dynamicFrictionCoefficient = dynamicFrictionCoefficient;
    }

    public Float getPoseMatchingCoefficient() {
        return poseMatchingCoefficient;
    }

    public void setPoseMatchingCoefficient(Float poseMatchingCoefficient) {
        this.poseMatchingCoefficient = poseMatchingCoefficient;
    }

    public Float getRigidContactHardness() {
        return rigidContactHardness;
    }

    public void setRigidContactHardness(Float rigidContactHardness) {
        this.rigidContactHardness = rigidContactHardness;
    }

    public Float getKineticContactHardness() {
        return kineticContactHardness;
    }

    public void setKineticContactHardness(Float kineticContactHardness) {
        this.kineticContactHardness = kineticContactHardness;
    }

    public Float getSoftContactHardness() {
        return softContactHardness;
    }

    public void setSoftContactHardness(Float softContactHardness) {
        this.softContactHardness = softContactHardness;
    }

    public Float getAnchorHardness() {
        return anchorHardness;
    }

    public void setAnchorHardness(Float anchorHardness) {
        this.anchorHardness = anchorHardness;
    }

    public Float getSoftRigidHardness() {
        return softRigidHardness;
    }

    public void setSoftRigidHardness(Float softRigidHardness) {
        this.softRigidHardness = softRigidHardness;
    }

    public Float getSoftKineticHardness() {
        return softKineticHardness;
    }

    public void setSoftKineticHardness(Float softKineticHardness) {
        this.softKineticHardness = softKineticHardness;
    }

    public Float getSoftSoftHardness() {
        return softSoftHardness;
    }

    public void setSoftSoftHardness(Float softSoftHardness) {
        this.softSoftHardness = softSoftHardness;
    }

    public Float getSoftRigidImpulseSplit() {
        return softRigidImpulseSplit;
    }

    public void setSoftRigidImpulseSplit(Float softRigidImpulseSplit) {
        this.softRigidImpulseSplit = softRigidImpulseSplit;
    }

    public Float getSoftKineticImpulseSplit() {
        return softKineticImpulseSplit;
    }

    public void setSoftKineticImpulseSplit(Float softKineticImpulseSplit) {
        this.softKineticImpulseSplit = softKineticImpulseSplit;
    }

    public Float getSoftSoftImpulseSplit() {
        return softSoftImpulseSplit;
    }

    public void setSoftSoftImpulseSplit(Float softSoftImpulseSplit) {
        this.softSoftImpulseSplit = softSoftImpulseSplit;
    }

    public Integer getVelocitySolverIterations() {
        return velocitySolverIterations;
    }

    public void setVelocitySolverIterations(Integer velocitySolverIterations) {
        this.velocitySolverIterations = velocitySolverIterations;
    }

    public Integer getPositionSolverIterations() {
        return positionSolverIterations;
    }

    public void setPositionSolverIterations(Integer positionSolverIterations) {
        this.positionSolverIterations = positionSolverIterations;
    }

    public Integer getDriftSolverIterations() {
        return driftSolverIterations;
    }

    public void setDriftSolverIterations(Integer driftSolverIterations) {
        this.driftSolverIterations = driftSolverIterations;
    }

    public Integer getClusterSolverIterations() {
        return clusterSolverIterations;
    }

    public void setClusterSolverIterations(Integer clusterSolverIterations) {
        this.clusterSolverIterations = clusterSolverIterations;
    }

    public Integer getLinearStiffnessCoefficient() {
        return linearStiffnessCoefficient;
    }

    public void setLinearStiffnessCoefficient(Integer linearStiffnessCoefficient) {
        this.linearStiffnessCoefficient = linearStiffnessCoefficient;
    }

    public Integer getAngularStiffnessCoefficient() {
        return angularStiffnessCoefficient;
    }

    public void setAngularStiffnessCoefficient(Integer angularStiffnessCoefficient) {
        this.angularStiffnessCoefficient = angularStiffnessCoefficient;
    }

    public Integer getVolumeStiffnessCoefficient() {
        return volumeStiffnessCoefficient;
    }

    public void setVolumeStiffnessCoefficient(Integer volumeStiffnessCoefficient) {
        this.volumeStiffnessCoefficient = volumeStiffnessCoefficient;
    }

    public Integer getAnchorRigidBodyCount() {
        return anchorRigidBodyCount;
    }

    public void setAnchorRigidBodyCount(Integer anchorRigidBodyCount) {
        this.anchorRigidBodyCount = anchorRigidBodyCount;
    }

    public List<PMXFileSoftBodyAnchorRigidBody> getAnchorRigidBodies() {
        return anchorRigidBodies;
    }

    public void setAnchorRigidBodies(List<PMXFileSoftBodyAnchorRigidBody> anchorRigidBodies) {
        this.anchorRigidBodies = anchorRigidBodies;
    }

    public Integer getVertexPinCount() {
        return vertexPinCount;
    }

    public void setVertexPinCount(Integer vertexPinCount) {
        this.vertexPinCount = vertexPinCount;
    }

    public List<IndexType<?>> getVertexPins() {
        return vertexPins;
    }

    public void setVertexPins(List<IndexType<?>> vertexPins) {
        this.vertexPins = vertexPins;
    }
}
