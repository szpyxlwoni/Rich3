package org.rich.map;

import org.junit.Before;
import org.junit.Test;
import org.rich.player.Player;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.rich.map.ItemHouse.*;
import static org.rich.player.Player.*;

public class ItemHouseTest {

    private Player player;
    private ItemHouse itemHouse;

    @Before
    public void setUp() throws Exception {
        player = new Player("孙小美", "S");
        itemHouse = new ItemHouse();
    }

    @Test
    public void should_let_player_buy_one_item_when_player_choose_one_item() {
        Scanner scanner = new Scanner(new ByteArrayInputStream("1 2 3".getBytes()));

        itemHouse.executeFunc(player, scanner);
        assertThat(player.getPoint(), is(INIT_POINT - BLOCKER_POINT));

        itemHouse.executeFunc(player, scanner);
        assertThat(player.getPoint(), is(INIT_POINT - BLOCKER_POINT - ROBOT_POINT));

        itemHouse.executeFunc(player, scanner);
        assertThat(player.getPoint(), is(INIT_POINT - BLOCKER_POINT - ROBOT_POINT - BOMB_POINT));
    }

    @Test
    public void should_do_nothing_when_player_do_not_have_enough_point() {
        player.setPoint(0);
        itemHouse.executeFunc(player, new Scanner(System.in));

        assertThat(player.getPoint(), is(0));
        assertTrue(player.getItem().isEmpty());
    }

    @Test
    public void should_do_nothing_when_player_have_not_enough_money_to_buy_its_choose_item() {
        player.setPoint(40);
        Scanner scanner = new Scanner(new ByteArrayInputStream("3".getBytes()));

        itemHouse.executeFunc(player, scanner);

        assertThat(player.getPoint(), is(40));
        assertTrue(player.getItem().isEmpty());
    }

    @Test
    public void should_do_nothing_when_player_type_a_wrong_input() {
        Scanner scanner = new Scanner(new ByteArrayInputStream("d".getBytes()));

        itemHouse.executeFunc(player, scanner);

        assertThat(player.getPoint(), is(INIT_POINT));
        assertTrue(player.getItem().isEmpty());
    }

    @Test
    public void should_do_nothing_when_player_choose_wrong_item() {
        Scanner scanner = new Scanner(new ByteArrayInputStream("9".getBytes()));

        itemHouse.executeFunc(player, scanner);

        assertThat(player.getPoint(), is(INIT_POINT));
        assertTrue(player.getItem().isEmpty());
    }
}
