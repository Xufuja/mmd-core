package dev.xfj.format.pmx;

import java.util.List;

public class PMXFile {
    private String signature;
    private Float version;
    private Byte globalsCount;
    private PMXFileGlobals globals;
    private String modelNameJapanese;
    private String modelNameEnglish;
    private String commentsJapanese;
    private String commentsEnglish;
    private Integer vertextCount;
    private List<PMXFileVertex> vertices;
    private Integer surfaceCount;
    private List<PMXFileVertexIndex> surfaces;
    private Integer textureCount;
    private List<String> texturePaths;
    private Integer materialCount;
    private List<PMXFileMaterial> materials;
    private Integer boneCount;
    private List<PMXFileBone> bones;
    private Integer morphCount;
    private List<PMXFileMorph> morphs;
    private Integer displayFrameCount;
    private List<PMXFileDisplayFrame> displayFrames;
    private Integer rigidBodyCount;
    private List<PMXFileRigidBody> rigidBodies;
    private Integer jointCount;
    private List<PMXFileJoint> joints;
    private Integer softBodyCount;
    private List<PMXFileSoftBody> softBodies;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Float getVersion() {
        return version;
    }

    public void setVersion(Float version) {
        this.version = version;
    }

    public Byte getGlobalsCount() {
        return globalsCount;
    }

    public void setGlobalsCount(Byte globalsCount) {
        this.globalsCount = globalsCount;
    }

    public PMXFileGlobals getGlobals() {
        return globals;
    }

    public void setGlobals(PMXFileGlobals globals) {
        this.globals = globals;
    }

    public String getModelNameJapanese() {
        return modelNameJapanese;
    }

    public void setModelNameJapanese(String modelNameJapanese) {
        this.modelNameJapanese = modelNameJapanese;
    }

    public String getModelNameEnglish() {
        return modelNameEnglish;
    }

    public void setModelNameEnglish(String modelNameEnglish) {
        this.modelNameEnglish = modelNameEnglish;
    }

    public String getCommentsJapanese() {
        return commentsJapanese;
    }

    public void setCommentsJapanese(String commentsJapanese) {
        this.commentsJapanese = commentsJapanese;
    }

    public String getCommentsEnglish() {
        return commentsEnglish;
    }

    public void setCommentsEnglish(String commentsEnglish) {
        this.commentsEnglish = commentsEnglish;
    }

    public Integer getVertextCount() {
        return vertextCount;
    }

    public void setVertextCount(Integer vertextCount) {
        this.vertextCount = vertextCount;
    }

    public List<PMXFileVertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<PMXFileVertex> vertices) {
        this.vertices = vertices;
    }

    public Integer getSurfaceCount() {
        return surfaceCount;
    }

    public void setSurfaceCount(Integer surfaceCount) {
        this.surfaceCount = surfaceCount;
    }

    public List<PMXFileVertexIndex> getSurfaces() {
        return surfaces;
    }

    public void setSurfaces(List<PMXFileVertexIndex> surfaces) {
        this.surfaces = surfaces;
    }

    public Integer getTextureCount() {
        return textureCount;
    }

    public void setTextureCount(Integer textureCount) {
        this.textureCount = textureCount;
    }

    public List<String> getTexturePaths() {
        return texturePaths;
    }

    public void setTexturePaths(List<String> texturePaths) {
        this.texturePaths = texturePaths;
    }

    public Integer getMaterialCount() {
        return materialCount;
    }

    public void setMaterialCount(Integer materialCount) {
        this.materialCount = materialCount;
    }

    public List<PMXFileMaterial> getMaterials() {
        return materials;
    }

    public void setMaterials(List<PMXFileMaterial> materials) {
        this.materials = materials;
    }

    public Integer getBoneCount() {
        return boneCount;
    }

    public void setBoneCount(Integer boneCount) {
        this.boneCount = boneCount;
    }

    public List<PMXFileBone> getBones() {
        return bones;
    }

    public void setBones(List<PMXFileBone> bones) {
        this.bones = bones;
    }

    public Integer getMorphCount() {
        return morphCount;
    }

    public void setMorphCount(Integer morphCount) {
        this.morphCount = morphCount;
    }

    public List<PMXFileMorph> getMorphs() {
        return morphs;
    }

    public void setMorphs(List<PMXFileMorph> morphs) {
        this.morphs = morphs;
    }

    public Integer getDisplayFrameCount() {
        return displayFrameCount;
    }

    public void setDisplayFrameCount(Integer displayFrameCount) {
        this.displayFrameCount = displayFrameCount;
    }

    public List<PMXFileDisplayFrame> getDisplayFrames() {
        return displayFrames;
    }

    public void setDisplayFrames(List<PMXFileDisplayFrame> displayFrames) {
        this.displayFrames = displayFrames;
    }

    public Integer getRigidBodyCount() {
        return rigidBodyCount;
    }

    public void setRigidBodyCount(Integer rigidBodyCount) {
        this.rigidBodyCount = rigidBodyCount;
    }

    public List<PMXFileRigidBody> getRigidBodies() {
        return rigidBodies;
    }

    public void setRigidBodies(List<PMXFileRigidBody> rigidBodies) {
        this.rigidBodies = rigidBodies;
    }

    public Integer getJointCount() {
        return jointCount;
    }

    public void setJointCount(Integer jointCount) {
        this.jointCount = jointCount;
    }

    public List<PMXFileJoint> getJoints() {
        return joints;
    }

    public void setJoints(List<PMXFileJoint> joints) {
        this.joints = joints;
    }

    public Integer getSoftBodyCount() {
        return softBodyCount;
    }

    public void setSoftBodyCount(Integer softBodyCount) {
        this.softBodyCount = softBodyCount;
    }

    public List<PMXFileSoftBody> getSoftBodies() {
        return softBodies;
    }

    public void setSoftBodies(List<PMXFileSoftBody> softBodies) {
        this.softBodies = softBodies;
    }
}
