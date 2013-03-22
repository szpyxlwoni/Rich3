package org.rich.map;

import org.junit.Before;
import org.junit.Test;
import org.rich.player.Player;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.rich.map.ItemHouse.*;
import static org.rich.player.Player.*;

public class ItemHouseTest {

    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player("孙小美", "S");
    }

    @Test
    public void should_let_player_buy_one_item_when_player_choose_one_item() {
        ItemHouse itemHouse = new ItemHouse();
        Scanner scanner = new Scanner(new ByteArrayInputStream("1 2 3".getBytes()));

        itemHouse.executeFunc(player, scanner);
        assertThat(player.getItem().size(), is(1));
        assertThat(player.getPoint(), is(INIT_POINT - BLOCKER_POINT));

        itemHouse.executeFunc(player, scanner);
        assertThat(player.getItem().size(), is(2));
        assertThat(player.getPoint(), is(INIT_POINT - BLOCKER_POINT - ROBOT_POINT));

        itemHouse.executeFunc(player, scanner);
        assertThat(player.getItem().size(), is(3));
        assertThat(player.getPoint(), is(INIT_POINT - BLOCKER_POINT - ROBOT_POINT - BOMB_POINT));
    }

    @Test
    public void should_do_nothing_when_player_do_not_have_enough_point() {
        player.setPoint(0);
        ItemHouse itemHouse = new ItemHouse();
        itemHouse.executeFunc(player, new Scanner(System.in));

        assertThat(player.getPoint(), is(0));
        assertThat(player.getItem().size(), is(0));
    }
}
