package committee.nova.irva.common.command.impl;

import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import committee.nova.irva.common.playerData.capabilities.impl.PlayerPropertiesCapability;
import committee.nova.irva.common.playerData.capabilities.properties.Belief;
import committee.nova.irva.common.tools.PlayerHandler;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;

public class InfoCommand {
    public static ArgumentBuilder<CommandSourceStack, ?> checkSelfInfo() {
        return Commands.literal("self").executes(InfoCommand::checkSelfInfo);
    }

    public static ArgumentBuilder<CommandSourceStack, ?> test() {
        return Commands.literal("self").executes(InfoCommand::test);
    }

    public static int checkSelfInfo(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        final Player player = context.getSource().getPlayerOrException();
        player.getCapability(PlayerPropertiesCapability.PLAYER_PROPERTIES_CAPABILITY).ifPresent(e -> PlayerHandler.notifyServerPlayer(player, new TextComponent(e.toString())));
        return 0;
    }

    public static int test(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        final Player player = context.getSource().getPlayerOrException();
        player.getCapability(PlayerPropertiesCapability.PLAYER_PROPERTIES_CAPABILITY).ifPresent(e -> {
            e.setKarma((byte) 60);
            e.setBelief(Belief.JURE);
            e.setBeliefDepth((byte) 50);
        });
        return 0;
    }
}
