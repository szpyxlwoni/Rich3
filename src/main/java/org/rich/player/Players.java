package org.rich.player;

import org.rich.map.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Players {
    private final int PLAYER_MAX_NUMBER = 4;
    private List<Player> players = new ArrayList<Player>();
    private String[] roles = new String[]{"钱夫人", "阿土伯", "孙小美", "金贝贝", "Q", "A", "S", "J"};
    private final int RANDOM_SIZE = 6;

    public Players(String rolesStr) {
        for (int i = 0; i < rolesStr.length(); i++) {
            players.add(new Player(roles[getRoleIndex(rolesStr, i)], roles[getRoleIndex(rolesStr, i) + PLAYER_MAX_NUMBER]));
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

    public void move(Map map) {
        int moveNumber = roll();
        for (int i = 0; i < moveNumber; i++) {
            moveOneStep(roll(), map);
        }
    }

    private void moveOneStep(int moveNumber, Map map) {
        getCurrentPlayer().moveOneStep();
    }

    public int roll() {
        return new Random().nextInt(RANDOM_SIZE) + 1;
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
