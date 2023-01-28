package dev.xfj.parsing;

import dev.xfj.format.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PMMParser {
    private Path path;
    private final byte[] bytes;
    private ByteBuffer byteBuffer;

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

        System.out.println(pmmFile.getVersion());
        System.out.println(pmmFile.getOutputWidth());
        System.out.println(pmmFile.getPmmFileModels().get(0).getModelNameJapanese());
        System.out.println(pmmFile.getPmmFileModels().get(0).getModelFilePath());
        pmmFile.getPmmFileModels().get(0).getBoneNames().forEach(System.out::println);
        pmmFile.getPmmFileModels().get(0).getMorphNames().forEach(System.out::println);
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
            pmmFileModel.setBoneNames(pmmFileModel.getBoneCount() > 0 ?IntStream.range(0, pmmFileModel.getBoneCount()).mapToObj(bone -> {
                try {
                    return getVariableString();
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList()) : Collections.emptyList());

            pmmFileModel.setMorphCount(getInt());
            pmmFileModel.setMorphNames(pmmFileModel.getMorphCount() > 0 ?IntStream.range(0, pmmFileModel.getMorphCount()).mapToObj(morph -> {
                try {
                    return getVariableString();
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList()) : Collections.emptyList());

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
            pmmFileModel.setSelectedFoldStatus(IntStream.range(0, pmmFileModel.getFoldCount()).mapToObj(fold -> getByte()).collect(Collectors.toList()));

            pmmFileModel.setVerticalScrollStatus(getInt());
            pmmFileModel.setLastFrame(getInt());

            pmmFileModel.setBoneInitialKeyframes(IntStream.range(0, pmmFileModel.getBoneCount()).mapToObj(bone -> parseKeyframe()).collect(Collectors.toList()));

            pmmFileModel.setBoneKeyframeCount(getInt());
            List<PMMFileModelKeyframeWithIndex> boneKeyframes = new ArrayList<>();
            IntStream.range(0, pmmFileModel.getBoneKeyframeCount()).mapToObj(boneKeyframe -> new PMMFileModelKeyframeWithIndex()).forEach(keyframe -> {
                keyframe.setDataIndex(getInt());
                keyframe.setBoneKeyframeData(parseKeyframe());
                boneKeyframes.add(keyframe);
            });
            pmmFileModel.setBoneKeyframes(boneKeyframes);

            pmmFileModel.setMorphInitialKeyframes(IntStream.range(0, pmmFileModel.getMorphCount()).mapToObj(morph -> parseMorphKeyframe()).collect(Collectors.toList()));

            pmmFileModel.setMorphKeyframeCount(getInt());
            List<PMMFileModelMorphKeyframeWithIndex> morphKeyframes = new ArrayList<>();
            IntStream.range(0, pmmFileModel.getMorphKeyframeCount()).mapToObj(morphKeyframe -> new PMMFileModelMorphKeyframeWithIndex()).forEach(keyframe -> {
                keyframe.setDataIndex(getInt());
                keyframe.setMorphKeyframeData(parseMorphKeyframe());
                morphKeyframes.add(keyframe);
            });
            pmmFileModel.setMorphKeyframes(morphKeyframes);

            pmmFileModel.setConfigurationInitialKeyframe(parseConfigurationKeyframe());
            pmmFileModel.setIkInitialEnabled(IntStream.range(0, pmmFileModel.getIkBoneCount()).mapToObj(ik -> getByte()).collect(Collectors.toList()));

            List<PMMFileModelKeyframeConfigurationRelation> relations = new ArrayList<>();
            IntStream.range(0, pmmFileModel.getParentableBoneCount()).mapToObj(bone -> new PMMFileModelKeyframeConfigurationRelation()).forEach(relation -> {
                relation.setParentModelIndex(getInt());
                relation.setParentBoneIndex(getInt());
                relations.add(relation);
            });
            pmmFileModel.setRelationSettings(relations);

            pmmFileModel.setSelectedConfiguration(getByte());

            pmmFileModel.setKeyframeConfigurationCount(getInt());
            List<PMMFileModelKeyframeConfigurationWithIndex> configurations = new ArrayList<>();
            IntStream.range(0, pmmFileModel.getKeyframeConfigurationCount()).mapToObj(configurationKeyframe -> new PMMFileModelKeyframeConfigurationWithIndex()).forEach(keyframe -> {
                keyframe.setDataIndex(getInt());
                keyframe.setKeyframeConfigurationData(parseConfigurationKeyframe());
                configurations.add(keyframe);
            });
            pmmFileModel.setConfigurationKeyframes(configurations);

            pmmFileModel.setCurrentBones(IntStream.range(0, pmmFileModel.getBoneCount()).mapToObj(bone -> parseBone()).collect(Collectors.toList()));
            pmmFileModel.setMorphValues(IntStream.range(0, pmmFileModel.getMorphCount()).mapToObj(morph -> getFloat()).collect(Collectors.toList()));
            pmmFileModel.setIkEnabled(IntStream.range(0, pmmFileModel.getIkBoneCount()).mapToObj(ik -> getByte()).collect(Collectors.toList()));

            List<PMMFileModelKeyframeConfigurationRelationCurrent> currentRelations = new ArrayList<>();
            IntStream.range(0, pmmFileModel.getParentableBoneCount()).mapToObj(bone -> new PMMFileModelKeyframeConfigurationRelationCurrent()).forEach(relation -> {
                relation.setKeyframePositionRelationBegin(getInt());
                relation.setKeyframePositionRelationEnd(getInt());
                relation.setParentModelIndex(getInt());
                relation.setParentBoneIndex(getInt());
                currentRelations.add(relation);
            });
            pmmFileModel.setCurrentRelationSettings(currentRelations);

            pmmFileModel.setBlend(getByte());
            pmmFileModel.setEdgeWidth(getFloat());
            pmmFileModel.setSelfShadowEnabled(getByte());
            pmmFileModel.setCalculationOrder(getByte());

            models.add(pmmFileModel);
        }
        return models;
    }

    public PMMFileModelKeyframe parseKeyframe() {
        PMMFileModelKeyframe keyframe = new PMMFileModelKeyframe();
        keyframe.setKeyframePosition(getInt());
        keyframe.setPreviousIndex(getInt());
        keyframe.setNextIndex(getInt());
        keyframe.setInterpolationX(new PMMFileModelKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
        keyframe.setInterpolationY(new PMMFileModelKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
        keyframe.setInterpolationZ(new PMMFileModelKeyframeInterpolation(getByte(), getByte(), getByte(), getByte()));
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

    public PMMFileModelMorphKeyframe parseMorphKeyframe() {
        PMMFileModelMorphKeyframe keyframe = new PMMFileModelMorphKeyframe();
        keyframe.setKeyframePosition(getInt());
        keyframe.setPreviousIndex(getInt());
        keyframe.setNextIndex(getInt());
        keyframe.setMorphValue(getFloat());
        keyframe.setSelected(getByte());
        return keyframe;
    }

    public PMMFileModelKeyframeConfiguration parseConfigurationKeyframe() {
        PMMFileModelKeyframeConfiguration keyframe = new PMMFileModelKeyframeConfiguration();
        keyframe.setKeyframePosition(getInt());
        keyframe.setPreviousIndex(getInt());
        keyframe.setNextIndex(getInt());
        keyframe.setVisible(getByte());
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

    public String getVariableString() throws UnsupportedEncodingException {
        int start = offset;
        int end = bytes[start];
        start += 1;
        offset += 1; //First byte was read to get length
        return getFixedString(start, end);
    }

    public String getFixedString(int start, int length) throws UnsupportedEncodingException {
        int end = start + length;
        byte[] result = new byte[length];
        for (int i = start; i < end; i++) {
            int resultIndex = i - start;
            result[resultIndex] = bytes[i];
            //System.out.println(result[resultIndex]);
        }
        //System.out.println("End of Byte Range");
        offset += length;
        return new String(result, "Shift-JIS");
    }

    public String getFixedString(int length) throws UnsupportedEncodingException {
        return getFixedString(offset, length);
    }
}
