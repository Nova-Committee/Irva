package committee.nova.irva.common.tools;

import committee.nova.irva.common.playerData.capabilities.impl.PlayerPropertiesCapability;
import committee.nova.irva.common.playerData.capabilities.provider.PlayerPropertiesProvider;
import committee.nova.irva.common.util.TextUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventListener {
    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerPropertiesCapability.class);
    }

    @SubscribeEvent
    public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (!(event.getObject() instanceof Player)) return;
        event.addCapability(TextUtils.prefixRl("player_properties"), new PlayerPropertiesProvider());
    }
}
