package org.rich.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Players {
    private List<Player> players = new ArrayList<Player>();
    private String[] roles = new String[]{"钱夫人", "阿土伯", "孙小美", "金贝贝", "Q", "A", "S", "J"};

    public Players(String rolesStr) {
        for (int i = 0; i < rolesStr.length(); i++) {
            players.add(new Player(roles[getRoleIndex(rolesStr, i)], roles[getRoleIndex(rolesStr, i) + 4]));
        }
    }

    private int getRoleIndex(String rolesStr, int i) {
        return rolesStr.charAt(i) - '1';
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

    public void move() {
        getCurrentPlayer().move(roll());
    }

    public int roll() {
        return new Random().nextInt(6) + 1;
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
}
