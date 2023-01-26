package dev.xfj.format;

public class PMMFile {
    private String version;
    private int outputWidth;
    private int outputHeight;
    private int keyFrameEditorWidth;
    private float currentAngleOfView;
    private byte cameraLightingAccessory;
    private byte cameraPanel;
    private byte lightingPanel;
    private byte accessoryPanel;
    private byte bonePanel;
    private byte morphPanel;
    private byte selfShadowPanel;
    private byte selectedModelIndex;
    private byte modelCount;
    private byte modelIndex;
    private String modelNameJapanese;
    private String modelNameEnglish;
    private String modelFilePath;
    private byte keyFrameEditorTopRows;
    private int boneCount;
    private String boneName;
    private int morphCount;
    private String morphName;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getOutputWidth() {
        return outputWidth;
    }

    public void setOutputWidth(int outputWidth) {
        this.outputWidth = outputWidth;
    }

    public int getOutputHeight() {
        return outputHeight;
    }

    public void setOutputHeight(int outputHeight) {
        this.outputHeight = outputHeight;
    }

    public int getKeyFrameEditorWidth() {
        return keyFrameEditorWidth;
    }

    public void setKeyFrameEditorWidth(int keyFrameEditorWidth) {
        this.keyFrameEditorWidth = keyFrameEditorWidth;
    }

    public float getCurrentAngleOfView() {
        return currentAngleOfView;
    }

    public void setCurrentAngleOfView(float currentAngleOfView) {
        this.currentAngleOfView = currentAngleOfView;
    }

    public byte getCameraLightingAccessory() {
        return cameraLightingAccessory;
    }

    public void setCameraLightingAccessory(byte cameraLightingAccessory) {
        this.cameraLightingAccessory = cameraLightingAccessory;
    }

    public byte getCameraPanel() {
        return cameraPanel;
    }

    public void setCameraPanel(byte cameraPanel) {
        this.cameraPanel = cameraPanel;
    }

    public byte getLightingPanel() {
        return lightingPanel;
    }

    public void setLightingPanel(byte lightingPanel) {
        this.lightingPanel = lightingPanel;
    }

    public byte getAccessoryPanel() {
        return accessoryPanel;
    }

    public void setAccessoryPanel(byte accessoryPanel) {
        this.accessoryPanel = accessoryPanel;
    }

    public byte getBonePanel() {
        return bonePanel;
    }

    public void setBonePanel(byte bonePanel) {
        this.bonePanel = bonePanel;
    }

    public byte getMorphPanel() {
        return morphPanel;
    }

    public void setMorphPanel(byte morphPanel) {
        this.morphPanel = morphPanel;
    }

    public byte getSelfShadowPanel() {
        return selfShadowPanel;
    }

    public void setSelfShadowPanel(byte selfShadowPanel) {
        this.selfShadowPanel = selfShadowPanel;
    }

    public byte getSelectedModelIndex() {
        return selectedModelIndex;
    }

    public void setSelectedModelIndex(byte selectedModelIndex) {
        this.selectedModelIndex = selectedModelIndex;
    }

    public byte getModelCount() {
        return modelCount;
    }

    public void setModelCount(byte modelCount) {
        this.modelCount = modelCount;
    }

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

    public String getBoneName() {
        return boneName;
    }

    public void setBoneName(String boneName) {
        this.boneName = boneName;
    }

    public int getMorphCount() {
        return morphCount;
    }

    public void setMorphCount(int morphCount) {
        this.morphCount = morphCount;
    }

    public String getMorphName() {
        return morphName;
    }

    public void setMorphName(String morphName) {
        this.morphName = morphName;
    }
}
