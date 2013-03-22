package org.rich.map;

import org.rich.player.Player;

import java.util.Scanner;

public class House implements Land {
    private String owner = "";
    private int area;
    public static final int AREA_ONE_OR_TWO_FEE = 200;
    public static final int AREA_FOUR_OR_FIVE_FEE = 300;
    public static final int AREA_THREE_FEE = 500;
    private int level;

    public House(int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "0";
    }

    public Boolean isBoughtBy(Player player) {
        return player.getName().equals(owner);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getFee() {
        if (area == 3) {
            return AREA_THREE_FEE;
        } else if (area == 4 || area == 5) {
            return AREA_FOUR_OR_FIVE_FEE;
        }
        return AREA_ONE_OR_TWO_FEE;
    }

    public int getLevel() {
        return level;
    }

    public boolean isEmpty() {
        return getOwner().equals("");
    }

    public boolean isMax() {
        return level == 3;
    }

    public void levelUp() {
        level++;
    }

    @Override
    public void executeFunc(Player player, Scanner scanner) {
        if (this.isEmpty()) {
            System.out.println("是否购买该处空地，xxx元（Y/N）?");
            if (scanner.next().equals("N")) {
                return;
            }
            player.setMoney(player.getMoney() - getFee());
            setOwner(player.getName());
        } else if (isBoughtBy(player) && !isMax()) {
            System.out.println("是否升级该处地产，xxx元（Y/N）?");
            if (scanner.next().equals("N")) {
                return;
            }
            player.setMoney(player.getMoney() - getFee());
            levelUp();
        } else if (!isBoughtBy(player)) {
            System.out.println("此地为" + getOwner() + "所有，您需缴纳过路费" + getFee() * (getLevel() + 1) / 2);
            player.setMoney(player.getMoney() - getFee() * (getLevel() + 1) / 2);
        }
    }
}
