package org.rich.map;

import org.rich.item.Blockers;
import org.rich.item.Bombs;
import org.rich.item.Robot;
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
    public static final int PRISON_LOCATION = 49;

    private final List<Land> map = new ArrayList<Land>();

    public Map() {
        initTopLineMap();
        initAreaThreeHouse();
        initGiftHouse();
        initAreaFourHouse();
        initPrison();
        initAreaFiveHouse();
        initMagicHouse();
        initMine();
    }

    private void initTopLineMap() {
        initStartPoint();
        initAreaOneHouse();
        initHospital();
        initAreaTwoHouse();
        initItemHouse();
    }

    private void initMine() {
        map.add(new Mine(20));
        map.add(new Mine(80));
        map.add(new Mine(100));
        map.add(new Mine(40));
        map.add(new Mine(80));
        map.add(new Mine(60));
    }

    private void initMagicHouse() {
        map.add(new MagicHouse());
    }

    private void initAreaFiveHouse() {
        for (int i = 0; i < 13; i++) {
            map.add(new House(5));
        }
    }

    private void initPrison() {
        map.add(new Prison());
    }

    private void initAreaFourHouse() {
        for (int i = 0; i < 13; i++) {
            map.add(new House(4));
        }
    }

    private void initGiftHouse() {
        map.add(new GiftHouse());
    }

    private void initAreaThreeHouse() {
        for (int i = 0; i < 6; i++) {
            map.add(new House(3));
        }
    }

    private void initItemHouse() {
        map.add(new ItemHouse());
    }

    private void initAreaTwoHouse() {
        for (int i = 0; i < 13; i++) {
            map.add(new House(2));
        }
    }

    private void initHospital() {
        map.add(new Hospital());
    }

    private void initAreaOneHouse() {
        for (int i = 0; i < 13; i++) {
            map.add(new House(1));
        }
    }

    private void initStartPoint() {
        map.add(new StartPoint());
    }

    public int getSize() {
        return map.size();
    }

    public void executeFunc(Player player, Scanner scanner) {
        map.get(player.getLocation()).executeFunc(player, scanner);
    }
}
