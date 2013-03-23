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
    public static final int CLEAR_REGIONS = 10;
    private final List<Land> map = new ArrayList<Land>();
    public static final int PRISON_LOCATION = 49;
    private List<Integer> blockers = new ArrayList<Integer>();
    private List<Integer> bombs = new ArrayList<Integer>();

    public Map() {
        map.add(new StartPoint());
        for (int i = 0; i < 13; i++) {
            map.add(new House(1));
        }
        map.add(new Hospital());
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
        map.add(new MagicHouse());
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
            retVal += getMapString(players, i);
        }
        retVal += "\n";
        for (int i = 0; i < VERTICAL_MAP_SIZE; i++) {
            retVal += getMapString(players, MAP_SIZE - i - 1) +
                    "                           " + getMapString(players, TOP_MAP_SIZE + i) + "\n";
        }
        for (int i = 0; i < BOTTOM_MAP_SIZE; i++) {
            retVal += getMapString(players, MAP_SIZE - i - VERTICAL_MAP_SIZE - 1);
        }
        retVal += "\n";
        return retVal;
    }

    private String getMapString(Players players, int i) {
        return players.checkPlayerLocation(checkItem(map.get(i).toString(), players.getCurrentPlayer()), i);
    }

    private String checkItem(String map, Player player) {
        String retVal = map;
        if (hasBlocker(player)) {
            retVal = "@";
        }
        if(hasBomb(player)) {
            retVal = "#";
        }
        return retVal;
    }

    public boolean isNullItem(Player player) {
        return !isInPrison(player) && !hasBomb(player) && !hasBlocker(player);
    }

    private boolean hasBlocker(Player player) {
        for (int i = 0; i < bombs.size(); i++) {
            int oneLocation = bombs.get(i);
            if (oneLocation == player.getLocation()) {
                return true;
            }
        }
        return false;
    }

    private boolean hasBomb(Player player) {
        for (int i = 0; i < blockers.size(); i++) {
            int oneLocation = blockers.get(i);
            if (oneLocation == player.getLocation()) {
                  return true;
            }
        }
        return false;
    }

    private boolean isInPrison(Player player) {
        return ((Prison) map.get(PRISON_LOCATION)).isStop(player);
    }

    public void executeFunc(Player player, Scanner scanner) {
         map.get(player.getLocation()).executeFunc(player, scanner);
    }

    public void useBlocker(int location) {
        blockers.add(location);
    }

    public void useBomb(int location) {
        bombs.add(location);
    }

    public void useRobot(int location) {
        clearBlocker(location);
        clearBombs(location);
    }

    private void clearBlocker(int location) {
        for (int i = 0; i < blockers.size(); i++) {
            int oneLocation = blockers.get(i);
            if (isInRobotSight(location, oneLocation)) {
                blockers.remove(i);
            }
        }
    }

    private void clearBombs(int location) {
        for (int i = 0; i < bombs.size(); i++) {
            int oneLocation = bombs.get(i);
            if (isInRobotSight(location, oneLocation)) {
                bombs.remove(i);
            }
        }
    }

    public boolean isInRobotSight(int location, int oneLocation) {
        if (location < MAP_SIZE - CLEAR_REGIONS || oneLocation >= CLEAR_REGIONS) {
            return oneLocation >= location && oneLocation <= location + CLEAR_REGIONS;
        }
        return oneLocation + MAP_SIZE <= location + CLEAR_REGIONS;
    }

    public void executeItem(Player player) {
        if (hasBomb(player)) {
            player.setLocation(49);
            ((Prison) map.get(PRISON_LOCATION)).executeFunc(player, new Scanner(System.in));
        }
    }
}
