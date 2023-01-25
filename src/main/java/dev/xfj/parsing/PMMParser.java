package dev.xfj.parsing;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class PMMParser {
    private Path path;
    private ByteHandler bytes;

    public PMMParser(Path path) throws IOException {
        this.path = path;
        this.bytes = new ByteHandler(Files.readAllBytes(this.path));
    }

    public void parse() throws IOException {
        byte[] version = bytes.getByteRange(0, 30);
        byte[] outputWidth = bytes.getByteRange(30, 4);
        byte[] outputHeight = bytes.getByteRange(34, 4);
        byte[] keyFrameEditorWidth = bytes.getByteRange(38, 4);
        byte[] currentAngleOfView = bytes.getByteRange(42, 4);
        byte[] cameraLightingAccessory = bytes.getByteRange(46, 1);
        byte[] cameraPanel = bytes.getByteRange(47, 1);
        byte[] lightingPanel = bytes.getByteRange(48, 1);
        byte[] accessoryPanel = bytes.getByteRange(49, 1);
        byte[] bonePanel = bytes.getByteRange(50, 1);
        byte[] morphPanel = bytes.getByteRange(51, 1);
        byte[] selfShadowPanel = bytes.getByteRange(52, 1);
        byte[] selectedModelIndex = bytes.getByteRange(53, 1);
        byte[] modelCount = bytes.getByteRange(54, 1);
        byte[] modelIndex = bytes.getByteRange(55, 1);
        byte[] modelNameJapanese = bytes.getStringFromBytes(56);
        byte[] modelNameEnglish = bytes.getStringFromBytes(68);
        byte[] modelFilePath = bytes.getByteRange(80, 256);
        byte[] keyFrameEditorTopRows = bytes.getByteRange(336, 1);
        byte[] boneCount = bytes.getByteRange(337, 4);
        byte[] boneName = bytes.getStringFromBytes(341);
        byte[] morphCount = bytes.getByteRange(350, 4);
        byte[] morphName = bytes.getStringFromBytes(354);

        //https://stackoverflow.com/questions/68317293/charbuffer-to-string
        CharsetDecoder charsetDecoder = Charset.forName("Shift-JIS").newDecoder();
        ByteBuffer byteBuffer = ByteBuffer.wrap(modelNameJapanese);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        try {
            System.out.println(charsetDecoder.decode(byteBuffer).toString());

        } catch (CharacterCodingException e) {
            System.out.println(e.toString());
            //return false;
        }

        System.out.println(new String(version, "Shift-JIS"));
        System.out.println(bytes.getLittleEndianBuffer(outputWidth).getInt());
        System.out.println(bytes.getLittleEndianBuffer(outputHeight).getInt());
        System.out.println(bytes.getLittleEndianBuffer(currentAngleOfView).getFloat());
        System.out.println(bytes.getLittleEndianBuffer(modelCount).get());
        System.out.println(bytes.getLittleEndianBuffer(modelIndex).get());
        System.out.println(new String(modelNameJapanese, "Shift-JIS"));
        System.out.println(new String(modelNameEnglish, "Shift-JIS"));
        System.out.println(new String(modelFilePath, "Shift-JIS"));
        System.out.println(bytes.getLittleEndianBuffer(keyFrameEditorTopRows).get());
        System.out.println(bytes.getLittleEndianBuffer(boneCount).getInt());
        System.out.println(new String(boneName, "Shift-JIS"));
        System.out.println(bytes.getLittleEndianBuffer(morphCount).getInt());
        System.out.println(new String(morphName, "Shift-JIS"));
    }
}
