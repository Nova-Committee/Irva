package committee.nova.irva.common.command.init;

import com.mojang.brigadier.CommandDispatcher;
import committee.nova.irva.common.command.impl.InfoCommand;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CommandInit {
    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        final CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
        dispatcher.register(Commands.literal("irva").then(Commands.literal("info").requires(e -> e.hasPermission(0)).then(InfoCommand.checkSelfInfo())));
        dispatcher.register(Commands.literal("test").requires(e -> e.hasPermission(0)).then(InfoCommand.test()));
    }
}
