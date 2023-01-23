package dev.xfj;

import dev.xfj.parsing.PMMParser;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        PMMParser pmm = new PMMParser(Path.of("Ray_Birthday_Ikenai.pmm"));
        pmm.parse();
    }


}