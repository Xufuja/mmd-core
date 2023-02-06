package dev.xfj;

import dev.xfj.format.pmm.PMMFile;
import dev.xfj.parsing.PMMParser;
import dev.xfj.writer.PMMWriter;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        PMMParser pmmParser = new PMMParser(Path.of("test_in_02.pmm"));
        PMMFile pmmFile = pmmParser.parse();

        PMMWriter pmmWriter = new PMMWriter(pmmFile);
        pmmWriter.write(true);

    }


}