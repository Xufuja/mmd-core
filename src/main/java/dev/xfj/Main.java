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
        System.out.println(pmxFile.getCommentsJapanese());
    }

}