package committee.nova.irva.common.playerData.capabilities.init;

import committee.nova.irva.common.playerData.capabilities.api.IPlayerPropertiesCapability;
import committee.nova.irva.common.playerData.capabilities.impl.PlayerPropertiesCapability;
import committee.nova.irva.common.playerData.capabilities.provider.PlayerPropertiesProvider;
import committee.nova.irva.common.util.TextUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CapabilitiesInit {
    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerPropertiesCapability.class);
    }

    @SubscribeEvent
    public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (!(event.getObject() instanceof Player)) return;
        event.addCapability(TextUtils.prefixRl("player_properties"), new PlayerPropertiesProvider());
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        final Player original = event.getOriginal();
        original.reviveCaps();
        final LazyOptional<IPlayerPropertiesCapability> oldCap = original.getCapability(PlayerPropertiesCapability.PLAYER_PROPERTIES_CAPABILITY);
        final LazyOptional<IPlayerPropertiesCapability> newCap = event.getPlayer().getCapability(PlayerPropertiesCapability.PLAYER_PROPERTIES_CAPABILITY);
        newCap.ifPresent((n) -> oldCap.ifPresent((o) -> n.deserializeNBT(o.serializeNBT())));
        original.invalidateCaps();
    }
}
