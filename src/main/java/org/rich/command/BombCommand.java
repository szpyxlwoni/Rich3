package org.rich.command;

import org.rich.map.Map;
import org.rich.player.Player;
import org.rich.util.CommandContext;

import static org.rich.util.CommandContext.*;

public class BombCommand implements Command {

    @Override
    public CommandContext execute(CommandContext commandContext) {
        commandContext.setState(hasBomb(commandContext.getPlayer()));
        if (commandContext.getState() == SUCCESS) {
            setBombToMap(commandContext.getMap(), commandContext.getPlayer(), commandContext.getLocation());
        }
        return commandContext;
    }

    private void setBombToMap(Map map, Player player, int location) {
    }

    private int hasBomb(Player player) {
        return player.hasBomb() ? SUCCESS : NO_ITEM;
    }
}
