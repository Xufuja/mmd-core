package dev.xfj.format;

import java.util.List;

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
    private List<PMMFileModel> pmmFileModels;
    private PMMFileCamera pmmFileCamera;
    private PMMFileLighting pmmFileLighting;
    private byte selectedAccessory;
    private int verticalScroll;
    private byte accessoryCount;
    private List<String> accessoryNames;
    private List<PMMFileAccessory> pmmFileAccessories;


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

    public List<PMMFileModel> getPmmFileModels() {
        return pmmFileModels;
    }

    public void setPmmFileModels(List<PMMFileModel> pmmFileModels) {
        this.pmmFileModels = pmmFileModels;
    }

    public PMMFileCamera getPmmFileCamera() {
        return pmmFileCamera;
    }

    public void setPmmFileCamera(PMMFileCamera pmmFileCamera) {
        this.pmmFileCamera = pmmFileCamera;
    }

    public PMMFileLighting getPmmFileLighting() {
        return pmmFileLighting;
    }

    public void setPmmFileLighting(PMMFileLighting pmmFileLighting) {
        this.pmmFileLighting = pmmFileLighting;
    }

    public byte getSelectedAccessory() {
        return selectedAccessory;
    }

    public void setSelectedAccessory(byte selectedAccessory) {
        this.selectedAccessory = selectedAccessory;
    }

    public int getVerticalScroll() {
        return verticalScroll;
    }

    public void setVerticalScroll(int verticalScroll) {
        this.verticalScroll = verticalScroll;
    }

    public byte getAccessoryCount() {
        return accessoryCount;
    }

    public void setAccessoryCount(byte accessoryCount) {
        this.accessoryCount = accessoryCount;
    }

    public List<String> getAccessoryNames() {
        return accessoryNames;
    }

    public void setAccessoryNames(List<String> accessoryNames) {
        this.accessoryNames = accessoryNames;
    }

    public List<PMMFileAccessory> getPmmFileAccessories() {
        return pmmFileAccessories;
    }

    public void setPmmFileAccessories(List<PMMFileAccessory> pmmFileAccessories) {
        this.pmmFileAccessories = pmmFileAccessories;
    }
}
