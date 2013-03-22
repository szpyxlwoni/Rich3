package org.rich.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.rich.player.Player;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.rich.map.House.AREA_ONE_OR_TWO_FEE;
import static org.rich.player.Player.INIT_MONEY;

public class HouseTest {
    private Player player;
    private House house;

    @Before
    public void setUp() throws Exception {
        player = new Player("孙小美", "S");
        house = new House(1);
    }

    @Test
    public void should_return_diff_fee_when_house_in_diff_area() {
        House areaOneHose = new House(1);
        House areaTwoHose = new House(2);
        House areaThreeHose = new House(3);
        House areaFourHose = new House(4);
        House areaFiveHose = new House(5);

        assertThat(areaOneHose.getFee(), is(200));
        assertThat(areaTwoHose.getFee(), is(200));
        assertThat(areaThreeHose.getFee(), is(500));
        assertThat(areaFourHose.getFee(), is(300));
        assertThat(areaFiveHose.getFee(), is(300));
    }

    @Test
    public void should_ask_for_bought_house_when_user_first_arrived() {
        Scanner scanner = new Scanner(new ByteArrayInputStream("Y".getBytes()));
        house.executeFunc(player, scanner);
        Assert.assertThat(player.getMoney(), is(INIT_MONEY - AREA_ONE_OR_TWO_FEE));
        Assert.assertThat(house.getLevel(), is(0));
        assertTrue(house.isBoughtBy(player));
    }

    @Test
    public void should_ask_for_level_up_house_when_user_first_arrived() {
        Scanner scanner = new Scanner(new ByteArrayInputStream("Y Y".getBytes()));
        house.executeFunc(player, scanner);
        house.executeFunc(player, scanner);
        Assert.assertThat(player.getMoney(), is(INIT_MONEY - 2 * AREA_ONE_OR_TWO_FEE));
        Assert.assertThat(house.getLevel(), is(1));
        assertTrue(house.isBoughtBy(player));
    }

    @Test
    public void should_do_not_level_up_house_when_user_fifth_arrived() {
        Scanner scanner = new Scanner(new ByteArrayInputStream("Y Y Y Y".getBytes()));
        house.executeFunc(player, scanner);
        house.executeFunc(player, scanner);
        house.executeFunc(player, scanner);
        house.executeFunc(player, scanner);
        house.executeFunc(player, scanner);
        Assert.assertThat(player.getMoney(), is(INIT_MONEY - 4 * AREA_ONE_OR_TWO_FEE));
        Assert.assertThat(house.getLevel(), is(3));
        assertTrue(house.isBoughtBy(player));
    }

    @Test
    public void should_sub_player_money_when_not_owner_user_arrive() {
        Scanner scanner = new Scanner(new ByteArrayInputStream("Y".getBytes()));
        house.executeFunc(player, scanner);
        Player notOwnerPlayer = new Player("阿土伯", "A");
        house.executeFunc(notOwnerPlayer, scanner);
        Assert.assertThat(notOwnerPlayer.getMoney(), is(INIT_MONEY - AREA_ONE_OR_TWO_FEE / 2));
        assertTrue(house.isBoughtBy(player));
    }
}
