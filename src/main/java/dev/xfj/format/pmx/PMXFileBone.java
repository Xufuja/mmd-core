package dev.xfj.format.pmx;

import dev.xfj.types.index.IndexType;
import org.joml.Vector3f;

import java.util.List;

public class PMXFileBone {
    private String boneNameJapanese;
    private String bonenameEnglish;
    private Vector3f position;
    private IndexType<?> parentBoneIndex;
    private Integer layer;
    private List<Integer> flags;
    private Object tailPosition;
    private IndexType<?> inheritParentIndex;
    private Float inheritParentInfluence;
    private Vector3f axisDirection;
    private Vector3f xVector;
    private Vector3f zVector;
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

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
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

    public Vector3f getAxisDirection() {
        return axisDirection;
    }

    public void setAxisDirection(Vector3f axisDirection) {
        this.axisDirection = axisDirection;
    }

    public Vector3f getxVector() {
        return xVector;
    }

    public void setxVector(Vector3f xVector) {
        this.xVector = xVector;
    }

    public Vector3f getzVector() {
        return zVector;
    }

    public void setzVector(Vector3f zVector) {
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
