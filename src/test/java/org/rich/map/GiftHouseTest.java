package org.rich.map;

import org.junit.Before;
import org.junit.Test;
import org.rich.helper.ScannerHelper;
import org.rich.player.Player;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.rich.player.Player.INIT_MONEY;
import static org.rich.player.Player.INIT_POINT;

public class GiftHouseTest {
    private Player player;
    private GiftHouse giftHouse;

    @Before
    public void setUp() throws Exception {
        player = new Player("孙小美", "S");
        giftHouse = new GiftHouse();
    }

    @Test
    public void should_let_player_get_one_item_when_player_choose_one_item() {
        Scanner scanner = ScannerHelper.createScannerForTest("1 2 3");

        giftHouse.executeFunc(player, scanner);
        assertThat(player.getMoney(), is(INIT_MONEY + 2000));

        giftHouse.executeFunc(player, scanner);
        assertThat(player.getPoint(), is(INIT_POINT + 200));

        giftHouse.executeFunc(player, scanner);
        assertTrue(player.isBlessed());
    }
}
