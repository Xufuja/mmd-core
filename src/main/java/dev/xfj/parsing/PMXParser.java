package dev.xfj.parsing;

import dev.xfj.format.pmx.PMXFile;
import dev.xfj.format.pmx.PMXFileGlobals;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class PMXParser {
    private final Path path;
    private final byte[] bytes;
    private final ByteBuffer byteBuffer;
    private int offset;
    private Charset characterEncoding;

    public PMXParser(Path path) throws IOException {
        this.path = path;
        this.bytes = Files.readAllBytes(this.path);
        this.byteBuffer = ByteBuffer.wrap(bytes);
        this.byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.offset = 0;
        this.characterEncoding = StandardCharsets.UTF_8;
    }

    public PMXFile parse() {
        PMXFile pmxFile = new PMXFile();
        pmxFile.setSignature(getFixedString(4));
        pmxFile.setVersion(getFloat());
        pmxFile.setGlobalsCount(getByte());
        pmxFile.setGlobals(parseGlobals());
        characterEncoding = pmxFile.getGlobals().getTextEncoding() == 1 ? StandardCharsets.UTF_8 : StandardCharsets.UTF_16;
        pmxFile.setModelNameJapanese(getVariableString());
        pmxFile.setModelNameEnglish(getVariableString());
        pmxFile.setCommentsJapanese(getVariableString());
        pmxFile.setCommentsEnglish(getVariableString());
        return pmxFile;
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
            if (bytes[i] == 0) {
                break;
            }
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
