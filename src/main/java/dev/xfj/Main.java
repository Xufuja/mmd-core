package dev.xfj;

import dev.xfj.format.pmm.PMMFile;
import dev.xfj.parsing.PMMParser;
import dev.xfj.writer.PMMWriter;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        PMMParser pmmParser = new PMMParser(Path.of("Ray_Birthday_Ikenai.pmm"));
        PMMFile pmmFile = pmmParser.parse();
        System.out.println(pmmFile.getVersion());
        System.out.println(pmmFile.getOutputWidth());
        pmmFile.getPmmFileModels().forEach(model -> System.out.println(model.getModelNameJapanese()));
        pmmFile.getPmmFileModels().forEach(model -> System.out.println(model.getModelNameEnglish()));
        pmmFile.getPmmFileModels().forEach(model -> System.out.println(model.getCalculationOrder()));
        pmmFile.getPmmFileModels().forEach(model -> System.out.println(model.getModelFilePath()));
        pmmFile.getPmmFileModels().forEach(model -> model.getBoneNames().forEach(System.out::println));
        pmmFile.getPmmFileModels().forEach(model -> model.getMorphNames().forEach(System.out::println));
        pmmFile.getPmmFileModels().forEach(model -> System.out.println(model.getSelfShadowEnabled()));
        pmmFile.getPmmFileCamera().getCameraKeyframes().forEach(camera -> System.out.println(camera.getCameraKeyframeData().getKeyframePosition() + " " + camera.getCameraKeyframeData().getDistance()));
        pmmFile.getPmmFileCamera().getCameraKeyframes().forEach(camera -> System.out.println(camera.getCameraKeyframeData().getAngleOfView()));
        System.out.println(pmmFile.getPmmFileCamera().getOrthographicCameraEnabled());
        System.out.println(String.format("RGB: %1$s %2$s %3$s", pmmFile.getPmmFileLighting().getCurrentLightingData().getR(), pmmFile.getPmmFileLighting().getCurrentLightingData().getG(), pmmFile.getPmmFileLighting().getCurrentLightingData().getB()));
        System.out.println(String.format("XYZ: %1$s %2$s %3$s", pmmFile.getPmmFileLighting().getCurrentLightingData().getX(), pmmFile.getPmmFileLighting().getCurrentLightingData().getY(), pmmFile.getPmmFileLighting().getCurrentLightingData().getZ()));
        pmmFile.getAccessoryNames().forEach(System.out::println);
        pmmFile.getPmmFileAccessories().forEach(accessory -> System.out.println(String.format("%1$s: XYZ: %2$s %3$s %4$s", accessory.getAccessoryName(), accessory.getCurrentAccessoryData().getRotationX(), accessory.getCurrentAccessoryData().getRotationY(), accessory.getCurrentAccessoryData().getRotationZ())));
        System.out.println(pmmFile.getBoneOperationMethod());
        System.out.println(pmmFile.getPlayStartFrame());
        System.out.println(pmmFile.getPlayEndFrame());
        System.out.println(pmmFile.getShowInformation());
        System.out.println(pmmFile.getShowAxis());
        System.out.println(pmmFile.getFpsLimit());
        System.out.println(pmmFile.getPhysicsMode());
        System.out.println(pmmFile.getPmmFileGravity().getGravityKeyframeCount());
        System.out.println(pmmFile.getPmmFileGravity().getGravityInitialKeyframe().getNoiseAmount());
        System.out.println(pmmFile.getPmmFileGravity().getGravityInitialKeyframe().getDirectionX());
        System.out.println(pmmFile.getPmmFileGravity().getGravityInitialKeyframe().getDirectionY());
        System.out.println(pmmFile.getPmmFileGravity().getGravityInitialKeyframe().getDirectionZ());
        System.out.println(pmmFile.getPmmFileSelfShadow().getSelfShadowKeyframeCount());
        System.out.println(pmmFile.getPmmFileSelfShadow().getSelfShadowInitialKeyframe().getDistance());
        System.out.println(pmmFile.getSelectorChoiceFollowing());

        PMMWriter pmmWriter = new PMMWriter(pmmFile);
        pmmWriter.write();
    }


}