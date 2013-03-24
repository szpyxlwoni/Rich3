package org.rich.player;

import org.rich.map.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Players {
    private List<Player> players = new ArrayList<Player>();
    private static final int RANDOM_SIZE = 6;

    public Players(String rolesStr) {
        for (int i = 0; i < rolesStr.length(); i++) {
            players.add(new Player(getNameByStringNumber(rolesStr, i), getAbbreviationByStringNumber(rolesStr, i)));
        }
    }

    private String getAbbreviationByStringNumber(String rolesStr, int i) {
        return RolesAbbreviation.values()[rolesStr.charAt(i) - '1'].toString();
    }

    private String getNameByStringNumber(String rolesStr, int i) {
        return Roles.values()[rolesStr.charAt(i) - '1'].toString();
    }

    public int getPlayersNumber() {
        return players.size();
    }

    public void changePlayer() {
        Player oldPlayer = getCurrentPlayer();
        players.remove(oldPlayer);
        players.add(oldPlayer);
    }

    public Player getCurrentPlayer() {
        return players.get(0);
    }

    public void move(Map map, Scanner scanner) {
    }

    private void moveOneStep() {
        getCurrentPlayer().moveOneStep();
    }

    public int roll() {
        int retVal = new Random().nextInt(RANDOM_SIZE) + 1;
        return retVal;
    }

    public String checkPlayerLocation(String mapStr, int location) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getLocation() == location) {
                return players.get(i).getAbbr();
            }
        }
        return mapStr;
    }

    public String getCurrentPlayerName() {
        return getCurrentPlayer().getName();
    }

    public String getCurrentPlayerAbbr() {
        return getCurrentPlayer().getAbbr();
    }
}
