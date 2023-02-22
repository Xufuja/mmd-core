package dev.xfj;

import dev.xfj.format.pmx.PMXFile;
import dev.xfj.parsing.PMXParser;
import dev.xfj.writer.PMXWriter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PMXTests {
    private PMXFile pmxFile;

    @BeforeAll
    void loadPMXFile() throws IOException {
        PMXParser pmxParser = new PMXParser(Path.of("test_in_01.pmx"));
        pmxFile = pmxParser.parse();
    }

    @Test
    @DisplayName("Check if fixed length string can be read")
    void parseFixedLengthString() {
        System.out.println(pmxFile.getSignature());
        assertEquals("PMX ", pmxFile.getSignature());
    }

    @Test
    @DisplayName("Check if variable length string can be read")
    void parseVariableLengthString() {
        System.out.println(pmxFile.getModelNameJapanese());
        assertEquals("TDA Standard Haku", pmxFile.getModelNameJapanese());
    }

    @Test
    @DisplayName("Check if byte can be read")
    void parseByte() {
        System.out.println(pmxFile.getGlobalsCount());
        assertEquals(Byte.valueOf((byte) 8), pmxFile.getGlobalsCount());
    }

    @Test
    @DisplayName("Check if short can be read")
    void parseShort() {
        System.out.println(pmxFile.getRigidBodies().get(0).getNonCollisionGroup());
        assertEquals(Short.valueOf((short) -882), pmxFile.getRigidBodies().get(0).getNonCollisionGroup());
    }

    @Test
    @DisplayName("Check if float can be read")
    void parseFloat() {
        System.out.println(pmxFile.getVersion());
        assertEquals(2.0f, pmxFile.getVersion());
    }

    @Test
    @DisplayName("Check if int can be read")
    void parseInt() {
        System.out.println(pmxFile.getVertextCount());
        assertEquals(44307, pmxFile.getVertextCount());
    }

    @Test
    @DisplayName("Check if vec2 can be read")
    void parseVec2() {
        System.out.println(pmxFile.getVertices().get(0).getUv().getX());
        assertEquals(0.13412f, pmxFile.getVertices().get(0).getUv().getX());
    }

    @Test
    @DisplayName("Check if vec3 can be read")
    void parseVec3() {
        System.out.println(pmxFile.getVertices().get(0).getPosition());
        assertEquals(0.35429734f, pmxFile.getVertices().get(0).getPosition().getX());
    }

    @Test
    @DisplayName("Check if vec4 can be read")
    void parseVec4() {
        System.out.println(pmxFile.getMaterials().get(0).getDiffuseColor());
        assertEquals(1.0f, pmxFile.getMaterials().get(0).getDiffuseColor().getX());
    }

    @Test
    @DisplayName("Test if PMX Parser and PMX Writer work")
    void bytesReadEqualsBytesWrittenWithoutChanges() throws IOException {
        PMXParser pmxParser = new PMXParser(Path.of("test_in_01.pmx"));
        PMXFile pmxFile = pmxParser.parse();
        PMXWriter pmxWriter = new PMXWriter(pmxFile);
        pmxWriter.write();
        int pmxFileSizeIn = pmxWriter.getPmxFileSizeIn();

        int pmxFileSizeOut = pmxWriter.getPmxFileSizeOut();
        System.out.println(String.format("Read:  %1$s bytes from file", pmxFileSizeIn));
        System.out.println(String.format("Wrote: %1$s bytes to buffer", pmxFileSizeOut));
        assertEquals(pmxWriter.getPmxFileSizeIn(), pmxWriter.getPmxFileSizeOut());
    }
}
