package org.rich.map;

import org.rich.player.Player;

import java.util.HashMap;
import java.util.Scanner;

public class Hospital implements Land {
    private final HashMap<String, Integer> stopDayForEachPlayer;

    public Hospital() {
        stopDayForEachPlayer = new HashMap<String, Integer>();
        stopDayForEachPlayer.put("钱夫人", 0);
        stopDayForEachPlayer.put("阿土伯", 0);
        stopDayForEachPlayer.put("孙小美", 0);
        stopDayForEachPlayer.put("金贝贝", 0);
    }

    public boolean isStop(Player player) {
        return stopDayForEachPlayer.get(player.getName()) != 0;
    }

    @Override
    public void executeFunc(Player player, Scanner scanner) {
        int playerStopDay = stopDayForEachPlayer.get(player.getName());
        if (playerStopDay <= 3 && playerStopDay > 0) {
            stopDayForEachPlayer.put(player.getName(), playerStopDay - 1);
        }
    }

    @Override
    public String toString() {
        return "H";
    }
}