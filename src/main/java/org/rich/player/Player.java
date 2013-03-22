package org.rich.player;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParameterList;
import org.rich.item.Item;
import org.rich.map.House;
import org.rich.map.ItemHouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.rich.map.ItemHouse.*;

public class Player {
    public static final int INIT_POINT = 1000;
    private final String name;
    public final static int INIT_MONEY = 1000;

    private int location;

    private final String abbr;

    private int money;
    private List<Item> item;
    private int point;
    private int bomb;
    private int robot;
    private int blocker;

    public Player(String name, String abbr) {
        this.name = name;
        this.abbr = abbr;
        this.money = INIT_MONEY;
        this.point = INIT_POINT;
        item = new ArrayList<Item>();
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

    public List<Item> getItem() {
        return item;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void addBomb() {
        bomb++;
        point -= BOMB_POINT;
    }

    public int getBomb() {
        return bomb;
    }

    public int getRobot() {
        return robot;
    }

    public void addRobot() {
        robot++;
        point -= ROBOT_POINT;
    }

    public void addBlocker() {
        blocker++;
        point -= BLOCKER_POINT;
    }

    public int getBlocker() {
        return blocker;
    }
}
