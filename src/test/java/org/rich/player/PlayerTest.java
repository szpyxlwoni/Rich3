package org.rich.player;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.rich.map.House;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.rich.map.House.AREA_ONE_OR_TWO_FEE;
import static org.rich.player.Player.INIT_MONEY;

public class PlayerTest {

    private Player player;
    private House house;

    @Before
    public void setUp() throws Exception {
        player = new Player("a", "b");
        house = new House(1);

    }

    @Test
    public void should_move() {
        player.move(1);
        assertThat(player.getLocation(), is(1));
    }

    @Test
    public void should_ask_for_bought_house_when_user_first_arrived() {
        Scanner scanner = new Scanner(new ByteArrayInputStream("Y".getBytes()));
        player.arrive(house, scanner);
        assertThat(player.getMoney(), is(INIT_MONEY - AREA_ONE_OR_TWO_FEE));
        assertThat(house.getLevel(), is(0));
        assertTrue(house.isBoughtBy(player));
    }

    @Test
    public void should_ask_for_level_up_house_when_user_first_arrived() {
        Scanner scanner = new Scanner(new ByteArrayInputStream("Y Y".getBytes()));
        player.arrive(house, scanner);
        player.arrive(house, scanner);
        assertThat(player.getMoney(), is(INIT_MONEY - 2 * AREA_ONE_OR_TWO_FEE));
        assertThat(house.getLevel(), is(1));
        assertTrue(house.isBoughtBy(player));
    }

    @Test
    public void should_do_not_level_up_house_when_user_fifth_arrived() {
        Scanner scanner = new Scanner(new ByteArrayInputStream("Y Y Y Y".getBytes()));
        player.arrive(house, scanner);
        player.arrive(house, scanner);
        player.arrive(house, scanner);
        player.arrive(house, scanner);
        player.arrive(house, scanner);
        assertThat(player.getMoney(), is(INIT_MONEY - 4 * AREA_ONE_OR_TWO_FEE));
        assertThat(house.getLevel(), is(3));
        assertTrue(house.isBoughtBy(player));
    }

    @Test
    public void should_sub_player_money_when_not_owner_user_arrive() {
        Scanner scanner = new Scanner(new ByteArrayInputStream("Y".getBytes()));
        player.arrive(house, scanner);
        Player notOwnerPlayer = new Player("c", "d");
        notOwnerPlayer.arrive(house, scanner);
        assertThat(notOwnerPlayer.getMoney(), is(INIT_MONEY - AREA_ONE_OR_TWO_FEE / 2));
        assertTrue(house.isBoughtBy(player));
    }
}
