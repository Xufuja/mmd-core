package dev.xfj.parsing;

import dev.xfj.format.PMMFile;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class PMMParser {
    private Path path;
    private ByteHandler bytes;

    public PMMParser(Path path) throws IOException {
        this.path = path;
        this.bytes = new ByteHandler(Files.readAllBytes(this.path));

    }

    public void parse() throws IOException {

        PMMFile pmmFile = new PMMFile();
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes.getBytes());
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        pmmFile.setVersion(new String(bytes.getByteRange(0, 30), "Shift-JIS"));
        pmmFile.setOutputWidth(byteBuffer.getInt(30));
        pmmFile.setOutputHeight(byteBuffer.getInt(34));
        pmmFile.setKeyFrameEditorWidth(byteBuffer.getInt(38));
        pmmFile.setCurrentAngleOfView(byteBuffer.getFloat(42));
        pmmFile.setCameraLightingAccessory(byteBuffer.get(46));
        pmmFile.setCameraPanel(byteBuffer.get(47));
        pmmFile.setLightingPanel(byteBuffer.get(48));
        pmmFile.setAccessoryPanel(byteBuffer.get(49));
        pmmFile.setBonePanel(byteBuffer.get(50));
        pmmFile.setMorphPanel(byteBuffer.get(51));
        pmmFile.setSelfShadowPanel(byteBuffer.get(52));
        pmmFile.setSelectedModelIndex(byteBuffer.get(53));
        pmmFile.setModelCount(byteBuffer.get(54));
        pmmFile.setModelIndex(byteBuffer.get(55));
        pmmFile.setModelNameJapanese(new String(bytes.getStringFromBytes(56), "Shift-JIS"));
        pmmFile.setModelNameEnglish(new String(bytes.getStringFromBytes(68), "Shift-JIS"));
        pmmFile.setModelFilePath(new String(bytes.getByteRange(80, 256), "Shift-JIS"));
        pmmFile.setKeyFrameEditorTopRows(byteBuffer.get(336));
        pmmFile.setBoneCount(byteBuffer.getInt(337));
        pmmFile.setBoneName(new String(bytes.getStringFromBytes(341), "Shift-JIS"));
        pmmFile.setMorphCount(byteBuffer.getInt(350));
        pmmFile.setMorphName(new String(bytes.getStringFromBytes(354), "Shift-JIS"));


        System.out.println(pmmFile.getVersion());
        System.out.println(pmmFile.getOutputWidth());
        System.out.println(pmmFile.getModelNameJapanese());
        System.out.println(pmmFile.getModelFilePath());
        System.out.println(pmmFile.getMorphName());
        //https://stackoverflow.com/questions/68317293/charbuffer-to-string
        /*CharsetDecoder charsetDecoder = Charset.forName("Shift-JIS").newDecoder();
        ByteBuffer byteBuffer = ByteBuffer.wrap(modelNameJapanese);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);

        try {
            System.out.println(charsetDecoder.decode(byteBuffer).toString());

        } catch (CharacterCodingException e) {
            System.out.println(e.toString());
            //return false;
        }*/
    }

}
