package committee.nova.irva.common.playerData.capabilities.provider;

import committee.nova.irva.common.playerData.capabilities.api.IPlayerPropertiesCapability;
import committee.nova.irva.common.playerData.capabilities.impl.PlayerPropertiesCapability;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class PlayerPropertiesProvider implements ICapabilitySerializable<CompoundTag> {
    private IPlayerPropertiesCapability playerPropertiesCapability;

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == PlayerPropertiesCapability.PLAYER_PROPERTIES_CAPABILITY ? LazyOptional.of(this::getOrCreateCapability).cast() : LazyOptional.empty();
    }

    @Nonnull
    public IPlayerPropertiesCapability getOrCreateCapability() {
        if (playerPropertiesCapability == null) {
            this.playerPropertiesCapability = new PlayerPropertiesCapability();
        }
        return this.playerPropertiesCapability;
    }

    @Override
    public CompoundTag serializeNBT() {
        return getOrCreateCapability().serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        getOrCreateCapability().deserializeNBT(tag);
    }
}
