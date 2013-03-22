package org.rich.map;

import org.junit.Before;
import org.junit.Test;
import org.rich.player.Player;

import java.util.Scanner;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class HospitalTest {

    private Hospital hospital;
    private Player player;

    @Before
    public void setUp() throws Exception {
        hospital = new Hospital();
        player = new Player("孙小美", "S");
    }

    @Test
    public void should_stop_player_move_when_player_arrive() {
        assertFalse(hospital.isStop(player));
    }

    @Test
    public void should_stop_player_move_when_player_arrive_prison() {
        assertFalse(hospital.isStop(player));
        player.moveOneStep();
        hospital.executeFunc(player, new Scanner(System.in));
        assertFalse(hospital.isStop(player));
    }
}
