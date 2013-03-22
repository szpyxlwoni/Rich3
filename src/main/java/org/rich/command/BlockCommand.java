package org.rich.command;

import org.rich.map.Map;
import org.rich.player.Players;

import java.util.Scanner;

public class BlockCommand implements Command {

    @Override
    public void execute(Players players, Map map, Scanner input) {
        if (players.getCurrentPlayer().getBlocker() > 0) {
            int relativePosition = input.nextInt();
            map.useBlocker(getBlockerSetLocation(players, relativePosition));
            players.getCurrentPlayer().useBlocker();
        } else {
            input.nextInt();
            System.out.println("对不起，您没有路障");
        }
    }

    public int getBlockerSetLocation(Players players, int relativePosition) {
        if (relativePosition < 0) {
            relativePosition = 70 + relativePosition;
        }
        return players.getCurrentPlayer().getLocation() + relativePosition;
    }
}
