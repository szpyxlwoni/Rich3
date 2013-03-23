package org.rich.command;

import org.rich.map.Map;
import org.rich.player.Player;
import org.rich.player.Players;

import java.util.Scanner;

public class QueryCommand implements Command {

    @Override
    public void execute(Players players, Map map, Scanner input) {
        Player currentPlayer = players.getCurrentPlayer();
        System.out.println("资 金：" + currentPlayer.getMoney() + "元\n" +
                "点数：" + currentPlayer.getPoint() + "点\n" +
                "地产：空地" + currentPlayer.getEmptyHouseNumber() + "处；" +
                "茅屋" + currentPlayer.getLevelOneHouseNumber() + "处" +
                "洋房" + currentPlayer.getLevelTwoHouseNumber() + "处" +
                "摩天楼" + currentPlayer.getLevelThreeHouseNumber() + "处。\n" +
                "道具：路障 " + currentPlayer.getBlocker() + "个；" +
                "炸弹" + currentPlayer.getBomb() + "个；" +
                "机器娃娃 " + currentPlayer.getRobot() + "个\n");
    }
}
