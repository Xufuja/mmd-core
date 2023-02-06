package dev.xfj.pmm;

import dev.xfj.format.pmm.PMMFile;
import dev.xfj.parsing.PMMParser;
import dev.xfj.writer.PMMWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PMMTests {
    @Test
    @DisplayName("Test if PMM Parser and PMM Writer work")
    void bytesReadEqualsBytesWrittenWithoutChanges() throws IOException {
        PMMParser pmmParser = new PMMParser(Path.of("test_in_02.pmm"));
        PMMFile pmmFile = pmmParser.parse();
        PMMWriter pmmWriter = new PMMWriter(pmmFile);
        pmmWriter.write();
        int pmmFileSizeIn = pmmWriter.getPmmFileSizeIn();;
        int pmmFileSizeOut = pmmWriter.getPmmFileSizeOut();
        System.out.println(String.format("Read:  %1$s bytes from file", pmmFileSizeIn));
        System.out.println(String.format("Wrote: %1$s bytes to buffer", pmmFileSizeOut));
        assertEquals(pmmWriter.getPmmFileSizeIn(), pmmWriter.getPmmFileSizeOut());
    }
}
