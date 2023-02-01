package dev.xfj.parsing;

import dev.xfj.format.pmx.PMXFile;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Path;

public class PMXParser {
    private final Path path;
    private final byte[] bytes;
    private final ByteBuffer byteBuffer;
    private int offset;

    public PMXParser(Path path) throws IOException {
        this.path = path;
        this.bytes = Files.readAllBytes(this.path);
        this.byteBuffer = ByteBuffer.wrap(bytes);
        this.byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.offset = 0;
    }
    public void parse() {
        PMXFile pmxFile = new PMXFile();
    }
}
