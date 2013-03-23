package org.rich.map;

import org.rich.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Prison implements Land {

    private final Map<String, Integer> stopDayForEachPlayer;

    public Prison() {
        stopDayForEachPlayer = new HashMap<String, Integer>();
        stopDayForEachPlayer.put("钱夫人", 0);
        stopDayForEachPlayer.put("阿土伯", 0);
        stopDayForEachPlayer.put("孙小美", 0);
        stopDayForEachPlayer.put("金贝贝", 0);
    }

    @Override
    public String toString() {
        return "P";
    }

    public boolean isStop(Player player) {
        return stopDayForEachPlayer.get(player.getName()) != 0;
    }

    @Override
    public void executeFunc(Player player, Scanner scanner) {
        int playerStopDay = stopDayForEachPlayer.get(player.getName());
        if (playerStopDay <= 2 && playerStopDay > 0) {
            stopDayForEachPlayer.put(player.getName(), playerStopDay - 1);
        } else {
            stopDayForEachPlayer.put(player.getName(), 2);
        }
    }
}
