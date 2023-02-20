package dev.xfj;

import dev.xfj.format.pmx.PMXFile;
import dev.xfj.parsing.PMXParser;
import dev.xfj.writer.PMXWriter;

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
        System.out.println(pmxFile.getSurfaces().get(67406).getVertexIndexB().getValue());
        System.out.println(pmxFile.getSurfaces().get(67407).getVertexIndexB().getValue());
        System.out.println(pmxFile.getTextureCount());
        pmxFile.getTexturePaths().forEach(System.out::println);
        pmxFile.getMaterials().forEach(material -> System.out.println(String.format("Name: %1$s\r\nEdge: %2$s %3$s %4$s %5$s\r\nScale: %6$s", material.getMaterialNameJapanese(), material.getEdgeColor().getX(), material.getEdgeColor().getY(), material.getEdgeColor().getZ(), material.getEdgeColor().getW(), material.getEdgeScale())));
        pmxFile.getBones().forEach(bone -> System.out.println(bone.getBoneNameJapanese()));
        pmxFile.getMorphs().forEach(morph -> System.out.println(morph.getMorphNameJapanese()));
        pmxFile.getDisplayFrames().forEach(frame -> System.out.println(String.format("Frame: %1$s (%2$s), special: %3$s", frame.getDisplayFrameNameJapanese(), frame.getDisplayFrameNameEnglish(), frame.getSpecialFlag())));
        pmxFile.getRigidBodies().forEach(body -> System.out.println(body.getRigidBodyNameJapanese()));
        pmxFile.getJoints().forEach(joint -> System.out.println(joint.getJointNameJapanese()));
        PMXWriter pmxWriter = new PMXWriter(pmxFile);
        pmxWriter.write();
        System.out.println(pmxWriter.getPmxFileSizeIn());
    }

}