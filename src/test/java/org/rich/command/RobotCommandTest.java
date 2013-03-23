package org.rich.command;

import org.junit.Before;
import org.junit.Test;
import org.rich.map.Map;
import org.rich.player.Players;

import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RobotCommandTest {
    private Players players;
    private RobotCommand robotCommand;

    @Before
    public void setUp() throws Exception {
        robotCommand = new RobotCommand();
        players = new Players("12");
    }

    @Test
    public void should_do_nothing_when_player_have_not_blocker() {
        robotCommand.execute(players, new Map(), new Scanner(System.in));
        assertThat(players.getCurrentPlayer().getRobot(), is(0));
    }

    @Test
    public void should_clear_all_blocker_or_bomb_in_further_10_map() {
        Map map = mock(Map.class);
        players.getCurrentPlayer().addRobot();
        robotCommand.execute(players, map, new Scanner(System.in));
        verify(map).useRobot(players.getCurrentPlayer().getLocation());
        assertThat(players.getCurrentPlayer().getRobot(), is(0));
    }
}
