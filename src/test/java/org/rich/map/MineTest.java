package org.rich.map;

import org.junit.Test;
import org.rich.player.Player;

import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MineTest {
    @Test
    public void should_give_player_point_when_player_arrive() {
        Mine mine = new Mine(100);
        Player player = new Player("孙小美", "S");

        mine.executeFunc(player, new Scanner(System.in));

        assertThat(player.getPoint(), is(Player.INIT_POINT + 100));
    }
}
