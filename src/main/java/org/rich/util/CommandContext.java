package org.rich.util;

import org.rich.map.Map;
import org.rich.player.Player;
import org.rich.player.Players;

public class CommandContext {
    public static final int SUCCESS = 1;
    public static final int NO_ITEM = 2;
    private Player player;
    private Players players;
    private Map map;
    private int location;
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
