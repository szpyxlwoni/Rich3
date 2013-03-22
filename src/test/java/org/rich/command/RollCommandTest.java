package org.rich.command;

import org.junit.Test;
import org.rich.map.Map;
import org.rich.player.Players;

import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RollCommandTest {
    @Test
    public void should_move_player_and_change_player() {
        Players players = mock(Players.class);
        Command command = new RollCommand();
        Map map = new Map();
        command.execute(players, map, new Scanner(System.in));
        verify(players).move(map);
        verify(players).changePlayer();
    }
}
