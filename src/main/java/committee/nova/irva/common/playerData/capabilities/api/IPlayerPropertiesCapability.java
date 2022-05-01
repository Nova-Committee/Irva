package committee.nova.irva.common.playerData.capabilities.api;

import committee.nova.irva.common.playerData.capabilities.properties.api.IBelief;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public interface IPlayerPropertiesCapability extends INBTSerializable<CompoundTag> {
    byte getKarma();

    IBelief getBelief();

    byte getBeliefDepth();

    void setKarma(byte karma);

    void setBelief(IBelief belief);

    void setBeliefDepth(byte depth);
}
