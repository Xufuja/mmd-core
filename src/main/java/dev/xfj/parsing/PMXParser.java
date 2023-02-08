package dev.xfj.parsing;

import dev.xfj.format.pmx.PMXFile;
import dev.xfj.format.pmx.PMXFileGlobals;
import dev.xfj.format.pmx.PMXFileVertex;
import dev.xfj.vec.Vec2;
import dev.xfj.vec.Vec3;
import dev.xfj.vec.Vec4;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PMXParser {
    private final Path path;
    private final byte[] bytes;
    private final ByteBuffer byteBuffer;
    private int offset;
    private Charset characterEncoding;
    private PMXFileGlobals globals;

    public PMXParser(Path path) throws IOException {
        this.path = path;
        this.bytes = Files.readAllBytes(this.path);
        this.byteBuffer = ByteBuffer.wrap(bytes);
        this.byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.offset = 0;
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
        pmxFile.setVertices(pmxFile.getVertextCount() > 0 ? IntStream.range(0, 1/*pmxFile.getVertextCount()*/).mapToObj(vertex -> parseVertex()).collect(Collectors.toList()) : Collections.emptyList());

        return pmxFile;
    }

    public PMXFileVertex parseVertex() {
        PMXFileVertex vertex = new PMXFileVertex();
        vertex.setPosition(getVec3());
        vertex.setNormal(getVec3());
        vertex.setUv(getVec2());
        vertex.setAdditionalVec4(globals.getAdditionalVec4Count() > 0 ? IntStream.range(0, globals.getAdditionalVec4Count()).mapToObj(vec4 -> getVec4()).collect(Collectors.toList()) : Collections.emptyList());
        vertex.setWeightDeformType(getByte());
        //After this parse the weightDeform based on the type: 0 = BDEF1, 1 = BDEF2, 2 = BDEF4, 3 = SDEF, 4 = QDEF
        //Based on the type, check the lookup table of what to read the lookup table requires you to read "index", float, and vec3
        //The bones value size depends on the "index", fetch the boneIndexType from globals, for bones: 1 = byte, 2 = short, 4 = int, values are signed
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

    public Vec2 getVec2() {
        return new Vec2(getFloat(), getFloat());
    }

    public Vec3 getVec3() {
        return new Vec3(getFloat(), getFloat(), getFloat());
    }

    public Vec4 getVec4() {
        return new Vec4(getFloat(), getFloat(), getFloat(), getFloat());
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
