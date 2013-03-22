package org.rich.command;

import org.junit.Before;
import org.junit.Test;
import org.rich.map.Map;
import org.rich.player.Players;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BlockCommandTest {

    private Players players;
    private BlockCommand blockCommand;
    private Scanner scanner;

    @Before
    public void setUp() throws Exception {
        players = new Players("1234");
        blockCommand = new BlockCommand();
        scanner = new Scanner(new ByteArrayInputStream("-10".getBytes()));
    }

    @Test
    public void should_do_nothing_when_player_have_not_blocker() {
        blockCommand.execute(players, new Map(), scanner);
        assertThat(players.getCurrentPlayer().getBlocker(), is(0));
    }

    @Test
    public void should_set_blocker_when_player_have_blocker() {
        Map map = mock(Map.class);
        players.getCurrentPlayer().addBlocker();
        players.getCurrentPlayer().addBlocker();
        blockCommand.execute(players, map, scanner);
        verify(map).useBlocker(60);
        assertThat(players.getCurrentPlayer().getBlocker(), is(1));
    }

    @Test
    public void should_model_negative_number() {
        int blockerLocation = blockCommand.getBlockerSetLocation(players, -10);
        assertThat(blockerLocation, is(60));
    }
}
