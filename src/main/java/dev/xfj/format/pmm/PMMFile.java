package dev.xfj.format.pmm;

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
    private int currentFramePosition;
    private int horizontalScrollPosition;
    private int horizontalScale;
    private int boneOperationMethod;
    private byte lookingAt;
    private byte repeat;
    private byte playFromFrame;
    private byte playToFrame;
    private int playStartFrame;
    private int playEndFrame;
    private byte waveEnabled;
    private String waveFileName;
    private int aviOffsetX;
    private int aviOffsetY;
    private float aviScale;
    private String aviFileName;
    private int showAvi;
    private int backgroundImageOffsetX;
    private int backgroundImageOffsetY;
    private float backgroundImageScale;
    private String backgroundImageFileName;
    private byte showBackgroundImage;
    private byte showInformation;
    private byte showAxis;
    private byte showGroundShadow;
    private float fpsLimit;
    private int screenCaptureMode;
    private int accessoryNumberRenderAfterModel;
    private float groundShadowBrightness;
    private byte transparentGroundShadow;
    private byte physicsMode;
    private PMMFileGravity pmmFileGravity;
    private byte showSelfShadow;
    private PMMFileSelfShadow pmmFileSelfShadow;
    private int edgeColorR;
    private int edgeColorG;
    private int edgeColorB;
    private byte blackBackground;
    private int cameraLookingAtModelCurrent;
    private int cameraLookingAtBoneCurrent;
    private float unknownFloat01;
    private float unknownFloat02;
    private float unknownFloat03;
    private float unknownFloat04;
    private float unknownFloat05;
    private float unknownFloat06;
    private float unknownFloat07;
    private float unknownFloat08;
    private float unknownFloat09;
    private float unknownFloat10;
    private float unknownFloat11;
    private float unknownFloat12;
    private float unknownFloat13;
    private float unknownFloat14;
    private float unknownFloat15;
    private float unknownFloat16;
    private byte eyeTrackingEnabled;
    private byte unknownByte01;
    private byte groundPhysicsEnabled;
    private int frameTextBox;
    private byte selectorChoiceFollowing;
    private List<PMMFileSelectorChoice> pmmFileSelectorChoices;

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

    public int getCurrentFramePosition() {
        return currentFramePosition;
    }

    public void setCurrentFramePosition(int currentFramePosition) {
        this.currentFramePosition = currentFramePosition;
    }

    public int getHorizontalScrollPosition() {
        return horizontalScrollPosition;
    }

    public void setHorizontalScrollPosition(int horizontalScrollPosition) {
        this.horizontalScrollPosition = horizontalScrollPosition;
    }

    public int getHorizontalScale() {
        return horizontalScale;
    }

    public void setHorizontalScale(int horizontalScale) {
        this.horizontalScale = horizontalScale;
    }

    public int getBoneOperationMethod() {
        return boneOperationMethod;
    }

    public void setBoneOperationMethod(int boneOperationMethod) {
        this.boneOperationMethod = boneOperationMethod;
    }

    public byte getLookingAt() {
        return lookingAt;
    }

    public void setLookingAt(byte lookingAt) {
        this.lookingAt = lookingAt;
    }

    public byte getRepeat() {
        return repeat;
    }

    public void setRepeat(byte repeat) {
        this.repeat = repeat;
    }

    public byte getPlayFromFrame() {
        return playFromFrame;
    }

    public void setPlayFromFrame(byte playFromFrame) {
        this.playFromFrame = playFromFrame;
    }

    public byte getPlayToFrame() {
        return playToFrame;
    }

    public void setPlayToFrame(byte playToFrame) {
        this.playToFrame = playToFrame;
    }

    public int getPlayStartFrame() {
        return playStartFrame;
    }

    public void setPlayStartFrame(int playStartFrame) {
        this.playStartFrame = playStartFrame;
    }

    public int getPlayEndFrame() {
        return playEndFrame;
    }

    public void setPlayEndFrame(int playEndFrame) {
        this.playEndFrame = playEndFrame;
    }

    public byte getWaveEnabled() {
        return waveEnabled;
    }

    public void setWaveEnabled(byte waveEnabled) {
        this.waveEnabled = waveEnabled;
    }

    public String getWaveFileName() {
        return waveFileName;
    }

    public void setWaveFileName(String waveFileName) {
        this.waveFileName = waveFileName;
    }

    public int getAviOffsetX() {
        return aviOffsetX;
    }

    public void setAviOffsetX(int aviOffsetX) {
        this.aviOffsetX = aviOffsetX;
    }

    public int getAviOffsetY() {
        return aviOffsetY;
    }

    public void setAviOffsetY(int aviOffsetY) {
        this.aviOffsetY = aviOffsetY;
    }

    public float getAviScale() {
        return aviScale;
    }

    public void setAviScale(float aviScale) {
        this.aviScale = aviScale;
    }

    public String getAviFileName() {
        return aviFileName;
    }

    public void setAviFileName(String aviFileName) {
        this.aviFileName = aviFileName;
    }

    public int getShowAvi() {
        return showAvi;
    }

    public void setShowAvi(int showAvi) {
        this.showAvi = showAvi;
    }

    public int getBackgroundImageOffsetX() {
        return backgroundImageOffsetX;
    }

    public void setBackgroundImageOffsetX(int backgroundImageOffsetX) {
        this.backgroundImageOffsetX = backgroundImageOffsetX;
    }

    public int getBackgroundImageOffsetY() {
        return backgroundImageOffsetY;
    }

    public void setBackgroundImageOffsetY(int backgroundImageOffsetY) {
        this.backgroundImageOffsetY = backgroundImageOffsetY;
    }

    public float getBackgroundImageScale() {
        return backgroundImageScale;
    }

    public void setBackgroundImageScale(float backgroundImageScale) {
        this.backgroundImageScale = backgroundImageScale;
    }

    public String getBackgroundImageFileName() {
        return backgroundImageFileName;
    }

    public void setBackgroundImageFileName(String backgroundImageFileName) {
        this.backgroundImageFileName = backgroundImageFileName;
    }

    public byte getShowBackgroundImage() {
        return showBackgroundImage;
    }

    public void setShowBackgroundImage(byte showBackgroundImage) {
        this.showBackgroundImage = showBackgroundImage;
    }

    public byte getShowInformation() {
        return showInformation;
    }

    public void setShowInformation(byte showInformation) {
        this.showInformation = showInformation;
    }

    public byte getShowAxis() {
        return showAxis;
    }

    public void setShowAxis(byte showAxis) {
        this.showAxis = showAxis;
    }

    public byte getShowGroundShadow() {
        return showGroundShadow;
    }

    public void setShowGroundShadow(byte showGroundShadow) {
        this.showGroundShadow = showGroundShadow;
    }

    public float getFpsLimit() {
        return fpsLimit;
    }

    public void setFpsLimit(float fpsLimit) {
        this.fpsLimit = fpsLimit;
    }

    public int getScreenCaptureMode() {
        return screenCaptureMode;
    }

    public void setScreenCaptureMode(int screenCaptureMode) {
        this.screenCaptureMode = screenCaptureMode;
    }

    public int getAccessoryNumberRenderAfterModel() {
        return accessoryNumberRenderAfterModel;
    }

    public void setAccessoryNumberRenderAfterModel(int accessoryNumberRenderAfterModel) {
        this.accessoryNumberRenderAfterModel = accessoryNumberRenderAfterModel;
    }

    public float getGroundShadowBrightness() {
        return groundShadowBrightness;
    }

    public void setGroundShadowBrightness(float groundShadowBrightness) {
        this.groundShadowBrightness = groundShadowBrightness;
    }

    public byte getTransparentGroundShadow() {
        return transparentGroundShadow;
    }

    public void setTransparentGroundShadow(byte transparentGroundShadow) {
        this.transparentGroundShadow = transparentGroundShadow;
    }

    public byte getPhysicsMode() {
        return physicsMode;
    }

    public void setPhysicsMode(byte physicsMode) {
        this.physicsMode = physicsMode;
    }

    public PMMFileGravity getPmmFileGravity() {
        return pmmFileGravity;
    }

    public void setPmmFileGravity(PMMFileGravity pmmFileGravity) {
        this.pmmFileGravity = pmmFileGravity;
    }

    public byte getShowSelfShadow() {
        return showSelfShadow;
    }

    public void setShowSelfShadow(byte showSelfShadow) {
        this.showSelfShadow = showSelfShadow;
    }

    public PMMFileSelfShadow getPmmFileSelfShadow() {
        return pmmFileSelfShadow;
    }

    public void setPmmFileSelfShadow(PMMFileSelfShadow pmmFileSelfShadow) {
        this.pmmFileSelfShadow = pmmFileSelfShadow;
    }

    public int getEdgeColorR() {
        return edgeColorR;
    }

    public void setEdgeColorR(int edgeColorR) {
        this.edgeColorR = edgeColorR;
    }

    public int getEdgeColorG() {
        return edgeColorG;
    }

    public void setEdgeColorG(int edgeColorG) {
        this.edgeColorG = edgeColorG;
    }

    public int getEdgeColorB() {
        return edgeColorB;
    }

    public void setEdgeColorB(int edgeColorB) {
        this.edgeColorB = edgeColorB;
    }

    public byte getBlackBackground() {
        return blackBackground;
    }

    public void setBlackBackground(byte blackBackground) {
        this.blackBackground = blackBackground;
    }

    public int getCameraLookingAtModelCurrent() {
        return cameraLookingAtModelCurrent;
    }

    public void setCameraLookingAtModelCurrent(int cameraLookingAtModelCurrent) {
        this.cameraLookingAtModelCurrent = cameraLookingAtModelCurrent;
    }

    public int getCameraLookingAtBoneCurrent() {
        return cameraLookingAtBoneCurrent;
    }

    public void setCameraLookingAtBoneCurrent(int cameraLookingAtBoneCurrent) {
        this.cameraLookingAtBoneCurrent = cameraLookingAtBoneCurrent;
    }

    public float getUnknownFloat01() {
        return unknownFloat01;
    }

    public void setUnknownFloat01(float unknownFloat01) {
        this.unknownFloat01 = unknownFloat01;
    }

    public float getUnknownFloat02() {
        return unknownFloat02;
    }

    public void setUnknownFloat02(float unknownFloat02) {
        this.unknownFloat02 = unknownFloat02;
    }

    public float getUnknownFloat03() {
        return unknownFloat03;
    }

    public void setUnknownFloat03(float unknownFloat03) {
        this.unknownFloat03 = unknownFloat03;
    }

    public float getUnknownFloat04() {
        return unknownFloat04;
    }

    public void setUnknownFloat04(float unknownFloat04) {
        this.unknownFloat04 = unknownFloat04;
    }

    public float getUnknownFloat05() {
        return unknownFloat05;
    }

    public void setUnknownFloat05(float unknownFloat05) {
        this.unknownFloat05 = unknownFloat05;
    }

    public float getUnknownFloat06() {
        return unknownFloat06;
    }

    public void setUnknownFloat06(float unknownFloat06) {
        this.unknownFloat06 = unknownFloat06;
    }

    public float getUnknownFloat07() {
        return unknownFloat07;
    }

    public void setUnknownFloat07(float unknownFloat07) {
        this.unknownFloat07 = unknownFloat07;
    }

    public float getUnknownFloat08() {
        return unknownFloat08;
    }

    public void setUnknownFloat08(float unknownFloat08) {
        this.unknownFloat08 = unknownFloat08;
    }

    public float getUnknownFloat09() {
        return unknownFloat09;
    }

    public void setUnknownFloat09(float unknownFloat09) {
        this.unknownFloat09 = unknownFloat09;
    }

    public float getUnknownFloat10() {
        return unknownFloat10;
    }

    public void setUnknownFloat10(float unknownFloat10) {
        this.unknownFloat10 = unknownFloat10;
    }

    public float getUnknownFloat11() {
        return unknownFloat11;
    }

    public void setUnknownFloat11(float unknownFloat11) {
        this.unknownFloat11 = unknownFloat11;
    }

    public float getUnknownFloat12() {
        return unknownFloat12;
    }

    public void setUnknownFloat12(float unknownFloat12) {
        this.unknownFloat12 = unknownFloat12;
    }

    public float getUnknownFloat13() {
        return unknownFloat13;
    }

    public void setUnknownFloat13(float unknownFloat13) {
        this.unknownFloat13 = unknownFloat13;
    }

    public float getUnknownFloat14() {
        return unknownFloat14;
    }

    public void setUnknownFloat14(float unknownFloat14) {
        this.unknownFloat14 = unknownFloat14;
    }

    public float getUnknownFloat15() {
        return unknownFloat15;
    }

    public void setUnknownFloat15(float unknownFloat15) {
        this.unknownFloat15 = unknownFloat15;
    }

    public float getUnknownFloat16() {
        return unknownFloat16;
    }

    public void setUnknownFloat16(float unknownFloat16) {
        this.unknownFloat16 = unknownFloat16;
    }

    public byte getEyeTrackingEnabled() {
        return eyeTrackingEnabled;
    }

    public void setEyeTrackingEnabled(byte eyeTrackingEnabled) {
        this.eyeTrackingEnabled = eyeTrackingEnabled;
    }

    public byte getUnknownByte01() {
        return unknownByte01;
    }

    public void setUnknownByte01(byte unknownByte01) {
        this.unknownByte01 = unknownByte01;
    }

    public byte getGroundPhysicsEnabled() {
        return groundPhysicsEnabled;
    }

    public void setGroundPhysicsEnabled(byte groundPhysicsEnabled) {
        this.groundPhysicsEnabled = groundPhysicsEnabled;
    }

    public int getFrameTextBox() {
        return frameTextBox;
    }

    public void setFrameTextBox(int frameTextBox) {
        this.frameTextBox = frameTextBox;
    }

    public byte getSelectorChoiceFollowing() {
        return selectorChoiceFollowing;
    }

    public void setSelectorChoiceFollowing(byte selectorChoiceFollowing) {
        this.selectorChoiceFollowing = selectorChoiceFollowing;
    }

    public List<PMMFileSelectorChoice> getPmmFileSelectorChoices() {
        return pmmFileSelectorChoices;
    }

    public void setPmmFileSelectorChoices(List<PMMFileSelectorChoice> pmmFileSelectorChoices) {
        this.pmmFileSelectorChoices = pmmFileSelectorChoices;
    }
}
