package committee.nova.irva.common.playerData.capabilities.properties.api;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;

public interface IBelief {
    int getId();

    Component getName();

    Component getAttribute();

    void serialize(CompoundTag tag);
}