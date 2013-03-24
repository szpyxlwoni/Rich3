package org.rich.map;

import org.rich.player.Player;

import java.util.Scanner;

public class GiftHouse implements Land {

    public static final int ADD_MONEY_NUMBER = 2000;
    public static final int ADD_POINT_NUMBER = 200;

    @Override
    public void executeFunc(Player player, Scanner scanner) {
        int itemNo = scanner.nextInt();
        if (itemNo == 1) {
            player.setMoney(player.getMoney() + ADD_MONEY_NUMBER);
        } else if (itemNo == 2) {
            player.setPoint(player.getPoint() + ADD_POINT_NUMBER);
        } else if (itemNo == 3) {
            player.toBless();
        }
    }

    @Override
    public String toString() {
        return "G";
    }
}
