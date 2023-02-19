package dev.xfj.parsing;

import dev.xfj.format.pmx.*;
import dev.xfj.types.index.*;

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

public class PMXParser extends Parser {
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
        pmxFile.setJointCount(getInt32());
        pmxFile.setJoints(pmxFile.getJointCount() > 0 ? IntStream.range(0, pmxFile.getJointCount()).mapToObj(body -> parseJoint()).collect(Collectors.toList()) : Collections.emptyList());
        if (pmxFile.getVersion() == 2.1f) {
            pmxFile.setSoftBodyCount(getInt32());
            pmxFile.setSoftBodies(pmxFile.getSoftBodyCount() > 0 ? IntStream.range(0, pmxFile.getSoftBodyCount()).mapToObj(body -> parseSoftBody()).collect(Collectors.toList()) : Collections.emptyList());
        }
        return pmxFile;
    }

    private enum WeightDeformTypes {
        BDEF1,
        BDEF2,
        BDEF4,
        SDEF,
        QDEF
    }

    private PMXFileVertex parseVertex() {
        PMXFileVertex vertex = new PMXFileVertex();
        vertex.setPosition(getVec3());
        vertex.setNormal(getVec3());
        vertex.setUv(getVec2());
        vertex.setAdditionalVec4(globals.getAdditionalVec4Count() > 0 ? IntStream.range(0, globals.getAdditionalVec4Count()).mapToObj(vec4 -> getVec4()).collect(Collectors.toList()) : Collections.emptyList());
        vertex.setWeightDeformType(getByte());
        WeightDeformTypes type = WeightDeformTypes.values()[vertex.getWeightDeformType()];
        List<IndexType<?>> boneIndices = new ArrayList<>();
        List<Float> boneWeight = new ArrayList<>();
        switch (type) {
            case BDEF1 -> {
                boneIndices.add(parseIndex(IndexTypes.BONE));
                boneWeight.add(1.0f);
            }
            case BDEF2, SDEF -> {
                boneIndices.add(parseIndex(IndexTypes.BONE));
                boneIndices.add(parseIndex(IndexTypes.BONE));
                float bone1 = getFloat();
                boneWeight.add(bone1);
                boneWeight.add(1.0f - bone1);
            }
            case BDEF4, QDEF -> {
                boneIndices.add(parseIndex(IndexTypes.BONE));
                boneIndices.add(parseIndex(IndexTypes.BONE));
                boneIndices.add(parseIndex(IndexTypes.BONE));
                boneIndices.add(parseIndex(IndexTypes.BONE));
                boneWeight.add(getFloat());
                boneWeight.add(getFloat());
                boneWeight.add(getFloat());
                boneWeight.add(getFloat());
            }
        }
        vertex.setBoneIndices(boneIndices);
        vertex.setBoneWeights(boneWeight);
        if (type == WeightDeformTypes.SDEF) {
            vertex.setC(getVec3());
            vertex.setR0(getVec3());
            vertex.setR1(getVec3());
        }
        vertex.setEdgeScale(getFloat());

        return vertex;
    }

    private PMXFileVertexIndex parseVertexIndex() {
        PMXFileVertexIndex vertexIndex = new PMXFileVertexIndex();
        vertexIndex.setVertexIndexA(parseIndex(IndexTypes.VERTEX));
        vertexIndex.setVertexIndexB(parseIndex(IndexTypes.VERTEX));
        vertexIndex.setVertexIndexC(parseIndex(IndexTypes.VERTEX));
        return vertexIndex;
    }

    private PMXFileMaterial parseMaterial() {
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
        material.setTextureIndex(parseIndex(IndexTypes.TEXTURE));
        material.setEnvironmentIndex(parseIndex(IndexTypes.TEXTURE));
        material.setEnvironmentBlendMode(getByte());
        material.setToonReference(getByte());
        if (material.getToonReference() == 1) {
            material.setToonValue(getByte());
        } else {
            material.setToonValue(parseIndex(IndexTypes.TEXTURE));
        }
        material.setMetaData(getVariableString());
        material.setSurfaceCount(getInt32());

        return material;
    }

    private PMXFileBone parseBone() {
        PMXFileBone bone = new PMXFileBone();
        bone.setBoneNameJapanese(getVariableString());
        bone.setBonenameEnglish(getVariableString());
        bone.setPosition(getVec3());
        bone.setParentBoneIndex(parseIndex(IndexTypes.BONE));
        bone.setLayer(getInt32());
        bone.setFlags(IntStream.range(0, 2).mapToObj(flags -> getUByte()).collect(Collectors.toList()));

        PMXFileFlags flagParser = new PMXFileFlags();
        EnumSet<PMXFileFlags.BoneFlagsFirst> firstFlags = flagParser.getBoneFlagsFirst(bone.getFlags().get(0));
        EnumSet<PMXFileFlags.BoneFlagsSecond> secondFlags = flagParser.getBoneFlagsSecond(bone.getFlags().get(1));

        if (!firstFlags.contains(PMXFileFlags.BoneFlagsFirst.INDEXEDTAILPOSITION)) {
            bone.setTailPosition(getVec3());
        } else {
            bone.setTailPosition(parseIndex(IndexTypes.BONE));
        }

        if (secondFlags.contains(PMXFileFlags.BoneFlagsSecond.INHERITROTATION) || secondFlags.contains(PMXFileFlags.BoneFlagsSecond.INHERITTRANSLATION)) {
            bone.setInheritParentIndex(parseIndex(IndexTypes.BONE));
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
            bone.setExternalParentIndex(parseIndex(IndexTypes.BONE));
        }

        if (firstFlags.contains(PMXFileFlags.BoneFlagsFirst.IK)) {
            bone.setTargetIndex(parseIndex(IndexTypes.BONE));
            bone.setLoopCount(getInt32());
            bone.setLimitRadian(getFloat());
            bone.setLinkCount(getInt32());
            bone.setIkLinks(bone.getLinkCount() > 0 ? IntStream.range(0, bone.getLinkCount()).mapToObj(ik -> parseLink()).collect(Collectors.toList()) : Collections.emptyList());
        }

        return bone;
    }

    private PMXFileBoneLink parseLink() {
        PMXFileBoneLink link = new PMXFileBoneLink();
        link.setBoneIndex(parseIndex(IndexTypes.BONE));
        link.setHasLimits(getByte());
        if (link.getHasLimits() == 1) {
            link.setLimitMin(getVec3());
            link.setLimitMax(getVec3());
        }
        return link;
    }

    private enum MorphTypes {
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

    private PMXFileMorph parseMorph() {
        PMXFileMorph morph = new PMXFileMorph();
        morph.setMorphNameJapanese(getVariableString());
        morph.setMorphNameEnglish(getVariableString());
        morph.setPanelType(getByte());
        morph.setMorphType(getByte());
        morph.setOffsetSize(getInt32());

        MorphTypes type = MorphTypes.values()[morph.getMorphType()];
        List<PMXFileMorphType> data = Collections.emptyList();
        if (morph.getOffsetSize() > 0) {
            data = new ArrayList<>();
            for (int i = 0; i < morph.getOffsetSize(); i++) {
                switch (type) {
                    case GROUP -> {
                        PMXFileMorphGroup group = new PMXFileMorphGroup();
                        group.setMorphIndex(parseIndex(IndexTypes.MORPH));
                        group.setInfluence(getFloat());
                        data.add(group);
                    }
                    case VERTEX -> {
                        PMXFileMorphVertex vertex = new PMXFileMorphVertex();
                        vertex.setVertexIndex(parseIndex(IndexTypes.VERTEX));
                        vertex.setTranslation(getVec3());
                        data.add(vertex);
                    }
                    case BONE -> {
                        PMXFileMorphBone bone = new PMXFileMorphBone();
                        bone.setBoneIndex(parseIndex(IndexTypes.BONE));
                        bone.setTranslation(getVec3());
                        bone.setRotation(getVec4());
                        data.add(bone);
                    }
                    case UV, UVEXT1, UVEXT2, UVEXT3, UVEXT4 -> {
                        PMXFileMorphUV uv = new PMXFileMorphUV();
                        uv.setVertexIndex(parseIndex(IndexTypes.VERTEX));
                        uv.setFloats(getVec4());
                        data.add(uv);
                    }
                    case MATERIAL -> {
                        PMXFileMorphMaterial material = new PMXFileMorphMaterial();
                        material.setMaterialIndex(parseIndex(IndexTypes.MATERIAL));
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
                        flip.setMorphIndex(parseIndex(IndexTypes.MORPH));
                        flip.setInfluence(getFloat());
                        data.add(flip);
                    }
                    case IMPULSE -> {
                        PMXFileMorphImpulse impulse = new PMXFileMorphImpulse();
                        impulse.setRigidBodyIndex(parseIndex(IndexTypes.RIGIDBODY));
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

    private PMXFileDisplayFrame parseDisplayFrame() {
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
                        frameData.setFrameData(parseIndex(IndexTypes.BONE));
                        data.add(frameData);
                    }
                    case 1 -> {
                        frameData.setFrameData(parseIndex(IndexTypes.MORPH));
                        data.add(frameData);
                    }
                }
            }
        }
        frame.setFrames(data);
        return frame;
    }

    private PMXFileRigidBody parseRigidBody() {
        PMXFileRigidBody body = new PMXFileRigidBody();
        body.setRigidBodyNameJapanese(getVariableString());
        body.setRigidBodyNameEnglish(getVariableString());
        body.setRelatedBoneIndex(parseIndex(IndexTypes.BONE));
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

    private PMXFileJoint parseJoint() {
        PMXFileJoint joint = new PMXFileJoint();
        joint.setJointNameJapanese(getVariableString());
        joint.setJointNameEnglish(getVariableString());
        joint.setType(getByte());
        joint.setRigidBodyIndexA(parseIndex(IndexTypes.RIGIDBODY));
        joint.setRigidBodyIndexB(parseIndex(IndexTypes.RIGIDBODY));
        joint.setPosition(getVec3());
        joint.setRotation(getVec3());
        joint.setPositionMinimum(getVec3());
        joint.setPositionMaximum(getVec3());
        joint.setRotationMinimum(getVec3());
        joint.setRotationMaximum(getVec3());
        joint.setPositionSpring(getVec3());
        joint.setRotationSpring(getVec3());

        return joint;
    }

    private PMXFileSoftBody parseSoftBody() {
        PMXFileSoftBody body = new PMXFileSoftBody();
        body.setSoftBodyNameJapanese(getVariableString());
        body.setSoftBodyNameEnglish(getVariableString());
        body.setShape(getByte());
        body.setMaterialIndex(parseIndex(IndexTypes.MATERIAL));
        body.setGroupId(getByte());
        body.setNonCollisionGroup(getInt16());
        body.setFlags(getByte());
        body.setbLinkCreateDistance(getInt32());
        body.setClusterCount(getInt32());
        body.setTotalMass(getFloat());
        body.setCollisionMargin(getFloat());
        body.setAerodynamicsModel(getInt32());
        body.setVelocityCorrectionFactor(getFloat());
        body.setDampingCoefficient(getFloat());
        body.setDragCoefficient(getFloat());
        body.setLiftCoefficient(getFloat());
        body.setPressureCoefficient(getFloat());
        body.setVolumeConversationCoefficient(getFloat());
        body.setDynamicFrictionCoefficient(getFloat());
        body.setPoseMatchingCoefficient(getFloat());
        body.setRigidContactHardness(getFloat());
        body.setKineticContactHardness(getFloat());
        body.setSoftContactHardness(getFloat());
        body.setAnchorHardness(getFloat());
        body.setSoftRigidHardness(getFloat());
        body.setSoftKineticHardness(getFloat());
        body.setSoftSoftHardness(getFloat());
        body.setSoftRigidImpulseSplit(getFloat());
        body.setSoftKineticImpulseSplit(getFloat());
        body.setSoftSoftImpulseSplit(getFloat());
        body.setVelocitySolverIterations(getInt32());
        body.setPositionSolverIterations(getInt32());
        body.setDriftSolverIterations(getInt32());
        body.setClusterSolverIterations(getInt32());
        body.setLinearStiffnessCoefficient(getInt32());
        body.setAngularStiffnessCoefficient(getInt32());
        body.setVolumeStiffnessCoefficient(getInt32());
        body.setAnchorRigidBodyCount(getInt32());
        body.setAnchorRigidBodies(body.getAnchorRigidBodyCount() > 0 ? IntStream.range(0, body.getAnchorRigidBodyCount()).mapToObj(anchor -> parseSoftBodyAnchorRigidBody()).collect(Collectors.toList()) : Collections.emptyList());
        body.setVertexPinCount(getInt32());
        body.setVertexPins(body.getVertexPinCount() > 0 ? IntStream.range(0, body.getVertexPinCount()).mapToObj(anchor -> parseIndex(IndexTypes.VERTEX)).collect(Collectors.toList()) : Collections.emptyList());

        return body;
    }

    private PMXFileSoftBodyAnchorRigidBody parseSoftBodyAnchorRigidBody() {
        PMXFileSoftBodyAnchorRigidBody anchor = new PMXFileSoftBodyAnchorRigidBody();
        anchor.setRigidBodyIndex(parseIndex(IndexTypes.RIGIDBODY));
        anchor.setVertexIndex(parseIndex(IndexTypes.VERTEX));
        anchor.setNearMode(getByte());
        return anchor;
    }


    private PMXFileGlobals parseGlobals() {
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

    private enum IndexTypes {
        VERTEX,
        BONE,
        TEXTURE,
        MATERIAL,
        MORPH,
        RIGIDBODY
    }

    private IndexType<?> parseIndex(IndexTypes index) {
        IndexType<?> result = null;
        int type = -1;

        switch (index) {
            case VERTEX -> type = globals.getVertexIndexSize();
            case BONE -> type = globals.getBoneIndexSize();
            case TEXTURE -> type = globals.getTextureIndexSize();
            case MATERIAL -> type = globals.getMaterialIndexSize();
            case MORPH -> type = globals.getMorphIndexSize();
            case RIGIDBODY -> type = globals.getRigidBodyIndexSize();
        }

        switch (type) {
            case 1 -> {
                if (index == IndexTypes.VERTEX) {
                    result = new IndexUByte(getUByte());
                } else {
                    result = new IndexByte(getByte());
                }
            }
            case 2 -> {
                if (index == IndexTypes.VERTEX) {
                    result = new IndexUInt16(getUInt16());
                } else {
                    result = new IndexInt16(getInt16());
                }
            }
            case 4 -> result = new IndexInt32(getInt32());
        }

        return result;
    }

    private String getVariableString() {
        int start = offset;
        int length = getInt32();
        start += 4;
        return getFixedString(start, length);
    }

    private String getFixedString(int start, int length) {
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

    private String getFixedString(int length) {
        return getFixedString(offset, length);
    }
}
