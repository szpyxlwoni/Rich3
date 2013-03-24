package org.rich.player;

import org.rich.item.Blockers;
import org.rich.item.Bombs;
import org.rich.item.Robot;
import org.rich.map.House;
import org.rich.map.Map;

import java.util.ArrayList;
import java.util.List;

import static org.rich.map.ItemHouse.*;

public class Player {
    public static final int INIT_POINT = 1000;
    public static final int INIT_MONEY = 1000;

    private final String name;
    private final String abbr;

    private int location;
    private int money;
    private int point;
    public final Blockers blockers = new Blockers();
    public final Bombs bombs = new Bombs();
    private boolean hasGod;
    private List<House> houseList = new ArrayList<House>();

    public Player(String name, String abbr) {
        this.name = name;
        this.abbr = abbr;
        this.money = INIT_MONEY;
        this.point = INIT_POINT;
        this.hasGod = false;
    }

    public void moveOneStep() {
        location = (location + 1) % Map.MAP_SIZE;
    }

    public boolean isBlessed() {
        return hasGod;
    }

    public void toBless() {
        hasGod = true;
    }

    public int getLocation() {
        return location;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void addHouse(House house) {
        houseList.add(house);
    }

    public int getSetLocation(int relativePosition) {
        if (relativePosition < 0) {
            return getLocation() + relativePosition + Map.MAP_SIZE;
        }
        return getLocation() + relativePosition;
    }

    public Blockers getBlockers() {
        return blockers;
    }

    public Bombs getBombs() {
        return bombs;
    }

    public boolean hasBomb() {
        return bombs.getNumber() != 0;
    }
}
