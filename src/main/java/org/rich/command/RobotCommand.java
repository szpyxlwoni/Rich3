package org.rich.command;

import org.rich.map.Map;
import org.rich.player.Players;

import java.util.Scanner;

public class RobotCommand implements Command {
    @Override
    public void execute(Players players, Map map, Scanner input) {
        if (players.getCurrentPlayer().getRobot() > 0) {
            map.useRobot(players.getCurrentPlayer().getLocation());
            players.getCurrentPlayer().useRobot();
        } else {
            System.out.println("对不起，您没有机器娃娃");
        }
    }
}
