package dev.xfj.parsing;

import dev.xfj.format.pmm.*;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PMMParser extends Parser {
    public final static int FILE_FORMAT_VERSION_LENGTH = 30;
    public final static int NAME_LENGTH = 100;
    public final static int FILE_NAME_LENGTH = 256;
    public final static int FILE_PATH_LENGTH = 256;

    public PMMParser(Path path) throws IOException {
        super(path);
    }

    //Based on https://drive.google.com/file/d/0B6jwWdrYAgJTdXZSd1Noa2hKbmM/view?resourcekey=0-96-_sPXYP3ItPOQL7sca1A
    public PMMFile parse() {
        PMMFile pmmFile = new PMMFile();
        //Keeping track of the positions was tedious so just added a counter that increments after each read
        pmmFile.setVersion(getFixedString(FILE_FORMAT_VERSION_LENGTH));
        pmmFile.setOutputWidth(getInt32());
        pmmFile.setOutputHeight(getInt32());
        pmmFile.setKeyFrameEditorWidth(getInt32());
        pmmFile.setCurrentAngleOfView(getFloat());
        pmmFile.setCameraLightingAccessory(getByte());
        pmmFile.setCameraPanel(getByte());
        pmmFile.setLightingPanel(getByte());
        pmmFile.setAccessoryPanel(getByte());
        pmmFile.setBonePanel(getByte());
        pmmFile.setMorphPanel(getByte());
        pmmFile.setSelfShadowPanel(getByte());
        pmmFile.setSelectedModelIndex(getByte());
        pmmFile.setModelCount(getByte());
        pmmFile.setPmmFileModels(parseModels(pmmFile.getModelCount()));
        pmmFile.setPmmFileCamera(parseCamera());
        pmmFile.setPmmFileLighting(parseLighting());
        pmmFile.setSelectedAccessory(getByte());
        pmmFile.setVerticalScroll(getInt32());
        pmmFile.setAccessoryCount(getByte());
        pmmFile.setAccessoryNames(pmmFile.getAccessoryCount() > 0 ? IntStream.range(0, pmmFile.getAccessoryCount()).mapToObj(name -> getFixedString(NAME_LENGTH)).collect(Collectors.toList()) : Collections.emptyList());
        pmmFile.setPmmFileAccessories(parseAccessories(pmmFile.getAccessoryCount()));
        pmmFile.setCurrentFramePosition(getInt32());
        pmmFile.setHorizontalScrollPosition(getInt32());
        pmmFile.setHorizontalScale(getInt32());
        pmmFile.setBoneOperationMethod(getInt32());
        pmmFile.setLookingAt(getByte());
        pmmFile.setRepeat(getByte());
        pmmFile.setPlayFromFrame(getByte());
        pmmFile.setPlayToFrame(getByte());
        pmmFile.setPlayStartFrame(getInt32());
        pmmFile.setPlayEndFrame(getInt32());
        pmmFile.setWaveEnabled(getByte());
        pmmFile.setWaveFileName(getFixedString(FILE_NAME_LENGTH));
        pmmFile.setAviOffsetX(getInt32());
        pmmFile.setAviOffsetY(getInt32());
        pmmFile.setAviScale(getFloat());
        pmmFile.setAviFileName(getFixedString(FILE_NAME_LENGTH));
        pmmFile.setShowAvi(getInt32());
        pmmFile.setBackgroundImageOffsetX(getInt32());
        pmmFile.setBackgroundImageOffsetY(getInt32());
        pmmFile.setBackgroundImageScale(getFloat());
        pmmFile.setBackgroundImageFileName(getFixedString(FILE_NAME_LENGTH));
        pmmFile.setShowBackgroundImage(getByte());
        pmmFile.setShowInformation(getByte());
        pmmFile.setShowAxis(getByte());
        pmmFile.setShowGroundShadow(getByte());
        pmmFile.setFpsLimit(getFloat());
        pmmFile.setScreenCaptureMode(getInt32());
        pmmFile.setAccessoryNumberRenderAfterModel(getInt32());
        pmmFile.setGroundShadowBrightness(getFloat());
        pmmFile.setTransparentGroundShadow(getByte());
        pmmFile.setPhysicsMode(getByte());
        pmmFile.setPmmFileGravity(parseGravity());
        pmmFile.setShowSelfShadow(getByte());
        pmmFile.setPmmFileSelfShadow(parseSelfShadow());
        pmmFile.setEdgeColorR(getInt32());
        pmmFile.setEdgeColorG(getInt32());
        pmmFile.setEdgeColorB(getInt32());
        pmmFile.setBlackBackground(getByte());
        pmmFile.setCameraLookingAtModelCurrent(getInt32());
        pmmFile.setCameraLookingAtBoneCurrent(getInt32());
        pmmFile.setUnknownFloat01(getFloat());
        pmmFile.setUnknownFloat02(getFloat());
        pmmFile.setUnknownFloat03(getFloat());
        pmmFile.setUnknownFloat04(getFloat());
        pmmFile.setUnknownFloat05(getFloat());
        pmmFile.setUnknownFloat06(getFloat());
        pmmFile.setUnknownFloat07(getFloat());
        pmmFile.setUnknownFloat08(getFloat());
        pmmFile.setUnknownFloat09(getFloat());
        pmmFile.setUnknownFloat10(getFloat());
        pmmFile.setUnknownFloat11(getFloat());
        pmmFile.setUnknownFloat12(getFloat());
        pmmFile.setUnknownFloat13(getFloat());
        pmmFile.setUnknownFloat14(getFloat());
        pmmFile.setUnknownFloat15(getFloat());
        pmmFile.setUnknownFloat16(getFloat());
        pmmFile.setEyeTrackingEnabled(getByte());
        pmmFile.setUnknownByte01(getByte());
        pmmFile.setGroundPhysicsEnabled(getByte());
        pmmFile.setFrameTextBox(getInt32());
        pmmFile.setSelectorChoiceFollowing(getByte());
        pmmFile.setPmmFileSelectorChoices(parseSelectorChoices(pmmFile.getModelCount()));

        return pmmFile;
    }

    private List<PMMFileModel> parseModels(byte count) {
        List<PMMFileModel> models = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            PMMFileModel pmmFileModel = new PMMFileModel();
            pmmFileModel.setModelIndex(getByte());
            pmmFileModel.setModelNameJapanese(getVariableString());
            pmmFileModel.setModelNameEnglish(getVariableString());
            pmmFileModel.setModelFilePath(getFixedString(FILE_PATH_LENGTH));
            pmmFileModel.setKeyFrameEditorTopRows(getByte());
            pmmFileModel.setBoneCount(getInt32());
            pmmFileModel.setBoneNames(pmmFileModel.getBoneCount() > 0 ? IntStream.range(0, pmmFileModel.getBoneCount()).mapToObj(bone -> getVariableString()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setMorphCount(getInt32());
            pmmFileModel.setMorphNames(pmmFileModel.getMorphCount() > 0 ? IntStream.range(0, pmmFileModel.getMorphCount()).mapToObj(morph -> getVariableString()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setIkBoneCount(getInt32());
            pmmFileModel.setIkBoneIndices(pmmFileModel.getIkBoneCount() > 0 ? IntStream.range(0, pmmFileModel.getIkBoneCount()).mapToObj(ikBone -> getInt32()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setParentableBoneCount(getInt32());
            pmmFileModel.setParentableBoneIndices(pmmFileModel.getParentableBoneCount() > 0 ? IntStream.range(0, pmmFileModel.getParentableBoneCount()).mapToObj(ikBone -> getInt32()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setRenderOrder(getByte());
            pmmFileModel.setVisible(getByte());
            pmmFileModel.setSelectedBone(getInt32());
            pmmFileModel.setSelectedBrowMorphIndex(getInt32());
            pmmFileModel.setSelectedEyeMorphIndex(getInt32());
            pmmFileModel.setSelectedLipMorphIndex(getInt32());
            pmmFileModel.setSelectedOtherMorphIndex(getInt32());
            pmmFileModel.setFoldCount(getByte());
            pmmFileModel.setSelectedFoldStatus(pmmFileModel.getFoldCount() > 0 ? IntStream.range(0, pmmFileModel.getFoldCount()).mapToObj(fold -> getByte()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setVerticalScrollStatus(getInt32());
            pmmFileModel.setLastFrame(getInt32());
            pmmFileModel.setBoneInitialKeyframes(pmmFileModel.getBoneCount() > 0 ? IntStream.range(0, pmmFileModel.getBoneCount()).mapToObj(bone -> parseModelKeyframe()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setBoneKeyframeCount(getInt32());
            pmmFileModel.setBoneKeyframes(pmmFileModel.getBoneKeyframeCount() > 0 ? IntStream.range(0, pmmFileModel.getBoneKeyframeCount()).mapToObj(bone -> parseModelKeyframeWithIndex()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setMorphInitialKeyframes(pmmFileModel.getMorphCount() > 0 ? IntStream.range(0, pmmFileModel.getMorphCount()).mapToObj(morph -> parseMorphKeyframe()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setMorphKeyframeCount(getInt32());
            pmmFileModel.setMorphKeyframes(pmmFileModel.getMorphKeyframeCount() > 0 ? IntStream.range(0, pmmFileModel.getMorphKeyframeCount()).mapToObj(morph -> parseMorphKeyframeWithIndex()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setConfigurationInitialKeyframe(parseConfigurationKeyframe());
            pmmFileModel.setIkInitialEnabled(pmmFileModel.getIkBoneCount() > 0 ? IntStream.range(0, pmmFileModel.getIkBoneCount()).mapToObj(ik -> getByte()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setRelationSettings(pmmFileModel.getParentableBoneCount() > 0 ? IntStream.range(0, pmmFileModel.getParentableBoneCount()).mapToObj(relation -> parseConfigurationKeyframeRelation()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setSelectedConfiguration(getByte());
            pmmFileModel.setKeyframeConfigurationCount(getInt32());
            pmmFileModel.setConfigurationKeyframes(pmmFileModel.getKeyframeConfigurationCount() > 0 ? IntStream.range(0, pmmFileModel.getKeyframeConfigurationCount()).mapToObj(configuration -> parseConfigurationKeyframeWithIndex()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setCurrentBones(pmmFileModel.getBoneCount() > 0 ? IntStream.range(0, pmmFileModel.getBoneCount()).mapToObj(bone -> parseBone()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setMorphValues(pmmFileModel.getMorphCount() > 0 ? IntStream.range(0, pmmFileModel.getMorphCount()).mapToObj(morph -> getFloat()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setIkEnabled(pmmFileModel.getIkBoneCount() > 0 ? IntStream.range(0, pmmFileModel.getIkBoneCount()).mapToObj(ik -> getByte()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setCurrentRelationSettings(pmmFileModel.getParentableBoneCount() > 0 ? IntStream.range(0, pmmFileModel.getParentableBoneCount()).mapToObj(relation -> parseConfigurationKeyframeRelationCurrent()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setBlend(getByte());
            pmmFileModel.setEdgeWidth(getFloat());
            pmmFileModel.setSelfShadowEnabled(getByte());
            pmmFileModel.setCalculationOrder(getByte());

            models.add(pmmFileModel);
        }
        return models;
    }

    private PMMFileCamera parseCamera() {
        PMMFileCamera pmmFileCamera = new PMMFileCamera();
        pmmFileCamera.setCameraInitialKeyframe(parseCameraKeyframe());
        pmmFileCamera.setCameraKeyframeCount(getInt32());
        pmmFileCamera.setCameraKeyframes(pmmFileCamera.getCameraKeyframeCount() > 0 ? IntStream.range(0, pmmFileCamera.getCameraKeyframeCount()).mapToObj(bone -> parseCameraKeyframeWithIndex()).collect(Collectors.toList()) : Collections.emptyList());
        pmmFileCamera.setEyePositionX(getFloat());
        pmmFileCamera.setEyePositionY(getFloat());
        pmmFileCamera.setEyePositionZ(getFloat());
        pmmFileCamera.setTargetPositionX(getFloat());
        pmmFileCamera.setTargetPositionY(getFloat());
        pmmFileCamera.setTargetPositionZ(getFloat());
        pmmFileCamera.setRotationX(getFloat());
        pmmFileCamera.setRotationY(getFloat());
        pmmFileCamera.setRotationZ(getFloat());
        pmmFileCamera.setOrthographicCameraEnabled(getByte());

        return pmmFileCamera;
    }

    private List<PMMFileAccessory> parseAccessories(byte count) {
        List<PMMFileAccessory> accessories = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            PMMFileAccessory pmmFileAccessory = new PMMFileAccessory();
            pmmFileAccessory.setAccessoryIndex(getByte());
            pmmFileAccessory.setAccessoryName(getFixedString(NAME_LENGTH));
            pmmFileAccessory.setAccessoryFilePath(getFixedString(FILE_PATH_LENGTH));
            pmmFileAccessory.setRenderOrder(getByte());
            pmmFileAccessory.setAccessoryInitialKeyframe(parseAccessoryKeyframe());
            pmmFileAccessory.setAccessoryKeyframeCount(getInt32());
            pmmFileAccessory.setAccessoryKeyframes(pmmFileAccessory.getAccessoryKeyframeCount() > 0 ? IntStream.range(0, pmmFileAccessory.getAccessoryKeyframeCount()).mapToObj(accessory -> parseAccessoryKeyframeWithIndex()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileAccessory.setCurrentAccessoryData(new PMMFileAccessoryData(getByte(), getInt32(), getInt32(), getFloat(), getFloat(), getFloat(), getFloat(), getFloat(), getFloat(), getFloat(), getByte()));
            pmmFileAccessory.setBlend(getByte());

            accessories.add(pmmFileAccessory);

        }
        return accessories;
    }

    private PMMFileLighting parseLighting() {
        PMMFileLighting pmmFileLighting = new PMMFileLighting();
        pmmFileLighting.setLightingInitialKeyframe(parseLightingKeyframe());
        pmmFileLighting.setLightingKeyframeCount(getInt32());
        pmmFileLighting.setLightingKeyframes(pmmFileLighting.getLightingKeyframeCount() > 0 ? IntStream.range(0, pmmFileLighting.getLightingKeyframeCount()).mapToObj(light -> parseLightingKeyframeWithIndex()).collect(Collectors.toList()) : Collections.emptyList());
        pmmFileLighting.setCurrentLightingData(new PMMFileLightingData(getFloat(), getFloat(), getFloat(), getFloat(), getFloat(), getFloat()));
        return pmmFileLighting;
    }

    private PMMFileGravity parseGravity() {
        PMMFileGravity pmmFileGravity = new PMMFileGravity();
        pmmFileGravity.setAcceleration(getFloat());
        pmmFileGravity.setNoiseAmount(getInt32());
        pmmFileGravity.setDirectionX(getFloat());
        pmmFileGravity.setDirectionY(getFloat());
        pmmFileGravity.setDirectionZ(getFloat());
        pmmFileGravity.setAddNoise(getByte());
        pmmFileGravity.setGravityInitialKeyframe(parseGravityKeyframe());
        pmmFileGravity.setGravityKeyframeCount(getInt32());
        pmmFileGravity.setGravityKeyframes(pmmFileGravity.getGravityKeyframeCount() > 0 ? IntStream.range(0, pmmFileGravity.getGravityKeyframeCount()).mapToObj(gravity -> parseGravityKeyframeWithIndex()).collect(Collectors.toList()) : Collections.emptyList());
        return pmmFileGravity;
    }

    private PMMFileSelfShadow parseSelfShadow() {
        PMMFileSelfShadow pmmFileSelfShadow = new PMMFileSelfShadow();
        pmmFileSelfShadow.setSelfShadowDistance(getFloat());
        pmmFileSelfShadow.setSelfShadowInitialKeyframe(parseSelfShadowKeyframe());
        pmmFileSelfShadow.setSelfShadowKeyframeCount(getInt32());
        pmmFileSelfShadow.setSelfShadowKeyframes(pmmFileSelfShadow.getSelfShadowKeyframeCount() > 0 ? IntStream.range(0, pmmFileSelfShadow.getSelfShadowKeyframeCount()).mapToObj(shadow -> parseSelfShadowKeyframeWithIndex()).collect(Collectors.toList()) : Collections.emptyList());
        return pmmFileSelfShadow;
    }

    private List<PMMFileSelectorChoice> parseSelectorChoices(byte count) {
        List<PMMFileSelectorChoice> choices = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            PMMFileSelectorChoice pmmFileSelectorChoice = new PMMFileSelectorChoice();
            pmmFileSelectorChoice.setModelIndex(getByte());
            pmmFileSelectorChoice.setSelectorChoice(getInt32());

            choices.add(pmmFileSelectorChoice);
        }
        return choices;
    }

    private PMMFileModelKeyframe parseModelKeyframe() {
        PMMFileModelKeyframe keyframe = new PMMFileModelKeyframe();
        keyframe.setKeyframePosition(getInt32());
        keyframe.setPreviousIndex(getInt32());
        keyframe.setNextIndex(getInt32());
        keyframe.setInterpolationX(new PMMFileKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
        keyframe.setInterpolationY(new PMMFileKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
        keyframe.setInterpolationZ(new PMMFileKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
        keyframe.setInterpolationRotation(new PMMFileKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
        keyframe.setTranslationX(getFloat());
        keyframe.setTranslationY(getFloat());
        keyframe.setTranslationZ(getFloat());
        keyframe.setRotationX(getFloat());
        keyframe.setRotationY(getFloat());
        keyframe.setRotationZ(getFloat());
        keyframe.setRotationW(getFloat());
        keyframe.setSelected(getByte());
        keyframe.setPhysicsDisabled(getByte());
        return keyframe;
    }

    private PMMFileCameraKeyframe parseCameraKeyframe() {
        PMMFileCameraKeyframe keyframe = new PMMFileCameraKeyframe();
        keyframe.setKeyframePosition(getInt32());
        keyframe.setPreviousIndex(getInt32());
        keyframe.setNextIndex(getInt32());
        keyframe.setDistance(getFloat());
        keyframe.setEyePositionX(getFloat());
        keyframe.setEyePositionY(getFloat());
        keyframe.setEyePositionZ(getFloat());
        keyframe.setRotationX(getFloat());
        keyframe.setRotationY(getFloat());
        keyframe.setRotationZ(getFloat());
        keyframe.setTrackedModelIndex(getInt32());
        keyframe.setTrackedModelBoneIndex(getInt32());
        keyframe.setEyeInterpolationX(new PMMFileKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
        keyframe.setEyeInterpolationY(new PMMFileKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
        keyframe.setEyeInterpolationZ(new PMMFileKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
        keyframe.setInterpolationRotation(new PMMFileKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
        keyframe.setInterpolationDistance(new PMMFileKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
        keyframe.setInterpolationAngleOfView(new PMMFileKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
        keyframe.setOrthographicCameraEnabled(getByte());
        keyframe.setAngleOfView(getInt32());
        keyframe.setSelected(getByte());
        return keyframe;
    }

    private PMMFileLightingKeyframe parseLightingKeyframe() {
        PMMFileLightingKeyframe keyframe = new PMMFileLightingKeyframe();
        keyframe.setKeyframePosition(getInt32());
        keyframe.setPreviousIndex(getInt32());
        keyframe.setNextIndex(getInt32());
        keyframe.setLightingData(new PMMFileLightingData(getFloat(), getFloat(), getFloat(), getFloat(), getFloat(), getFloat()));
        keyframe.setSelected(getByte());
        return keyframe;
    }

    private PMMFileAccessoryKeyframe parseAccessoryKeyframe() {
        PMMFileAccessoryKeyframe keyframe = new PMMFileAccessoryKeyframe();
        keyframe.setKeyframePosition(getInt32());
        keyframe.setPreviousIndex(getInt32());
        keyframe.setNextIndex(getInt32());
        keyframe.setAccessoryData(new PMMFileAccessoryData(getByte(), getInt32(), getInt32(), getFloat(), getFloat(), getFloat(), getFloat(), getFloat(), getFloat(), getFloat(), getByte()));
        keyframe.setSelected(getByte());
        return keyframe;
    }

    private PMMFileGravityKeyframe parseGravityKeyframe() {
        PMMFileGravityKeyframe keyframe = new PMMFileGravityKeyframe();
        keyframe.setKeyframePosition(getInt32());
        keyframe.setPreviousIndex(getInt32());
        keyframe.setNextIndex(getInt32());
        keyframe.setAddNoise(getByte());
        keyframe.setNoiseAmount(getInt32());
        keyframe.setAcceleration(getFloat());
        keyframe.setDirectionX(getFloat());
        keyframe.setDirectionY(getFloat());
        keyframe.setDirectionZ(getFloat());
        keyframe.setSelected(getByte());
        return keyframe;
    }

    private PMMFileSelfShadowKeyframe parseSelfShadowKeyframe() {
        PMMFileSelfShadowKeyframe keyframe = new PMMFileSelfShadowKeyframe();
        keyframe.setKeyframePosition(getInt32());
        keyframe.setPreviousIndex(getInt32());
        keyframe.setNextIndex(getInt32());
        keyframe.setMode(getByte());
        keyframe.setDistance(getFloat());
        keyframe.setSelected(getByte());
        return keyframe;
    }

    private PMMFileModelKeyframeWithIndex parseModelKeyframeWithIndex() {
        PMMFileModelKeyframeWithIndex keyframe = new PMMFileModelKeyframeWithIndex();
        keyframe.setDataIndex(getInt32());
        keyframe.setBoneKeyframeData(parseModelKeyframe());
        return keyframe;
    }

    private PMMFileCameraKeyframeWithIndex parseCameraKeyframeWithIndex() {
        PMMFileCameraKeyframeWithIndex keyframe = new PMMFileCameraKeyframeWithIndex();
        keyframe.setDataIndex(getInt32());
        keyframe.setCameraKeyframeData(parseCameraKeyframe());
        return keyframe;
    }

    private PMMFileLightingKeyframeWithIndex parseLightingKeyframeWithIndex() {
        PMMFileLightingKeyframeWithIndex keyframe = new PMMFileLightingKeyframeWithIndex();
        keyframe.setDataIndex(getInt32());
        keyframe.setLightingKeyframe(parseLightingKeyframe());
        return keyframe;
    }

    private PMMFileAccessoryKeyframeWithIndex parseAccessoryKeyframeWithIndex() {
        PMMFileAccessoryKeyframeWithIndex keyframe = new PMMFileAccessoryKeyframeWithIndex();
        keyframe.setDataIndex(getInt32());
        keyframe.setAccessoryKeyframeData(parseAccessoryKeyframe());
        return keyframe;
    }

    private PMMFileGravityKeyframeWithIndex parseGravityKeyframeWithIndex() {
        PMMFileGravityKeyframeWithIndex keyframe = new PMMFileGravityKeyframeWithIndex();
        keyframe.setDataIndex(getInt32());
        keyframe.setGravityKeyframeData(parseGravityKeyframe());
        return keyframe;
    }

    private PMMFileSelfShadowKeyframeWithIndex parseSelfShadowKeyframeWithIndex() {
        PMMFileSelfShadowKeyframeWithIndex keyframe = new PMMFileSelfShadowKeyframeWithIndex();
        keyframe.setDataIndex(getInt32());
        keyframe.setSelfShadowKeyframeData(parseSelfShadowKeyframe());
        return keyframe;
    }

    private PMMFileModelMorphKeyframe parseMorphKeyframe() {
        PMMFileModelMorphKeyframe keyframe = new PMMFileModelMorphKeyframe();
        keyframe.setKeyframePosition(getInt32());
        keyframe.setPreviousIndex(getInt32());
        keyframe.setNextIndex(getInt32());
        keyframe.setMorphValue(getFloat());
        keyframe.setSelected(getByte());
        return keyframe;
    }

    private PMMFileModelMorphKeyframeWithIndex parseMorphKeyframeWithIndex() {
        PMMFileModelMorphKeyframeWithIndex keyframe = new PMMFileModelMorphKeyframeWithIndex();
        keyframe.setDataIndex(getInt32());
        keyframe.setMorphKeyframeData(parseMorphKeyframe());
        return keyframe;
    }

    private PMMFileModelKeyframeConfigurationRelation parseConfigurationKeyframeRelation() {
        PMMFileModelKeyframeConfigurationRelation relation = new PMMFileModelKeyframeConfigurationRelation();
        relation.setParentModelIndex(getInt32());
        relation.setParentBoneIndex(getInt32());
        return relation;
    }

    private PMMFileModelKeyframeConfigurationRelationCurrent parseConfigurationKeyframeRelationCurrent() {
        PMMFileModelKeyframeConfigurationRelationCurrent relation = new PMMFileModelKeyframeConfigurationRelationCurrent();
        relation.setKeyframePositionRelationBegin(getInt32());
        relation.setKeyframePositionRelationEnd(getInt32());
        relation.setParentModelIndex(getInt32());
        relation.setParentBoneIndex(getInt32());
        return relation;
    }

    private PMMFileModelKeyframeConfiguration parseConfigurationKeyframe() {
        PMMFileModelKeyframeConfiguration keyframe = new PMMFileModelKeyframeConfiguration();
        keyframe.setKeyframePosition(getInt32());
        keyframe.setPreviousIndex(getInt32());
        keyframe.setNextIndex(getInt32());
        keyframe.setVisible(getByte());
        return keyframe;
    }

    private PMMFileModelKeyframeConfigurationWithIndex parseConfigurationKeyframeWithIndex() {
        PMMFileModelKeyframeConfigurationWithIndex keyframe = new PMMFileModelKeyframeConfigurationWithIndex();
        keyframe.setDataIndex(getInt32());
        keyframe.setKeyframeConfigurationData(parseConfigurationKeyframe());
        return keyframe;
    }

    private PMMFileModelBone parseBone() {
        PMMFileModelBone bone = new PMMFileModelBone();
        bone.setTranslationX(getFloat());
        bone.setTranslationY(getFloat());
        bone.setTranslationZ(getFloat());
        bone.setRotationX(getFloat());
        bone.setRotationY(getFloat());
        bone.setRotationZ(getFloat());
        bone.setRotationW(getFloat());
        bone.setOperationUncommitted(getByte());
        bone.setPhysicsDisabled(getByte());
        bone.setRowSelected(getByte());
        return bone;
    }

    private String getVariableString() {
        int start = offset;
        int length = getByte();
        start += 1;
        return getFixedString(start, length);
    }

    private String getFixedString(int start, int length) {
        int end = start + length;
        byte[] result = new byte[length];
        for (int i = start; i < end; i++) {
            int resultIndex = i - start;
            if (bytes[i] == 0) {
                break;
            }
            result[resultIndex] = bytes[i];
            //System.out.println(result[resultIndex]);
        }
        //System.out.println("End of Byte Range");
        offset += length;
        ByteBuffer buffer = ByteBuffer.wrap(result);
        return Charset.forName("Shift-JIS").decode(buffer).toString();
    }

    private String getFixedString(int length) {
        return getFixedString(offset, length);
    }
}
