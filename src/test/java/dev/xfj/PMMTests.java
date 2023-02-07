package dev.xfj;

import dev.xfj.format.pmm.PMMFile;
import dev.xfj.parsing.PMMParser;
import dev.xfj.writer.PMMWriter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PMMTests {
    private PMMFile pmmFile;

    @BeforeAll
    void loadPMMFile() throws IOException {
        PMMParser pmmParser = new PMMParser(Path.of("test_in_01.pmm"));
        pmmFile = pmmParser.parse();
    }

    @Test
    @DisplayName("Check if fixed length string can be read")
    void parseFixedLengthString() {
        System.out.println(pmmFile.getVersion());
        assertEquals(pmmFile.getVersion().trim(), "Polygon Movie maker 0002".trim());
    }

    @Test
    @DisplayName("Check if variable length string can be read")
    void parseVariableLengthString() {
        System.out.println(pmmFile.getPmmFileModels().get(0).getMorphNames().get(0));
        assertEquals(pmmFile.getPmmFileModels().get(0).getMorphNames().get(0), "SunRadius+");
    }

    @Test
    @DisplayName("Check if byte can be read")
    void parseByte() {
        System.out.println(pmmFile.getModelCount());
        assertEquals(pmmFile.getModelCount(), 9);
    }

    @Test
    @DisplayName("Check if float can be read")
    void parseFloat() {
        System.out.println(pmmFile.getCurrentAngleOfView());
        assertEquals(pmmFile.getCurrentAngleOfView(), 30.0f);
    }

    @Test
    @DisplayName("Check if int can be read")
    void parseInt() {
        System.out.println(pmmFile.getOutputWidth());
        assertEquals(pmmFile.getOutputWidth(), 3840);
    }

    @Test
    @DisplayName("Test if PMM Parser and PMM Writer work")
    void bytesReadEqualsBytesWrittenWithoutChanges() throws IOException {
        PMMParser pmmParser = new PMMParser(Path.of("test_in_01.pmm"));
        PMMFile pmmFile = pmmParser.parse();
        PMMWriter pmmWriter = new PMMWriter(pmmFile);
        pmmWriter.write();
        int pmmFileSizeIn = pmmWriter.getPmmFileSizeIn();
        ;
        int pmmFileSizeOut = pmmWriter.getPmmFileSizeOut();
        System.out.println(String.format("Read:  %1$s bytes from file", pmmFileSizeIn));
        System.out.println(String.format("Wrote: %1$s bytes to buffer", pmmFileSizeOut));
        assertEquals(pmmWriter.getPmmFileSizeIn(), pmmWriter.getPmmFileSizeOut());
    }
}
