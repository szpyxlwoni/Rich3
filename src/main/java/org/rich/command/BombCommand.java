package org.rich.command;

import org.rich.map.Map;
import org.rich.player.Players;

import java.util.Scanner;

public class BombCommand implements Command {
    @Override
    public void execute(Players players, Map map, Scanner input) {
        if (players.getCurrentPlayer().getBomb() > 0) {
            map.useBomb(players.getSetLocation(input.nextInt()));
            players.getCurrentPlayer().useBomb();
        } else {
            input.nextInt();
            System.out.println("对不起，您没有炸弹");
        }
    }
}
