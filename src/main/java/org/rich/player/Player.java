package org.rich.player;

public class Player {
    private final String name;
    private int location;

    public Player(String name) {
        this.name = name;
    }

    public void move(int moveNumber) {
        location += moveNumber;
    }

    public int getLocation() {
        return location;
    }
}
