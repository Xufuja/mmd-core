package dev.xfj.parsing;

import dev.xfj.format.pmx.*;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PMXParser extends Parser{
    private Charset characterEncoding;
    private PMXFileGlobals globals;

    public PMXParser(Path path) throws IOException {
        super(path);
        this.characterEncoding = StandardCharsets.UTF_8;
    }

    //Based on https://gist.github.com/felixjones/f8a06bd48f9da9a4539f
    public PMXFile parse() {
        PMXFile pmxFile = new PMXFile();
        pmxFile.setSignature(getFixedString(4));
        pmxFile.setVersion(getFloat());
        pmxFile.setGlobalsCount(getByte());
        pmxFile.setGlobals(parseGlobals());
        characterEncoding = pmxFile.getGlobals().getTextEncoding() == 1 ? StandardCharsets.UTF_8 : StandardCharsets.UTF_16LE;
        pmxFile.setModelNameJapanese(getVariableString());
        pmxFile.setModelNameEnglish(getVariableString());
        pmxFile.setCommentsJapanese(getVariableString());
        pmxFile.setCommentsEnglish(getVariableString());
        pmxFile.setVertextCount(getInt32());
        pmxFile.setVertices(pmxFile.getVertextCount() > 0 ? IntStream.range(0, pmxFile.getVertextCount()).mapToObj(vertex -> parseVertex()).collect(Collectors.toList()) : Collections.emptyList());
        pmxFile.setSurfaceCount(getInt32());
        pmxFile.setSurfaces(pmxFile.getSurfaceCount() > 0 ? IntStream.range(0, (pmxFile.getSurfaceCount() / 3)).mapToObj(surface -> parseVertexIndex()).collect(Collectors.toList()) : Collections.emptyList());
        pmxFile.setTextureCount(getInt32());
        pmxFile.setTexturePaths(pmxFile.getTextureCount() > 0 ? IntStream.range(0, pmxFile.getTextureCount()).mapToObj(texture -> getVariableString()).collect(Collectors.toList()) : Collections.emptyList());
        pmxFile.setMaterialCount(getInt32());
        pmxFile.setMaterials(pmxFile.getMaterialCount() > 0 ? IntStream.range(0, pmxFile.getMaterialCount()).mapToObj(material -> parseMaterial()).collect(Collectors.toList()) : Collections.emptyList());
        pmxFile.setBoneCount(getInt32());
        pmxFile.setBones(pmxFile.getBoneCount() > 0 ? IntStream.range(0, pmxFile.getBoneCount()).mapToObj(bone -> parseBone()).collect(Collectors.toList()) : Collections.emptyList());
        pmxFile.setMorphCount(getInt32());
        pmxFile.setMorphs(pmxFile.getMorphCount() > 0 ? IntStream.range(0, pmxFile.getMorphCount()).mapToObj(morph -> parseMorph()).collect(Collectors.toList()) : Collections.emptyList());
        pmxFile.setDisplayFrameCount(getInt32());
        pmxFile.setDisplayFrames(pmxFile.getDisplayFrameCount() > 0 ? IntStream.range(0, pmxFile.getDisplayFrameCount()).mapToObj(frame -> parseDisplayFrame()).collect(Collectors.toList()) : Collections.emptyList());
        pmxFile.setRigidBodyCount(getInt32());
        pmxFile.setRigidBodies(pmxFile.getRigidBodyCount() > 0 ? IntStream.range(0, pmxFile.getRigidBodyCount()).mapToObj(body -> parseRigidBody()).collect(Collectors.toList()) : Collections.emptyList());

        return pmxFile;
    }

    public enum WeightDeformType {
        BDEF1,
        BDEF2,
        BDEF4,
        SDEF,
        QDEF
    }

    public PMXFileVertex parseVertex() {
        PMXFileVertex vertex = new PMXFileVertex();
        vertex.setPosition(getVec3());
        vertex.setNormal(getVec3());
        vertex.setUv(getVec2());
        vertex.setAdditionalVec4(globals.getAdditionalVec4Count() > 0 ? IntStream.range(0, globals.getAdditionalVec4Count()).mapToObj(vec4 -> getVec4()).collect(Collectors.toList()) : Collections.emptyList());
        vertex.setWeightDeformType(getByte());
        WeightDeformType type = WeightDeformType.values()[vertex.getWeightDeformType()];
        List<Object> boneIndices = new ArrayList<>();
        List<Float> boneWeight = new ArrayList<>();
        switch (type) {
            case BDEF1 -> {
                switch (globals.getBoneIndexSize()) {
                    case 1 -> boneIndices.add(getByte());
                    case 2 -> boneIndices.add(getInt16());
                    case 4 -> boneIndices.add(getInt32());
                }
                boneWeight.add(1.0f);
            }
            case BDEF2, SDEF -> {
                switch (globals.getBoneIndexSize()) {
                    case 1 -> {
                        boneIndices.add(getByte());
                        boneIndices.add(getByte());
                    }
                    case 2 -> {
                        boneIndices.add(getInt16());
                        boneIndices.add(getInt16());
                    }
                    case 4 -> {
                        boneIndices.add(getInt32());
                        boneIndices.add(getInt32());
                    }
                }
                float bone1 = getFloat();
                boneWeight.add(bone1);
                boneWeight.add(1.0f - bone1);
            }
            case BDEF4, QDEF -> {
                switch (globals.getBoneIndexSize()) {
                    case 1 -> {
                        boneIndices.add(getByte());
                        boneIndices.add(getByte());
                        boneIndices.add(getByte());
                        boneIndices.add(getByte());
                    }
                    case 2 -> {
                        boneIndices.add(getInt16());
                        boneIndices.add(getInt16());
                        boneIndices.add(getInt16());
                        boneIndices.add(getInt16());
                    }
                    case 4 -> {
                        boneIndices.add(getInt32());
                        boneIndices.add(getInt32());
                        boneIndices.add(getInt32());
                        boneIndices.add(getInt32());
                    }
                }
                boneWeight.add(getFloat());
                boneWeight.add(getFloat());
                boneWeight.add(getFloat());
                boneWeight.add(getFloat());
            }
        }
        vertex.setBoneIndices(boneIndices);
        vertex.setBoneWeights(boneWeight);
        if (type == WeightDeformType.SDEF) {
            vertex.setC(getVec3());
            vertex.setR0(getVec3());
            vertex.setR1(getVec3());
        }
        vertex.setEdgeScale(getFloat());

        return vertex;
    }

    public PMXFileVertexIndex parseVertexIndex() {
        PMXFileVertexIndex vertexIndex = new PMXFileVertexIndex();
        switch (globals.getVertexIndexSize()) {
            case 1 -> {
               vertexIndex.setVertexIndexA(getUByte());
               vertexIndex.setVertexIndexB(getUByte());
               vertexIndex.setVertexIndexC(getUByte());
            }
            case 2 -> {
                vertexIndex.setVertexIndexA(getUInt16());
                vertexIndex.setVertexIndexB(getUInt16());
                vertexIndex.setVertexIndexC(getUInt16());
            }
            case 4 -> {
                vertexIndex.setVertexIndexA(getInt32());
                vertexIndex.setVertexIndexB(getInt32());
                vertexIndex.setVertexIndexC(getInt32());
            }
        }
        return vertexIndex;
    }

    public PMXFileMaterial parseMaterial() {
        PMXFileMaterial material = new PMXFileMaterial();
        material.setMaterialNameJapanese(getVariableString());
        material.setMaterialNameEnglish(getVariableString());
        material.setDiffuseColor(getVec4());
        material.setSpecularColor(getVec3());
        material.setSpecularStrength(getFloat());
        material.setAmbientColor(getVec3());
        material.setMaterialFlags(getByte());
        material.setEdgeColor(getVec4());
        material.setEdgeScale(getFloat());
        switch (globals.getTextureIndexSize()) {
            case 1 -> {
                material.setTextureIndex(getByte());
                material.setEnvironmentIndex(getByte());
            }
            case 2 -> {
                material.setTextureIndex(getInt16());
                material.setEnvironmentIndex(getInt16());
            }
            case 4 -> {
                material.setTextureIndex(getInt32());
                material.setEnvironmentIndex(getInt32());
            }
        }
        material.setEnvironmentBlendMode(getByte());
        material.setToonReference(getByte());
        if (material.getToonReference() == 1) {
            material.setToonValue(getByte());
        } else {
            switch (globals.getTextureIndexSize()) {
                case 1 -> material.setToonValue(getByte());
                case 2 -> material.setToonValue(getInt16());
                case 4 -> material.setToonValue(getInt32());
            }
        }
        material.setMetaData(getVariableString());
        material.setSurfaceCount(getInt32());

        return material;
    }

    public PMXFileBone parseBone() {
        PMXFileBone bone = new PMXFileBone();
        bone.setBoneNameJapanese(getVariableString());
        bone.setBonenameEnglish(getVariableString());
        bone.setPosition(getVec3());
        switch (globals.getBoneIndexSize()) {
            case 1 -> bone.setParentBoneIndex(getByte());
            case 2 -> bone.setParentBoneIndex(getInt16());
            case 4 -> bone.setParentBoneIndex(getInt32());
        }
        bone.setLayer(getInt32());
        bone.setFlags(IntStream.range(0, 2).mapToObj(flags -> getUByte()).collect(Collectors.toList()));

        PMXFileFlags flagParser = new PMXFileFlags();
        EnumSet<PMXFileFlags.BoneFlagsFirst> firstFlags = flagParser.getBoneFlagsFirst(bone.getFlags().get(0));
        EnumSet<PMXFileFlags.BoneFlagsSecond> secondFlags = flagParser.getBoneFlagsSecond(bone.getFlags().get(1));

        if (!firstFlags.contains(PMXFileFlags.BoneFlagsFirst.INDEXEDTAILPOSITION)) {
            bone.setTailPosition(getVec3());
        } else {
            switch (globals.getBoneIndexSize()) {
                case 1 -> bone.setTailPosition(getByte());
                case 2 -> bone.setTailPosition(getInt16());
                case 4 -> bone.setTailPosition(getInt32());
            }
        }

        if (secondFlags.contains(PMXFileFlags.BoneFlagsSecond.INHERITROTATION) || secondFlags.contains(PMXFileFlags.BoneFlagsSecond.INHERITTRANSLATION)) {
            switch (globals.getBoneIndexSize()) {
                case 1 -> bone.setInheritParentIndex(getByte());
                case 2 -> bone.setInheritParentIndex(getInt16());
                case 4 -> bone.setInheritParentIndex(getInt32());
            }
            bone.setInheritParentInfluence(getFloat());
        }

        if (secondFlags.contains(PMXFileFlags.BoneFlagsSecond.FIXEDAXIS)) {
            bone.setAxisDirection(getVec3());
        }

        if (secondFlags.contains(PMXFileFlags.BoneFlagsSecond.LOCALCOORDINATE)) {
            bone.setxVector(getVec3());
            bone.setzVector(getVec3());
        }

        if (secondFlags.contains(PMXFileFlags.BoneFlagsSecond.EXTERNALPARENTDEFORM)) {
            switch (globals.getBoneIndexSize()) {
                case 1 -> bone.setExternalParentIndex(getByte());
                case 2 -> bone.setExternalParentIndex(getInt16());
                case 4 -> bone.setExternalParentIndex(getInt32());
            }
        }

        if (firstFlags.contains(PMXFileFlags.BoneFlagsFirst.IK)) {
            switch (globals.getBoneIndexSize()) {
                case 1 -> bone.setTargetIndex(getByte());
                case 2 -> bone.setTargetIndex(getInt16());
                case 4 -> bone.setTargetIndex(getInt32());
            }
            bone.setLoopCount(getInt32());
            bone.setLimitRadian(getFloat());
            bone.setLinkCount(getInt32());
            bone.setIkLinks(bone.getLinkCount() > 0 ? IntStream.range(0, bone.getLinkCount()).mapToObj(ik -> parseLink()).collect(Collectors.toList()) : Collections.emptyList());
        }

        return bone;
    }

    public PMXFileBoneLink parseLink() {
        PMXFileBoneLink link = new PMXFileBoneLink();
        switch (globals.getBoneIndexSize()) {
            case 1 -> link.setBoneIndex(getByte());
            case 2 -> link.setBoneIndex(getInt16());
            case 4 -> link.setBoneIndex(getInt32());
        }
        link.setHasLimits(getByte());
        if (link.getHasLimits() == 1) {
            link.setLimitMin(getVec3());
            link.setLimitMax(getVec3());
        }
        return link;
    }

    public enum MorphType {
        GROUP,
        VERTEX,
        BONE,
        UV,
        UVEXT1,
        UVEXT2,
        UVEXT3,
        UVEXT4,
        MATERIAL,
        FLIP,
        IMPULSE
    }
    public PMXFileMorph parseMorph() {
        PMXFileMorph morph = new PMXFileMorph();
        morph.setMorphNameJapanese(getVariableString());
        morph.setMorphNameEnglish(getVariableString());
        morph.setPanelType(getByte());
        morph.setMorphType(getByte());
        morph.setOffsetSize(getInt32());

        MorphType type = MorphType.values()[morph.getMorphType()];
        List<Object> data = Collections.emptyList();
        if (morph.getOffsetSize() > 0) {
            data = new ArrayList<>();
            for (int i = 0; i < morph.getOffsetSize(); i++) {
                switch (type) {
                    case GROUP -> {
                        PMXFileMorphGroup group = new PMXFileMorphGroup();
                        switch (globals.getMorphIndexSize()) {
                            case 1 -> group.setMorphIndex(getByte());
                            case 2 -> group.setMorphIndex(getInt16());
                            case 4 -> group.setMorphIndex(getInt32());
                        }
                        group.setInfluence(getFloat());
                        data.add(group);
                    }
                    case VERTEX -> {
                        PMXFileMorphVertex vertex = new PMXFileMorphVertex();
                        switch (globals.getVertexIndexSize()) {
                            case 1 -> vertex.setVertexIndex(getUByte());
                            case 2 -> vertex.setVertexIndex(getUInt16());
                            case 4 -> vertex.setVertexIndex(getInt32());
                        }
                        vertex.setTranslation(getVec3());
                        data.add(vertex);
                    }
                    case BONE -> {
                        PMXFileMorphBone bone = new PMXFileMorphBone();
                        switch (globals.getBoneIndexSize()) {
                            case 1 -> bone.setBoneIndex(getByte());
                            case 2 -> bone.setBoneIndex(getInt16());
                            case 4 -> bone.setBoneIndex(getInt32());
                        }
                        bone.setTranslation(getVec3());
                        bone.setRotation(getVec4());
                        data.add(bone);
                    }
                    case UV, UVEXT1, UVEXT2, UVEXT3, UVEXT4 -> {
                        PMXFileMorphUV uv = new PMXFileMorphUV();
                        switch (globals.getVertexIndexSize()) {
                            case 1 -> uv.setVertexIndex(getUByte());
                            case 2 -> uv.setVertexIndex(getUInt16());
                            case 4 -> uv.setVertexIndex(getInt32());
                        }
                        uv.setFloats(getVec4());
                        data.add(uv);
                    }
                    case MATERIAL -> {
                        PMXFileMorphMaterial material = new PMXFileMorphMaterial();
                        switch (globals.getMaterialIndexSize()) {
                            case 1 -> material.setMaterialIndex(getUByte());
                            case 2 -> material.setMaterialIndex(getUInt16());
                            case 4 -> material.setMaterialIndex(getInt32());
                        }
                        material.setOperationType(getByte());
                        material.setDiffuse(getVec4());
                        material.setSpecular(getVec3());
                        material.setSpecularity(getFloat());
                        material.setAmbient(getVec3());
                        material.setEdgeColor(getVec4());
                        material.setEdgeSize(getFloat());
                        material.setTextureTint(getVec4());
                        material.setEnvironmentTint(getVec4());
                        material.setToonTint(getVec4());
                        data.add(material);
                    }
                    case FLIP -> {
                        PMXFileMorphFlip flip = new PMXFileMorphFlip();
                        switch (globals.getMorphIndexSize()) {
                            case 1 -> flip.setMorphIndex(getByte());
                            case 2 -> flip.setMorphIndex(getInt16());
                            case 4 -> flip.setMorphIndex(getInt32());
                        }
                        flip.setInfluence(getFloat());
                        data.add(flip);
                    }
                    case IMPULSE -> {
                        PMXFileMorphImpulse impulse = new PMXFileMorphImpulse();
                        switch (globals.getRigidBodyIndexSize()) {
                            case 1 -> impulse.setRigidBodyIndex(getByte());
                            case 2 -> impulse.setRigidBodyIndex(getInt16());
                            case 4 -> impulse.setRigidBodyIndex(getInt32());
                        }
                        impulse.setLocalFlag(getByte());
                        impulse.setMovementSpeed(getVec3());
                        impulse.setRotationTorque(getVec3());
                        data.add(impulse);
                    }
                }
            }
        }
        morph.setOffsetData(data);

        return morph;
    }

    public PMXFileDisplayFrame parseDisplayFrame() {
        PMXFileDisplayFrame frame = new PMXFileDisplayFrame();
        frame.setDisplayFrameNameJapanese(getVariableString());
        frame.setDisplayFrameNameEnglish(getVariableString());
        frame.setSpecialFlag(getByte());
        frame.setFrameCount(getInt32());
        List<PMXFileDisplayFrameData> data = Collections.emptyList();
        if (frame.getFrameCount() > 0) {
            data = new ArrayList<>();
            for (int i = 0; i < frame.getFrameCount(); i++) {
                PMXFileDisplayFrameData frameData = new PMXFileDisplayFrameData();
                frameData.setFrameType(getByte());
                switch (frameData.getFrameType()) {
                    case 0 -> {
                        switch (globals.getBoneIndexSize()) {
                            case 1 -> frameData.setFrameData(getByte());
                            case 2 -> frameData.setFrameData(getInt16());
                            case 4 -> frameData.setFrameData(getInt32());
                        }
                        data.add(frameData);
                    }
                    case 1 -> {
                        switch (globals.getMorphIndexSize()) {
                            case 1 -> frameData.setFrameData(getByte());
                            case 2 -> frameData.setFrameData(getInt16());
                            case 4 -> frameData.setFrameData(getInt32());
                        }
                        data.add(frameData);
                    }
                }
            }
        }
        frame.setFrames(data);
        return frame;
    }

    public PMXFileRigidBody parseRigidBody() {
        PMXFileRigidBody body = new PMXFileRigidBody();
        body.setRigidBodyNameJapanese(getVariableString());
        body.setRigidBodyNameEnglish(getVariableString());
        switch (globals.getBoneIndexSize()) {
            case 1 -> body.setRelatedBoneIndex(getByte());
            case 2 -> body.setRelatedBoneIndex(getInt16());
            case 4 -> body.setRelatedBoneIndex(getInt32());
        }
        body.setGroupId(getByte());
        body.setNonCollisionGroup(getInt16());
        body.setShape(getByte());
        body.setShapeSize(getVec3());
        body.setShapePosition(getVec3());
        body.setShapeRotation(getVec3());
        body.setMass(getFloat());
        body.setMoveAttenuation(getFloat());
        body.setRotationDamping(getFloat());
        body.setRepulsion(getFloat());
        body.setFrictionForce(getFloat());
        body.setPhysicsMode(getByte());
        return body;
    }


    public PMXFileGlobals parseGlobals() {
        PMXFileGlobals globals = new PMXFileGlobals();
        globals.setTextEncoding(getByte());
        globals.setAdditionalVec4Count(getByte());
        globals.setVertexIndexSize(getByte());
        globals.setTextureIndexSize(getByte());
        globals.setMaterialIndexSize(getByte());
        globals.setBoneIndexSize(getByte());
        globals.setMorphIndexSize(getByte());
        globals.setRigidBodyIndexSize(getByte());
        this.globals = globals;
        return globals;
    }

    public String getVariableString() {
        int start = offset;
        int length = getInt32();
        start += 4;
        return getFixedString(start, length);
    }

    public String getFixedString(int start, int length) {
        int end = start + length;
        byte[] result = new byte[length];
        for (int i = start; i < end; i++) {
            int resultIndex = i - start;
            result[resultIndex] = bytes[i];
            //System.out.println(result[resultIndex]);
        }
        //System.out.println("End of Byte Range");
        offset += length;
        ByteBuffer buffer = ByteBuffer.wrap(result);
        return characterEncoding.decode(buffer).toString();
    }

    public String getFixedString(int length) {
        return getFixedString(offset, length);
    }
}
