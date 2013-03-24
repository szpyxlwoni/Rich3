package org.rich.map;

import org.rich.player.Player;

import java.util.Scanner;

public class ItemHouse implements Land {

    public static final int BLOCKER_POINT = 50;
    public static final int ROBOT_POINT = 30;
    public static final int BOMB_POINT = 50;

    @Override
    public void executeFunc(Player player, Scanner scanner) {
        if (player.getPoint() < ROBOT_POINT) {
            return;
        }
        int itemNo = scanner.nextInt();
        if (itemNo == 1) {
            if (player.getPoint() - BLOCKER_POINT < 0 || player.getBomb() == 10) {
                return;
            }
            player.addBlocker();
        } else if (itemNo == 2) {
            if (player.getRobot() == 10) {
                return;
            }
            player.addRobot();
        } else if (itemNo == 3) {
            if (player.getPoint() - BOMB_POINT < 0 || player.getBomb() == 10) {
                return;
            }
            player.addBomb();
        }
    }

    @Override
    public String toString() {
        return "T";
    }
}
