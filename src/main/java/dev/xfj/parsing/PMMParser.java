package dev.xfj.parsing;

import dev.xfj.format.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PMMParser {
    private final Path path;
    private final byte[] bytes;
    private final ByteBuffer byteBuffer;

    private int offset;

    public PMMParser(Path path) throws IOException {
        this.path = path;
        this.bytes = Files.readAllBytes(this.path);
        this.byteBuffer = ByteBuffer.wrap(bytes);
        this.byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.offset = 0;
    }

    public void parse() throws IOException {
        PMMFile pmmFile = new PMMFile();
        //Keeping track of the positions was tedious so just added a counter that increments after each read
        pmmFile.setVersion(getFixedString(30));
        pmmFile.setOutputWidth(getInt());
        pmmFile.setOutputHeight(getInt());
        pmmFile.setKeyFrameEditorWidth(getInt());
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

        System.out.println(pmmFile.getVersion());
        System.out.println(pmmFile.getOutputWidth());
        pmmFile.getPmmFileModels().forEach(model -> System.out.println(model.getModelNameJapanese()));
        pmmFile.getPmmFileModels().forEach(model -> System.out.println(model.getModelNameEnglish()));
        pmmFile.getPmmFileModels().forEach(model -> System.out.println(model.getCalculationOrder()));
        pmmFile.getPmmFileModels().forEach(model -> System.out.println(model.getModelFilePath()));
        pmmFile.getPmmFileModels().forEach(model -> model.getBoneNames().forEach(System.out::println));
        pmmFile.getPmmFileModels().forEach(model -> model.getMorphNames().forEach(System.out::println));
        pmmFile.getPmmFileModels().forEach(model -> System.out.println(model.getSelfShadowEnabled()));
        pmmFile.getPmmFileCamera().getCameraKeyframes().forEach(camera -> System.out.println(camera.getCameraKeyframeData().getKeyframePosition() + " " + camera.getCameraKeyframeData().getDistance()));
        pmmFile.getPmmFileCamera().getCameraKeyframes().forEach(camera -> System.out.println(camera.getCameraKeyframeData().getAngleOfView()));
        System.out.println(pmmFile.getPmmFileCamera().getOrthographicCameraEnabled());
    }

    public List<PMMFileModel> parseModels(byte count) throws UnsupportedEncodingException {
        List<PMMFileModel> models = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            PMMFileModel pmmFileModel = new PMMFileModel();
            pmmFileModel.setModelIndex(getByte());
            pmmFileModel.setModelNameJapanese(getVariableString());
            pmmFileModel.setModelNameEnglish(getVariableString());
            pmmFileModel.setModelFilePath(getFixedString(256));
            pmmFileModel.setKeyFrameEditorTopRows(getByte());
            pmmFileModel.setBoneCount(getInt());
            pmmFileModel.setBoneNames(pmmFileModel.getBoneCount() > 0 ? IntStream.range(0, pmmFileModel.getBoneCount()).mapToObj(bone -> getVariableString()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setMorphCount(getInt());
            pmmFileModel.setMorphNames(pmmFileModel.getMorphCount() > 0 ? IntStream.range(0, pmmFileModel.getMorphCount()).mapToObj(morph -> getVariableString()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setIkBoneCount(getInt());
            pmmFileModel.setIkBoneIndices(pmmFileModel.getIkBoneCount() > 0 ? IntStream.range(0, pmmFileModel.getIkBoneCount()).mapToObj(ikBone -> getInt()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setParentableBoneCount(getInt());
            pmmFileModel.setParentableBoneIndices(pmmFileModel.getParentableBoneCount() > 0 ? IntStream.range(0, pmmFileModel.getParentableBoneCount()).mapToObj(ikBone -> getInt()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setRenderOrder(getByte());
            pmmFileModel.setVisible(getByte());
            pmmFileModel.setSelectedBone(getInt());
            pmmFileModel.setSelectedBrowMorphIndex(getInt());
            pmmFileModel.setSelectedEyeMorphIndex(getInt());
            pmmFileModel.setSelectedLipMorphIndex(getInt());
            pmmFileModel.setSelectedOtherMorphIndex(getInt());
            pmmFileModel.setFoldCount(getByte());
            pmmFileModel.setSelectedFoldStatus(pmmFileModel.getFoldCount() > 0 ? IntStream.range(0, pmmFileModel.getFoldCount()).mapToObj(fold -> getByte()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setVerticalScrollStatus(getInt());
            pmmFileModel.setLastFrame(getInt());
            pmmFileModel.setBoneInitialKeyframes(pmmFileModel.getBoneCount() > 0 ? IntStream.range(0, pmmFileModel.getBoneCount()).mapToObj(bone -> parseModelKeyframe()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setBoneKeyframeCount(getInt());
            pmmFileModel.setBoneKeyframes(pmmFileModel.getBoneKeyframeCount() > 0 ? IntStream.range(0, pmmFileModel.getBoneKeyframeCount()).mapToObj(bone -> parseModelKeyframeWithIndex()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setMorphInitialKeyframes(pmmFileModel.getMorphCount() > 0 ? IntStream.range(0, pmmFileModel.getMorphCount()).mapToObj(morph -> parseMorphKeyframe()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setMorphKeyframeCount(getInt());
            pmmFileModel.setMorphKeyframes(pmmFileModel.getMorphKeyframeCount() > 0 ? IntStream.range(0, pmmFileModel.getMorphKeyframeCount()).mapToObj(morph -> parseMorphKeyframeWithIndex()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setConfigurationInitialKeyframe(parseConfigurationKeyframe());
            pmmFileModel.setIkInitialEnabled(pmmFileModel.getIkBoneCount() > 0 ? IntStream.range(0, pmmFileModel.getIkBoneCount()).mapToObj(ik -> getByte()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setRelationSettings(pmmFileModel.getParentableBoneCount() > 0 ? IntStream.range(0, pmmFileModel.getParentableBoneCount()).mapToObj(relation -> parseConfigurationKeyframeRelation()).collect(Collectors.toList()) : Collections.emptyList());
            pmmFileModel.setSelectedConfiguration(getByte());
            pmmFileModel.setKeyframeConfigurationCount(getInt());
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
    public PMMFileCamera parseCamera() {
        PMMFileCamera pmmFileCamera = new PMMFileCamera();
        pmmFileCamera.setCameraInitialKeyframe(parseCameraKeyframe());
        pmmFileCamera.setCameraKeyframeCount(getInt());
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

    public PMMFileModelKeyframe parseModelKeyframe() {
        PMMFileModelKeyframe keyframe = new PMMFileModelKeyframe();
        keyframe.setKeyframePosition(getInt());
        keyframe.setPreviousIndex(getInt());
        keyframe.setNextIndex(getInt());
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
    public PMMFileCameraKeyframe parseCameraKeyframe() {
        PMMFileCameraKeyframe keyframe = new PMMFileCameraKeyframe();
        keyframe.setKeyframePosition(getInt());
        keyframe.setPreviousIndex(getInt());
        keyframe.setNextIndex(getInt());
        keyframe.setDistance(getFloat());
        keyframe.setEyePositionX(getFloat());
        keyframe.setEyePositionY(getFloat());
        keyframe.setEyePositionZ(getFloat());
        keyframe.setRotationX(getFloat());
        keyframe.setRotationY(getFloat());
        keyframe.setRotationZ(getFloat());
        keyframe.setTrackedModelIndex(getInt());
        keyframe.setTrackedModelBoneIndex(getInt());
        keyframe.setEyeInterpolationX(new PMMFileKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
        keyframe.setEyeInterpolationY(new PMMFileKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
        keyframe.setEyeInterpolationZ(new PMMFileKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
        keyframe.setInterpolationRotation(new PMMFileKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
        keyframe.setInterpolationDistance(new PMMFileKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
        keyframe.setInterpolationAngleOfView(new PMMFileKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
        keyframe.setOrthographicCameraEnabled(getByte());
        keyframe.setAngleOfView(getInt());
        keyframe.setSelected(getByte());
        return keyframe;
    }

    public PMMFileModelKeyframeWithIndex parseModelKeyframeWithIndex() {
        PMMFileModelKeyframeWithIndex keyframe = new PMMFileModelKeyframeWithIndex();
        keyframe.setDataIndex(getInt());
        keyframe.setBoneKeyframeData(parseModelKeyframe());
        return keyframe;
    }
    public PMMFileCameraKeyframeWithIndex parseCameraKeyframeWithIndex() {
        PMMFileCameraKeyframeWithIndex keyframe = new PMMFileCameraKeyframeWithIndex();
        keyframe.setDataIndex(getInt());
        keyframe.setCameraKeyframeData(parseCameraKeyframe());
        return keyframe;
    }

    public PMMFileModelMorphKeyframe parseMorphKeyframe() {
        PMMFileModelMorphKeyframe keyframe = new PMMFileModelMorphKeyframe();
        keyframe.setKeyframePosition(getInt());
        keyframe.setPreviousIndex(getInt());
        keyframe.setNextIndex(getInt());
        keyframe.setMorphValue(getFloat());
        keyframe.setSelected(getByte());
        return keyframe;
    }

    public PMMFileModelMorphKeyframeWithIndex parseMorphKeyframeWithIndex() {
        PMMFileModelMorphKeyframeWithIndex keyframe = new PMMFileModelMorphKeyframeWithIndex();
        keyframe.setDataIndex(getInt());
        keyframe.setMorphKeyframeData(parseMorphKeyframe());
        return keyframe;
    }

    public PMMFileModelKeyframeConfigurationRelation parseConfigurationKeyframeRelation() {
        PMMFileModelKeyframeConfigurationRelation relation = new PMMFileModelKeyframeConfigurationRelation();
        relation.setParentModelIndex(getInt());
        relation.setParentBoneIndex(getInt());
        return relation;
    }

    public PMMFileModelKeyframeConfigurationRelationCurrent parseConfigurationKeyframeRelationCurrent() {
        PMMFileModelKeyframeConfigurationRelationCurrent relation = new PMMFileModelKeyframeConfigurationRelationCurrent();
        relation.setKeyframePositionRelationBegin(getInt());
        relation.setKeyframePositionRelationEnd(getInt());
        relation.setParentModelIndex(getInt());
        relation.setParentBoneIndex(getInt());
        return relation;
    }

    public PMMFileModelKeyframeConfiguration parseConfigurationKeyframe() {
        PMMFileModelKeyframeConfiguration keyframe = new PMMFileModelKeyframeConfiguration();
        keyframe.setKeyframePosition(getInt());
        keyframe.setPreviousIndex(getInt());
        keyframe.setNextIndex(getInt());
        keyframe.setVisible(getByte());
        return keyframe;
    }

    public PMMFileModelKeyframeConfigurationWithIndex parseConfigurationKeyframeWithIndex() {
        PMMFileModelKeyframeConfigurationWithIndex keyframe = new PMMFileModelKeyframeConfigurationWithIndex();
        keyframe.setDataIndex(getInt());
        keyframe.setKeyframeConfigurationData(parseConfigurationKeyframe());
        return keyframe;
    }

    public PMMFileModelBone parseBone() {
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

    public byte getByte() {
        byte result = byteBuffer.get(offset);
        this.offset += 1;
        return result;
    }

    public int getInt() {
        int result = byteBuffer.getInt(offset);
        this.offset += 4;
        return result;
    }

    public float getFloat() {
        float result = byteBuffer.getFloat(offset);
        this.offset += 4;
        return result;
    }

    public String getVariableString() {
        int start = offset;
        int end = bytes[start];
        start += 1;
        offset += 1; //First byte was read to get length
        return getFixedString(start, end);
    }

    public String getFixedString(int start, int length) {
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

    public String getFixedString(int length) {
        return getFixedString(offset, length);
    }
}
