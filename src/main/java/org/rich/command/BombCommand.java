package org.rich.command;

import org.rich.map.Map;
import org.rich.player.Players;

import java.util.Scanner;

public class BombCommand implements Command {
    @Override
    public void execute(Players players, Map map, Scanner input) {
        if (players.getCurrentPlayer().getBomb() > 0) {
            map.useBomb(getBombSetLocation(players, input.nextInt()));
            players.getCurrentPlayer().useBomb();
        } else {
            input.nextInt();
            System.out.println("对不起，您没有炸弹");
        }
    }

    public int getBombSetLocation(Players players, int relativePosition) {
        if (relativePosition < 0) {
            return players.getCurrentPlayer().getLocation() + relativePosition + relativePosition;
        }
        return players.getCurrentPlayer().getLocation() + relativePosition;
    }
}
