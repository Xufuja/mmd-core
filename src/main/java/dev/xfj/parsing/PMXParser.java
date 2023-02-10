package dev.xfj.parsing;

import dev.xfj.format.pmx.PMXFile;
import dev.xfj.format.pmx.PMXFileGlobals;
import dev.xfj.format.pmx.PMXFileVertex;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PMXParser extends Parser{
    private Charset characterEncoding;
    private PMXFileGlobals globals;

    public PMXParser(Path path) throws IOException {
        super(path);
        this.characterEncoding = StandardCharsets.UTF_8;
    }

    //Based on https://gist.github.com/felixjones/f8a06bd48f9da9a4539f
    public PMXFile parse() {
        PMXFile pmxFile = new PMXFile();
        pmxFile.setSignature(getFixedString(4));
        pmxFile.setVersion(getFloat());
        pmxFile.setGlobalsCount(getByte());
        pmxFile.setGlobals(parseGlobals());
        characterEncoding = pmxFile.getGlobals().getTextEncoding() == 1 ? StandardCharsets.UTF_8 : StandardCharsets.UTF_16LE;
        pmxFile.setModelNameJapanese(getVariableString());
        pmxFile.setModelNameEnglish(getVariableString());
        pmxFile.setCommentsJapanese(getVariableString());
        pmxFile.setCommentsEnglish(getVariableString());
        pmxFile.setVertextCount(getInt());
        pmxFile.setVertices(pmxFile.getVertextCount() > 0 ? IntStream.range(0, pmxFile.getVertextCount()).mapToObj(vertex -> parseVertex()).collect(Collectors.toList()) : Collections.emptyList());

        return pmxFile;
    }

    public enum WeightDeformType {
        BDEF1,
        BDEF2,
        BDEF4,
        SDEF,
        QDEF
    }

    public PMXFileVertex parseVertex() {
        PMXFileVertex vertex = new PMXFileVertex();
        vertex.setPosition(getVec3());
        vertex.setNormal(getVec3());
        vertex.setUv(getVec2());
        vertex.setAdditionalVec4(globals.getAdditionalVec4Count() > 0 ? IntStream.range(0, globals.getAdditionalVec4Count()).mapToObj(vec4 -> getVec4()).collect(Collectors.toList()) : Collections.emptyList());
        vertex.setWeightDeformType(getByte());
        WeightDeformType type = WeightDeformType.values()[vertex.getWeightDeformType()];
        List<Short> boneIndices = new ArrayList<>();
        List<Float> boneWeight = new ArrayList<>();
        switch (type) {
            case BDEF1 -> {
                boneIndices.add(getShort());
                boneWeight.add(1.0f);
            }
            case BDEF2, SDEF -> {
                boneIndices.add(getShort());
                boneIndices.add(getShort());
                float bone1 = getFloat();
                boneWeight.add(bone1);
                boneWeight.add(1.0f - bone1);
            }
            case BDEF4, QDEF -> {
                boneIndices.add(getShort());
                boneIndices.add(getShort());
                boneIndices.add(getShort());
                boneIndices.add(getShort());
                boneWeight.add(getFloat());
                boneWeight.add(getFloat());
                boneWeight.add(getFloat());
                boneWeight.add(getFloat());
            }
        }
        vertex.setBoneIndices(boneIndices);
        vertex.setBoneWeights(boneWeight);
        if (type == WeightDeformType.SDEF) {
            vertex.setC(getVec3());
            vertex.setR0(getVec3());
            vertex.setR1(getVec3());
        }
        vertex.setEdgeScale(getFloat());

        return vertex;
    }

    public PMXFileGlobals parseGlobals() {
        PMXFileGlobals globals = new PMXFileGlobals();
        globals.setTextEncoding(getByte());
        globals.setAdditionalVec4Count(getByte());
        globals.setVertexIndexSize(getByte());
        globals.setTextureIndexSize(getByte());
        globals.setMaterialIndexSize(getByte());
        globals.setBoneIndexSize(getByte());
        globals.setMorphIndexSize(getByte());
        globals.setRigidBodyIndexSize(getByte());
        this.globals = globals;
        return globals;
    }

    public String getVariableString() {
        int start = offset;
        int length = getInt();
        start += 4;
        return getFixedString(start, length);
    }

    public String getFixedString(int start, int length) {
        int end = start + length;
        byte[] result = new byte[length];
        for (int i = start; i < end; i++) {
            int resultIndex = i - start;
            result[resultIndex] = bytes[i];
            //System.out.println(result[resultIndex]);
        }
        //System.out.println("End of Byte Range");
        offset += length;
        ByteBuffer buffer = ByteBuffer.wrap(result);
        return characterEncoding.decode(buffer).toString();
    }

    public String getFixedString(int length) {
        return getFixedString(offset, length);
    }
}
