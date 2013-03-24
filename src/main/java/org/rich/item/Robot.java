package org.rich.item;

import org.rich.map.Map;
import org.rich.player.Player;

public class Robot {
    private Blockers blockers;
    private Bombs bombs;
    private final Player player;

    public Robot(Player player) {
        this.player = player;
        blockers = player.getBlockers();
        bombs = player.getBombs();
    }
}