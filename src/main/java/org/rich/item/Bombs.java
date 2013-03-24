package org.rich.item;

import org.rich.map.Map;
import org.rich.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Bombs {
    List<Integer> bombs = new ArrayList<Integer>();

    public Bombs() {
    }

    public int getNumber() {
        return bombs.size();
    }
}