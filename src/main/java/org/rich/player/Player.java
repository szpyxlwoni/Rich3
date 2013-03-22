package org.rich.player;

import org.rich.map.House;

import java.util.Scanner;

public class Player {
    private final String name;
    public final static int INIT_MONEY = 1000;

    private int location;

    private final String abbr;

    private int money;

    public Player(String name, String abbr) {
        this.name = name;
        this.abbr = abbr;
        this.money = INIT_MONEY;
    }

    public void moveOneStep() {
        location = (location + 1) % 70;
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
}
