package org.rich.command;

import org.rich.map.Map;
import org.rich.player.Players;

import java.util.Scanner;

public class RobotCommand implements Command {
    @Override
    public void execute(Players players, Map map) {
        if (players.getCurrentPlayer().getRobot() > 0) {
            map.useRobot(players.getCurrentPlayer().getLocation());
            players.getCurrentPlayer().useRobot();
        }
    }
}
