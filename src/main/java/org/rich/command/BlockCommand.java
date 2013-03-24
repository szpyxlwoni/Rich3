package org.rich.command;

import org.rich.map.Map;
import org.rich.player.Players;

import java.util.Scanner;

public class BlockCommand implements Command {

    @Override
    public void execute(Players players, Map map) {
        players.getCurrentPlayer().useBlocker();
    }
}
