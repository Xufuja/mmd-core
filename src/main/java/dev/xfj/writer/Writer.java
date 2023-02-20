package dev.xfj.writer;

import java.io.IOException;

public sealed interface Writer permits PMMWriter, PMXWriter{
    void write(boolean dryRun) throws IOException;

    default void write() throws IOException {
        write(true);
    }
}
