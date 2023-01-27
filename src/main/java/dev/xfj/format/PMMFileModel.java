package dev.xfj.format;

import java.util.List;

public class PMMFileModel {
    private byte modelIndex;
    private String modelNameJapanese;
    private String modelNameEnglish;
    private String modelFilePath;
    private byte keyFrameEditorTopRows;
    private int boneCount;
    private List<String> boneNames;
    private int morphCount;
    private List<String> morphNames;
    private int ikBoneCount;
    private List<Integer> ikBoneIndices;
    private int parentableBoneCount ;
    private List<Integer> parentableBoneIndices;
    private byte renderOrder;
    private byte visible;
    private int selectedBone;
    private int selectedBrowMorphIndex;
    private int selectedEyeMorphIndex;
    private int selectedLipMorphIndex;
    private int selectedOtherMorphIndex;
    private byte foldCount;
    private List<Byte> selectedFoldStatus;
    private int verticalScrollStatus;
    private int lastFrame;
    private List<PMMFileModelKeyframe> boneInitialKeyframes;
    private int boneKeyframeCount;
    private List<PMMFileModelKeyframeWithIndex> boneKeyframes;



    public byte getModelIndex() {
        return modelIndex;
    }

    public void setModelIndex(byte modelIndex) {
        this.modelIndex = modelIndex;
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

    public String getModelFilePath() {
        return modelFilePath;
    }

    public void setModelFilePath(String modelFilePath) {
        this.modelFilePath = modelFilePath;
    }

    public byte getKeyFrameEditorTopRows() {
        return keyFrameEditorTopRows;
    }

    public void setKeyFrameEditorTopRows(byte keyFrameEditorTopRows) {
        this.keyFrameEditorTopRows = keyFrameEditorTopRows;
    }

    public int getBoneCount() {
        return boneCount;
    }

    public void setBoneCount(int boneCount) {
        this.boneCount = boneCount;
    }

    public List<String> getBoneNames() {
        return boneNames;
    }

    public void setBoneNames(List<String> boneNames) {
        this.boneNames = boneNames;
    }

    public int getMorphCount() {
        return morphCount;
    }

    public void setMorphCount(int morphCount) {
        this.morphCount = morphCount;
    }

    public List<String> getMorphNames() {
        return morphNames;
    }

    public void setMorphNames(List<String> morphNames) {
        this.morphNames = morphNames;
    }

    public int getIkBoneCount() {
        return ikBoneCount;
    }

    public void setIkBoneCount(int ikBoneCount) {
        this.ikBoneCount = ikBoneCount;
    }

    public List<Integer> getIkBoneIndices() {
        return ikBoneIndices;
    }

    public void setIkBoneIndices(List<Integer> ikBoneIndices) {
        this.ikBoneIndices = ikBoneIndices;
    }

    public int getParentableBoneCount() {
        return parentableBoneCount;
    }

    public void setParentableBoneCount(int parentableBoneCount) {
        this.parentableBoneCount = parentableBoneCount;
    }

    public List<Integer> getParentableBoneIndices() {
        return parentableBoneIndices;
    }

    public void setParentableBoneIndices(List<Integer> parentableBoneIndices) {
        this.parentableBoneIndices = parentableBoneIndices;
    }

    public byte getRenderOrder() {
        return renderOrder;
    }

    public void setRenderOrder(byte renderOrder) {
        this.renderOrder = renderOrder;
    }

    public byte getVisible() {
        return visible;
    }

    public void setVisible(byte visible) {
        this.visible = visible;
    }

    public int getSelectedBone() {
        return selectedBone;
    }

    public void setSelectedBone(int selectedBone) {
        this.selectedBone = selectedBone;
    }

    public int getSelectedBrowMorphIndex() {
        return selectedBrowMorphIndex;
    }

    public void setSelectedBrowMorphIndex(int selectedBrowMorphIndex) {
        this.selectedBrowMorphIndex = selectedBrowMorphIndex;
    }

    public int getSelectedEyeMorphIndex() {
        return selectedEyeMorphIndex;
    }

    public void setSelectedEyeMorphIndex(int selectedEyeMorphIndex) {
        this.selectedEyeMorphIndex = selectedEyeMorphIndex;
    }

    public int getSelectedLipMorphIndex() {
        return selectedLipMorphIndex;
    }

    public void setSelectedLipMorphIndex(int selectedLipMorphIndex) {
        this.selectedLipMorphIndex = selectedLipMorphIndex;
    }

    public int getSelectedOtherMorphIndex() {
        return selectedOtherMorphIndex;
    }

    public void setSelectedOtherMorphIndex(int selectedOtherMorphIndex) {
        this.selectedOtherMorphIndex = selectedOtherMorphIndex;
    }

    public byte getFoldCount() {
        return foldCount;
    }

    public void setFoldCount(byte foldCount) {
        this.foldCount = foldCount;
    }

    public List<Byte> getSelectedFoldStatus() {
        return selectedFoldStatus;
    }

    public void setSelectedFoldStatus(List<Byte> selectedFoldStatus) {
        this.selectedFoldStatus = selectedFoldStatus;
    }

    public int getVerticalScrollStatus() {
        return verticalScrollStatus;
    }

    public void setVerticalScrollStatus(int verticalScrollStatus) {
        this.verticalScrollStatus = verticalScrollStatus;
    }

    public int getLastFrame() {
        return lastFrame;
    }

    public void setLastFrame(int lastFrame) {
        this.lastFrame = lastFrame;
    }

    public List<PMMFileModelKeyframe> getBoneInitialKeyframes() {
        return boneInitialKeyframes;
    }

    public void setBoneInitialKeyframes(List<PMMFileModelKeyframe> boneInitialKeyframes) {
        this.boneInitialKeyframes = boneInitialKeyframes;
    }

    public int getBoneKeyframeCount() {
        return boneKeyframeCount;
    }

    public void setBoneKeyframeCount(int boneKeyframeCount) {
        this.boneKeyframeCount = boneKeyframeCount;
    }

    public List<PMMFileModelKeyframeWithIndex> getBoneKeyframes() {
        return boneKeyframes;
    }

    public void setBoneKeyframes(List<PMMFileModelKeyframeWithIndex> boneKeyframes) {
        this.boneKeyframes = boneKeyframes;
    }
}
