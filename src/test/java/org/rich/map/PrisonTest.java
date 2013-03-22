package org.rich.map;

import org.junit.Test;
import org.rich.player.Player;

import java.util.Scanner;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class PrisonTest {
    @Test
    public void should_stop_player_move_when_player_arrive() {
        Prison prison = new Prison();
        Player player = new Player("孙小美", "S");
        assertFalse(prison.isStop(player));
    }

    @Test
    public void should_stop_player_move_when_player_arrive_prison() {
        Prison prison = new Prison();
        Player player = new Player("孙小美", "S");

        player.setLocation(48);
        assertFalse(prison.isStop(player));
        player.moveOneStep();
        prison.executeFunc(player, new Scanner(System.in));
        assertTrue(prison.isStop(player));
    }
}
