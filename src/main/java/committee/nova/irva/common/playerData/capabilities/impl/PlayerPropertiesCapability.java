package committee.nova.irva.common.playerData.capabilities.impl;

import committee.nova.irva.common.playerData.capabilities.api.IPlayerPropertiesCapability;
import committee.nova.irva.common.playerData.capabilities.properties.Belief;
import committee.nova.irva.common.playerData.capabilities.properties.api.IBelief;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

import static committee.nova.irva.common.util.StringReference.NBT_BELIEF_DEPTH;
import static committee.nova.irva.common.util.StringReference.NBT_KARMA;

public class PlayerPropertiesCapability implements IPlayerPropertiesCapability {
    public static final Capability<IPlayerPropertiesCapability> PLAYER_PROPERTIES_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
    });

    private byte karma;
    private IBelief belief;
    private byte beliefDepth;

    public PlayerPropertiesCapability() {
        karma = 0;
        belief = Belief.NONE;
        beliefDepth = 0;
    }

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
        tag.putByte(NBT_KARMA, karma);
        if (belief == null) belief = Belief.NONE;
        belief.serialize(tag);
        tag.putByte(NBT_BELIEF_DEPTH, beliefDepth);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        karma = tag.getByte(NBT_KARMA);
        belief = Belief.deserialize(tag);
        beliefDepth = tag.getByte(NBT_BELIEF_DEPTH);
    }

    @Override
    public String toString() {
        return "PlayerPropertiesCapability{" +
                "karma=" + karma +
                ", belief=" + belief +
                ", beliefDepth=" + beliefDepth +
                '}';
    }

    public void setKarma(byte karma) {
        this.karma = karma;
    }

    public void setBelief(IBelief belief) {
        this.belief = belief;
    }

    public void setBeliefDepth(byte beliefDepth) {
        this.beliefDepth = beliefDepth;
    }
}
