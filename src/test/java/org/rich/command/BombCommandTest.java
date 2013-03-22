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

public class BombCommandTest {
    private Players players;
    private BombCommand bombCommand;
    private Scanner scanner;

    @Before
    public void setUp() throws Exception {
        players = new Players("1234");
        bombCommand = new BombCommand();
        scanner = new Scanner(new ByteArrayInputStream("-10".getBytes()));
    }

    @Test
    public void should_do_nothing_when_player_have_not_blocker() {
        bombCommand.execute(players, new org.rich.map.Map(), scanner);
        assertThat(players.getCurrentPlayer().getBomb(), is(0));
    }

    @Test
    public void should_set_blocker_when_player_have_blocker() {
        Map map = mock(Map.class);
        players.getCurrentPlayer().addBomb();
        players.getCurrentPlayer().addBomb();
        bombCommand.execute(players, map, scanner);
        verify(map).useBomb(60);
        assertThat(players.getCurrentPlayer().getBomb(), is(1));
    }

    @Test
    public void should_model_negative_number() {
        int blockerLocation = bombCommand.getBombSetLocation(players, -10);
        assertThat(blockerLocation, is(60));
    }
}
