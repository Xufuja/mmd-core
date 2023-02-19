package dev.xfj.writer;

import java.io.IOException;

public interface Writer {
    void write(boolean dryRun) throws IOException;

    default void write() throws IOException {
        write(true);
    }
}
