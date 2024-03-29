package org.rich.map;

import org.junit.Before;
import org.junit.Test;
import org.rich.player.Player;

import java.util.Scanner;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class PrisonTest {

    private Prison prison;
    private Player player;

    @Before
    public void setUp() throws Exception {
        prison = new Prison();
        player = new Player("孙小美", "S");
    }

    @Test
    public void should_stop_player_move_when_player_arrive() {
        assertFalse(prison.isStop(player));
    }

    @Test
    public void should_stop_player_move_when_player_arrive_prison() {
        assertFalse(prison.isStop(player));
        player.moveOneStep();
        prison.executeFunc(player, new Scanner(System.in));
        assertTrue(prison.isStop(player));
    }
}
