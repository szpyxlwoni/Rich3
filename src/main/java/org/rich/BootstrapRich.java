package org.rich;

import org.rich.map.Map;
import org.rich.player.Players;

import java.util.Scanner;

public class BootstrapRich {

    private Scanner scanner;
    private Map map;
    private Players players;

    public void init() {
        scanner = new Scanner(System.in);
        players = new Players(scanner.next());
        map = new Map(70);
    }

    public void start() {
        map.output(players);
        while (!scanner.next().equalsIgnoreCase("exit")) {
        }
    }

    public void close() {
        scanner.close();
    }
}
