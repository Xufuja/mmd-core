package dev.xfj.format.pmx;

import java.util.EnumSet;
import java.util.Set;

public class PMXFileFlags {
    //https://stackoverflow.com/questions/5346477/implementing-a-bitfield-using-java-enums
    public enum BoneFlagsFirst {
        INDEXEDTAILPOSITION(1 << 0),
        ROTABLE(1 << 1),
        TRANSLATABLE(1 << 2),
        ISVISIBLE(1 << 3),
        ENABLED(1 << 4),
        IK(1 << 5),
        PADDING1(1 << 6),
        PADDING2(1 << 7);

        private final long boneFlagValue;

        BoneFlagsFirst(long boneFlagValue) {
            this.boneFlagValue = boneFlagValue;
        }

        public long getBoneFlagValue() {
            return boneFlagValue;
        }
    }
    public EnumSet<BoneFlagsFirst> getBoneFlagsFirst(long statusValue) {
        EnumSet<BoneFlagsFirst> statusFlags = EnumSet.noneOf(BoneFlagsFirst.class);
        for (BoneFlagsFirst statusFlag : BoneFlagsFirst.values()) {
            long flagValue = statusFlag.getBoneFlagValue();
            if ((flagValue & statusValue) == flagValue) {
                statusFlags.add(statusFlag);
            }
        }
        return statusFlags;
    }
    public long getFlagValueFirst(Set<BoneFlagsFirst> flags) {
        long value=0;
        for (BoneFlagsFirst statusFlag : flags) {
            value |= statusFlag.getBoneFlagValue();
        }
        return value;
    }

    public enum BoneFlagsSecond {
        INHERITROTATION(1 << 0),
        INHERITTRANSLATION(1 << 1),
        FIXEDAXIS(1 << 2),
        LOCALCOORDINATE(1 << 3),
        PHYSICSAFTERDEFORM(1 << 4),
        EXTERNALPARENTDEFORM(1 << 5),
        PADDING1(1 << 6),
        PADDING2(1 << 7);

        private final long boneFlagValue;

        BoneFlagsSecond(long boneFlagValue) {
            this.boneFlagValue = boneFlagValue;
        }

        public long getBoneFlagValue() {
            return boneFlagValue;
        }
    }
    public EnumSet<BoneFlagsSecond> getBoneFlagsSecond(long statusValue) {
        EnumSet<BoneFlagsSecond> statusFlags = EnumSet.noneOf(BoneFlagsSecond.class);
        for (BoneFlagsSecond statusFlag : BoneFlagsSecond.values()) {
            long flagValue = statusFlag.getBoneFlagValue();
            if ((flagValue & statusValue) == flagValue) {
                statusFlags.add(statusFlag);
            }
        }
        return statusFlags;
    }
    public long getFlagValueSecond(Set<BoneFlagsSecond> flags) {
        long value=0;
        for (BoneFlagsSecond statusFlag : flags) {
            value |= statusFlag.getBoneFlagValue();
        }
        return value;
    }
}
