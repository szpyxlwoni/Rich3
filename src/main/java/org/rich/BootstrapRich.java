package org.rich;

import org.rich.map.Map;
import org.rich.player.Players;

import java.lang.reflect.Method;
import java.util.Scanner;

public class BootstrapRich {

    private Scanner scanner;
    private Map map;
    private Players players;

    public void init() {
        System.out.println("请选择2~4位不重复玩家，输入编号即可。" +
                "(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):");
        scanner = new Scanner(System.in);
        players = new Players(scanner.next());
        map = new Map();
    }

    public void start() {
        map.output(players);
        System.out.println(players.getCurrentPlayerName() + ">");
        String commandStr = scanner.next().toLowerCase();
        while (!commandStr.equalsIgnoreCase("quit")) {
            executeCommand(commandStr);
            map.output(players);
            if (players.getPlayersNumber() == 1) {
                System.out.println("胜利者是" + players.getCurrentPlayerName());
                close();
            }
            System.out.println(players.getCurrentPlayerName() + ">");
            commandStr = scanner.next();
        }
    }

    private void executeCommand(String commandStr) {
        try {
            Class commandClass = Class.forName("org.rich.command." + changeStrToCommandName(commandStr) + "Command");
            Method executeMethod = commandClass.getMethod("execute", Players.class, Map.class, Scanner.class);
            executeMethod.invoke(commandClass.newInstance(), players, map, scanner);
        } catch (Exception e) {
        }
    }

    private String changeStrToCommandName(String commandStr) {
        return commandStr.replaceFirst(commandStr.charAt(0) + "", (commandStr.charAt(0) + "").toUpperCase());
    }

    public void close() {
        System.out.println("游戏结束");
        scanner.close();
        System.exit(1);
    }
}
