package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import dev.xfj.types.vec.Vec3;

import java.util.List;

public class PMXFileBone {
    private String boneNameJapanese;
    private String bonenameEnglish;
    private Vec3 position;
    private IndexType<?> parentBoneIndex;
    private Integer layer;
    private List<Integer> flags;
    private Object tailPosition;
    private IndexType<?> inheritParentIndex;
    private Float inheritParentInfluence;
    private Vec3 axisDirection;
    private Vec3 xVector;
    private Vec3 zVector;
    private IndexType<?> externalParentIndex;
    private IndexType<?> targetIndex;
    private Integer loopCount;
    private Float limitRadian;
    private Integer linkCount;
    private List<PMXFileBoneLink> ikLinks;

    public String getBoneNameJapanese() {
        return boneNameJapanese;
    }

    public void setBoneNameJapanese(String boneNameJapanese) {
        this.boneNameJapanese = boneNameJapanese;
    }

    public String getBonenameEnglish() {
        return bonenameEnglish;
    }

    public void setBonenameEnglish(String bonenameEnglish) {
        this.bonenameEnglish = bonenameEnglish;
    }

    public Vec3 getPosition() {
        return position;
    }

    public void setPosition(Vec3 position) {
        this.position = position;
    }

    public IndexType<?> getParentBoneIndex() {
        return parentBoneIndex;
    }

    public void setParentBoneIndex(IndexType<?> parentBoneIndex) {
        this.parentBoneIndex = parentBoneIndex;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public List<Integer> getFlags() {
        return flags;
    }

    public void setFlags(List<Integer> flags) {
        this.flags = flags;
    }

    public Object getTailPosition() {
        return tailPosition;
    }

    public void setTailPosition(Object tailPosition) {
        this.tailPosition = tailPosition;
    }

    public IndexType<?> getInheritParentIndex() {
        return inheritParentIndex;
    }

    public void setInheritParentIndex(IndexType<?> inheritParentIndex) {
        this.inheritParentIndex = inheritParentIndex;
    }

    public Float getInheritParentInfluence() {
        return inheritParentInfluence;
    }

    public void setInheritParentInfluence(Float inheritParentInfluence) {
        this.inheritParentInfluence = inheritParentInfluence;
    }

    public Vec3 getAxisDirection() {
        return axisDirection;
    }

    public void setAxisDirection(Vec3 axisDirection) {
        this.axisDirection = axisDirection;
    }

    public Vec3 getxVector() {
        return xVector;
    }

    public void setxVector(Vec3 xVector) {
        this.xVector = xVector;
    }

    public Vec3 getzVector() {
        return zVector;
    }

    public void setzVector(Vec3 zVector) {
        this.zVector = zVector;
    }

    public IndexType<?> getExternalParentIndex() {
        return externalParentIndex;
    }

    public void setExternalParentIndex(IndexType<?> externalParentIndex) {
        this.externalParentIndex = externalParentIndex;
    }

    public IndexType<?> getTargetIndex() {
        return targetIndex;
    }

    public void setTargetIndex(IndexType<?> targetIndex) {
        this.targetIndex = targetIndex;
    }

    public Integer getLoopCount() {
        return loopCount;
    }

    public void setLoopCount(Integer loopCount) {
        this.loopCount = loopCount;
    }

    public Float getLimitRadian() {
        return limitRadian;
    }

    public void setLimitRadian(Float limitRadian) {
        this.limitRadian = limitRadian;
    }

    public Integer getLinkCount() {
        return linkCount;
    }

    public void setLinkCount(Integer linkCount) {
        this.linkCount = linkCount;
    }

    public List<PMXFileBoneLink> getIkLinks() {
        return ikLinks;
    }

    public void setIkLinks(List<PMXFileBoneLink> ikLinks) {
        this.ikLinks = ikLinks;
    }
}
