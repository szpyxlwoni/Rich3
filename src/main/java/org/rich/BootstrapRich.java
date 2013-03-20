package org.rich;

import org.rich.map.Map;
import org.rich.player.Players;

import java.util.Scanner;

public class BootstrapRich {

    private Scanner scanner;

    public void init() {
        scanner = new Scanner(System.in);
        Players players = new Players(scanner.next());
        Map map = new Map();
    }

    public void start() {
        while (!scanner.next().equalsIgnoreCase("exit")) {
            //TODO execute command
        }
    }

    public void close() {
        scanner.close();
    }
}
