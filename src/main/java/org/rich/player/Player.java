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

    public void arrive(House house, Scanner scanner) {
        if (house.isEmpty()) {
            System.out.println("是否购买该处空地，xxx元（Y/N）?");
            if (scanner.next().equals("N")) {
                return;
            }
            money -= house.getFee();
            house.setOwner(this.getName());
        } else if (house.isBoughtBy(this) && !house.isMax()) {
            System.out.println("是否升级该处地产，xxx元（Y/N）?");
            if (scanner.next().equals("N")) {
                return;
            }
            money -= house.getFee();
            house.levelUp();
        } else if (!house.isBoughtBy(this)) {
            money -= house.getFee() * (house.getLevel() + 1) / 2;
        }
    }

    public void move(int moveNumber) {
        location += moveNumber;
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
}
