package org.rich.map;

import org.rich.player.Player;
import org.rich.player.Players;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {

    public static final int MAP_SIZE = 70;
    public static final int BOTTOM_MAP_SIZE = 29;
    public static final int VERTICAL_MAP_SIZE = 6;
    public static final int TOP_MAP_SIZE = 29;
    private final List<Land> map = new ArrayList<Land>();
    public static final int PRISON_LOCATION = 49;

    public Map() {
        map.add(new StartPoint());
        for (int i = 0; i < 13; i++) {
            map.add(new House(1));
        }
        map.add(new StartPoint());
        for (int i = 0; i < 13; i++) {
            map.add(new House(2));
        }
        map.add(new ItemHouse());
        for (int i = 0; i < 6; i++) {
            map.add(new House(3));
        }
        map.add(new GiftHouse());
        for (int i = 0; i < 13; i++) {
            map.add(new House(4));
        }
        map.add(new Prison());
        for (int i = 0; i < 13; i++) {
            map.add(new House(5));
        }
        map.add(new StartPoint());
        map.add(new Mine(20));
        map.add(new Mine(80));
        map.add(new Mine(100));
        map.add(new Mine(40));
        map.add(new Mine(80));
        map.add(new Mine(60));
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
            retVal += players.checkPlayerLocation(map.get(MAP_SIZE - i - 1).toString(), MAP_SIZE - i - 1) +
                    "                           " + players.checkPlayerLocation(map.get(TOP_MAP_SIZE + i).toString(), TOP_MAP_SIZE + i) + "\n";
        }
        for (int i = 0; i < BOTTOM_MAP_SIZE; i++) {
            retVal += players.checkPlayerLocation(map.get(MAP_SIZE - i - VERTICAL_MAP_SIZE - 1).toString(), MAP_SIZE - i - VERTICAL_MAP_SIZE - 1);
        }
        retVal += "\n";
        return retVal;
    }

    public boolean isNullItem(Player player) {
        return !isInPrison(player);
    }

    private boolean isInPrison(Player player) {
        return ((Prison) map.get(PRISON_LOCATION)).isStop(player);
    }

    public void executeFunc(Player player, Scanner scanner) {
         map.get(player.getLocation()).executeFunc(player, scanner);
    }
}
