package org.rich.map;

import org.rich.item.Blocker;
import org.rich.item.Bomb;
import org.rich.item.RobotItem;
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
        int itemNo = 0;
        try {
            itemNo = scanner.nextInt();
        } catch (Exception e) {
        }
        System.out.println("欢迎光临道具屋， 请选择您所需要的道具：（1.路障；2.机器娃娃；3.炸弹）");
        if (itemNo == 1) {
            player.getItem().add(new Blocker());
            player.setPoint(player.getPoint() - BLOCKER_POINT);
        } else if (itemNo == 2) {
            player.getItem().add(new RobotItem());
            player.setPoint(player.getPoint() - ROBOT_POINT);
        } else if (itemNo == 3) {
            player.getItem().add(new Bomb());
            player.setPoint(player.getPoint() - BOMB_POINT);
        }
    }

    @Override
    public String toString() {
        return "T";
    }
}
