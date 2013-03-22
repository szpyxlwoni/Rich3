package org.rich.map;

import org.rich.player.Player;

import java.util.Scanner;

public class Mine implements Land {
    private int pointNumber;

    public Mine(int pointNumber) {
        this.pointNumber = pointNumber;
    }

    @Override
    public void executeFunc(Player player, Scanner scanner) {
          player.setPoint(player.getPoint() + pointNumber);
    }

    @Override
    public String toString() {
        return "$";
    }
}
