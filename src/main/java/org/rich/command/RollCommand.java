package org.rich.command;

import org.rich.map.Map;
import org.rich.player.Players;

import java.io.InputStream;
import java.util.Scanner;

public class RollCommand implements Command {
    @Override
    public void execute(Players players, Map map, Scanner input) {
        players.move(map, input);
        if (players.getCurrentPlayer().getMoney() >= 0) {
            players.changePlayer();
        }   else {
            System.out.println(players.getCurrentPlayer() + "宣告破产");
            players.removeCurrentPlayer();
        }
    }
}
