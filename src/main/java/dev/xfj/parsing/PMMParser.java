package dev.xfj.parsing;

import dev.xfj.format.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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
        pmmFile.setVersion(getFixedString(offset, 30));
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
        pmmFile.setPmmFileModels(parseModels((byte) 1)); //pmmFile.getModelCount()

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
            pmmFileModel.setModelNameJapanese(getVariableString(offset));
            pmmFileModel.setModelNameEnglish(getVariableString(offset));
            pmmFileModel.setModelFilePath(getFixedString(offset, 256));
            pmmFileModel.setKeyFrameEditorTopRows(getByte());

            pmmFileModel.setBoneCount(getInt());
            pmmFileModel.setBoneNames(IntStream.range(0, pmmFileModel.getBoneCount()).mapToObj(bone -> {
                try {
                    return getVariableString(offset);
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList()));

            pmmFileModel.setMorphCount(getInt());
            pmmFileModel.setMorphNames(IntStream.range(0, pmmFileModel.getMorphCount()).mapToObj(morph -> {
                try {
                    return getVariableString(offset);
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList()));

            pmmFileModel.setIkBoneCount(getInt());
            pmmFileModel.setIkBoneIndices(IntStream.range(0, pmmFileModel.getIkBoneCount()).mapToObj(ikBone -> getInt()).collect(Collectors.toList()));

            pmmFileModel.setParentableBoneCount(getInt());
            pmmFileModel.setParentableBoneIndices(IntStream.range(0, pmmFileModel.getIkBoneCount()).mapToObj(ikBone -> getInt()).collect(Collectors.toList()));

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

    public String getVariableString(int start) throws UnsupportedEncodingException {
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
}
