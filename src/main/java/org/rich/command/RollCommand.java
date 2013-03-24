package org.rich.command;

import org.rich.map.Map;
import org.rich.player.Players;

import java.util.Scanner;

public class RollCommand implements Command {
    @Override
    public void execute(Players players, Map map, Scanner input) {
        players.move(map, input);
        players.changePlayer();
    }
}
