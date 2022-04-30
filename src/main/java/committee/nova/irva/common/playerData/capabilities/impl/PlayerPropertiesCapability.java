package committee.nova.irva.common.playerData.capabilities.impl;

import committee.nova.irva.common.playerData.capabilities.api.IPlayerPropertiesCapability;
import committee.nova.irva.common.playerData.capabilities.properties.Belief;
import committee.nova.irva.common.playerData.capabilities.properties.api.IBelief;
import net.minecraft.nbt.CompoundTag;

public class PlayerPropertiesCapability implements IPlayerPropertiesCapability {
    private byte karma;
    private IBelief belief;
    private byte beliefDepth;

    @Override
    public byte getKarma() {
        return karma;
    }

    @Override
    public IBelief getBelief() {
        return belief;
    }

    @Override
    public byte getBeliefDepth() {
        return beliefDepth;
    }

    @Override
    public CompoundTag serializeNBT() {
        final CompoundTag tag = new CompoundTag();
        tag.putByte("irva_karma", karma);
        belief.serialize(tag);
        tag.putByte("irva_belief_depth", beliefDepth);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        karma = tag.getByte("irva_karma");
        belief = Belief.deserialize(tag);
        beliefDepth = tag.getByte("irva_belief_depth");
    }
}
