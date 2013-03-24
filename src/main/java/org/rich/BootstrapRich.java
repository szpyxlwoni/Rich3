package org.rich;

import org.rich.map.Map;
import org.rich.player.Players;

import java.lang.reflect.Method;
import java.util.Scanner;

public class BootstrapRich {

    public static final String COMMAND_PATH = "org.rich.command.";
    private Scanner scanner;

    private Map map;

    private Players players;
    public static void main(String[] args) {
        BootstrapRich bootstrapRich = new BootstrapRich();
        bootstrapRich.init();
        bootstrapRich.start();
    }

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
            executeCommandByString(commandStr);
            map.output(players);
            System.out.println(players.getCurrentPlayerName() + ">");
            commandStr = scanner.next();
        }
    }

    public void executeCommandByString(String commandStr) {
        Class commandClass = null;
        try {
            commandClass = Class.forName(COMMAND_PATH + changeStrToCommandName(commandStr));
            Method executeMethod = commandClass.getMethod("execute", Players.class, Map.class, Scanner.class);
            executeMethod.invoke(commandClass.newInstance(), players, map, scanner);
        } catch (Exception e) {
        }
    }

    public String changeStrToCommandName(String commandStr) {
        return commandStr.toLowerCase()
                .replaceFirst(commandStr.charAt(0) + "", (commandStr.charAt(0) + "")
                        .toUpperCase())
                + "Command";
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Map getMap() {
        return map;
    }

    public Players getPlayers() {
        return players;
    }
}
