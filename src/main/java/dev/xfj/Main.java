package dev.xfj;

import dev.xfj.format.pmx.PMXFile;
import dev.xfj.parsing.PMXParser;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        PMXParser pmxParser = new PMXParser(Path.of("test_in_01.pmx"));
        PMXFile pmxFile = pmxParser.parse();
        System.out.println(pmxFile.getSignature());
        System.out.println(pmxFile.getGlobalsCount());
        System.out.println(pmxFile.getGlobals().getTextEncoding());
        System.out.println(pmxFile.getModelNameEnglish());
        System.out.println(pmxFile.getCommentsEnglish());
        System.out.println(pmxFile.getModelNameJapanese());
        System.out.println(pmxFile.getVertextCount());
        System.out.println(pmxFile.getSurfaceCount());
        System.out.println(pmxFile.getSurfaces().get(67406).getVertexIndexB());
        System.out.println(pmxFile.getSurfaces().get(67407).getVertexIndexB());
        System.out.println(pmxFile.getTextureCount());
        pmxFile.getTexturePaths().forEach(System.out::println);
        pmxFile.getMaterials().forEach(material -> System.out.println(String.format("Name: %1$s\r\nEdge: %2$s %3$s %4$s %5$s\r\nScale: %6$s", material.getMaterialNameJapanese(), material.getEdgeColor().getX(), material.getEdgeColor().getY(), material.getEdgeColor().getZ(), material.getEdgeColor().getW(), material.getEdgeScale())));
        pmxFile.getBones().forEach(bone -> System.out.println(bone.getBoneNameJapanese()));
    }

}