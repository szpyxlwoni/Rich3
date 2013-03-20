package org.rich.player;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class PlayersTest {

    private Players players;

    @Before
    public void setUp() {
        players = new Players("1234");
    }

    @Test
    public void should_init_four_players_given_four_number() {
        int playerNumber = players.getPlayersNumber();
        assertThat(playerNumber, is(4));
    }

    @Test
    public void should_init_two_players_given_two_number() {
        Players players = new Players("12");
        int playerNumber = players.getPlayersNumber();
        assertThat(playerNumber, is(2));
    }

    @Test
    public void should_get_current_player() {
        assertThat(players.getCurrentPlayer(), is(Player.class));
    }

    @Test
    public void should_change_player() {
        Player oldPlayer = players.getCurrentPlayer();
        players.changePlayer();
        Player newPlayer = players.getCurrentPlayer();
        assertThat(players.getPlayersNumber(), is(4));
        assertThat(oldPlayer, not(newPlayer));
    }

    @Test
    public void should_roll_a_random_number() {
        int randomNumber = players.roll();
        assertThat(randomNumber <= 6 && randomNumber >= 1, is(true));
    }
}