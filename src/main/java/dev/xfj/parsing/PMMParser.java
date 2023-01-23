package dev.xfj.parsing;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
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
        byte[] outputWidth = bytes.getByteRange(30, 34);
        byte[] outputHeight = bytes.getByteRange(34, 38);
        byte[] keyFrameEditorWidth = bytes.getByteRange(38, 42);
        byte[] currentAngleOfView = bytes.getByteRange(42, 46);
        byte[] cameraLightingAccessory = bytes.getByteRange(46, 47);
        byte[] cameraPane = bytes.getByteRange(47, 48);
        byte[] lightingPane = bytes.getByteRange(48, 49);
        byte[] accessoryPane = bytes.getByteRange(49, 50);
        byte[] bonePane = bytes.getByteRange(50, 51);
        byte[] morphPane = bytes.getByteRange(51, 52);
        byte[] selfShadowPane = bytes.getByteRange(52, 53);
        byte[] selectedModelIndex = bytes.getByteRange(53, 54);
        byte[] modelCount = bytes.getByteRange(54, 55);
        byte[] modelIndex = bytes.getByteRange(55, 56);
        //byte[] modelNameJapanese = bytes.getByteRange(55, bytes.getBytes().length);

        System.out.println(new String(version, StandardCharsets.UTF_8));
        System.out.println(bytes.getLittleEndianBuffer(outputWidth).getInt());
        System.out.println(bytes.getLittleEndianBuffer(outputHeight).getInt());
        System.out.println(bytes.getLittleEndianBuffer(modelCount).get());
        System.out.println(bytes.getLittleEndianBuffer(modelIndex).get());
        //System.out.println(new String(modelNameJapanese, StandardCharsets.UTF_8));
    }
}
