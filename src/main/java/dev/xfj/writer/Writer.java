package dev.xfj.writer;

import java.io.IOException;
import java.nio.file.Path;

public sealed interface Writer permits PMMWriter, PMXWriter{
    void write(Path path) throws IOException;
}
