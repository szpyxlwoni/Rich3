package org.rich;

import org.rich.command.Command;
import org.rich.map.Map;
import org.rich.player.Players;

import java.util.Scanner;

public class BootstrapRich {

    private Scanner scanner;
    private Map map;
    private Players players;

    public void init() {
        System.out.println("请选择2~4位不重复玩家，输入编号即可。(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):");
        scanner = new Scanner(System.in);
        players = new Players(scanner.next());
        map = new Map(70);
    }

    public void start() {
        map.output(players);
        System.out.println(players.getCurrentPlayerName() + ">>");
        String commandStr = scanner.next();
        while (!commandStr.equalsIgnoreCase("exit")) {
            Command command = getCommand(commandStr);
            System.out.println(players.getCurrentPlayerName() + ">");
            commandStr = scanner.next();
        }
    }

    private Command getCommand(String commandStr) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public void close() {
        scanner.close();
    }
}
