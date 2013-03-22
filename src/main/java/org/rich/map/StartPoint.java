package org.rich.map;

import org.rich.player.Player;

import java.util.Scanner;

public class StartPoint implements Land {
    @Override
    public String toString() {
        return "S";
    }

    @Override
    public void executeFunc(Player player, Scanner scanner) {
    }
}
