package org.rich.player;

public class Player {
    private final String name;

    private int location;

    private final String abbr;

    public Player(String name, String abbr) {
        this.name = name;
        this.abbr = abbr;
    }

    public void move(int moveNumber) {
        location += moveNumber;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getAbbr() {
        return abbr;
    }
}
