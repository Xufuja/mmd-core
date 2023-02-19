package dev.xfj.writer;

import dev.xfj.format.pmx.PMXFile;

import java.io.IOException;
import java.nio.ByteBuffer;

public class PMXWriter implements Writer {
    private final PMXFile pmxFile;
    private ByteBuffer byteBuffer;
    private int pmxFileSizeIn;
    private int pmxFileSizeOut;

    public PMXWriter(PMXFile pmmFile) {
        this.pmxFile = pmmFile;
        this.pmxFileSizeIn = 0;
        this.pmxFileSizeOut = 0;
    }

    @Override
    public void write(boolean dryRun) throws IOException {

    }
}
