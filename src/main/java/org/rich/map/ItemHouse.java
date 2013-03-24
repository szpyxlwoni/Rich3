package org.rich.map;

import org.rich.player.Player;

import java.util.Scanner;

public class ItemHouse implements Land {

    public static final int BLOCKER_POINT = 50;
    public static final int ROBOT_POINT = 30;
    public static final int BOMB_POINT = 50;

    @Override
    public void executeFunc(Player player, Scanner scanner) {
    }

    @Override
    public String toString() {
        return "T";
    }
}
