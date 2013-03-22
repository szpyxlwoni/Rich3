package org.rich.map;

import org.rich.player.Player;

import java.util.HashMap;

public class Prison implements Land {

    public final HashMap<String, Integer> stopDayForEachPlayer;

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

    public void stopPlayer(Player player) {
        int playerStopDay = stopDayForEachPlayer.get(player.getName());
        if (playerStopDay <= 2 && playerStopDay > 0) {
            stopDayForEachPlayer.put(player.getName(), playerStopDay - 1);
        } else {
            stopDayForEachPlayer.put(player.getName(), 2);
        }
    }
}
