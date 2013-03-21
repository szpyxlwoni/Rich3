package org.rich.map;

import org.rich.player.Players;

import java.util.ArrayList;
import java.util.List;

public class Map {

    public static final int MAP_SIZE = 70;
    public static final int BOTTOM_MAP_SIZE = 29;
    public static final int VERTICAL_MAP_SIZE = 6;
    public static final int TOP_MAP_SIZE = 29;
    private final List<EmptyHouse> map = new ArrayList<EmptyHouse>();

    public Map(int emptySize) {
        for (int i = 0; i < emptySize; i++) {
            map.add(new EmptyHouse());
        }
    }

    public int getSize() {
        return map.size();
    }

    public void output(Players players) {
        System.out.println(this.toOutputType(players));
    }

    public String toOutputType(Players players) {
        String retVal = "";
        for (int i = 0; i < TOP_MAP_SIZE; i++) {
            retVal += players.checkPlayerLocation(map.get(i).toString(), i);
        }
        retVal += "\n";
        for (int i = 0; i < VERTICAL_MAP_SIZE; i++) {
            retVal += map.get(MAP_SIZE - i - 1) + "                           " + map.get(29 + i) + "\n";
        }
        for (int i = 0; i < BOTTOM_MAP_SIZE; i++) {
            retVal += map.get(MAP_SIZE - i - VERTICAL_MAP_SIZE - 1).toString();
        }
        retVal += "\n";
        return retVal;

    }
}
