package org.rich.map;

import org.rich.player.Player;

import java.util.Scanner;

public class MagicHouse implements Land {
    @Override
    public void executeFunc(Player player, Scanner scanner) {
        System.out.println("欢迎来到魔法屋，现在没有任何魔法可以使用");
    }
}
