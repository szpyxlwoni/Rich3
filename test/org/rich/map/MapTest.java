package org.rich.map;

import org.junit.Test;
import org.rich.player.Players;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MapTest {
    @Test
    public void should_init_map() {
        Map map = new Map(70);
        assertThat(map.getSize(), is(70));
    }

    @Test
    public void should_map_to_string_when_given_70_empty_house_and_one_player() {
        Map map = new Map(70);
        Players players = new Players("1");
        assertThat(map.toOutputType(players), is("Q0000000000000000000000000000\n" +
                                                 "0                           0\n" +
                                                 "0                           0\n" +
                                                 "0                           0\n" +
                                                 "0                           0\n" +
                                                 "0                           0\n" +
                                                 "0                           0\n" +
                                                 "00000000000000000000000000000\n"));
    }
}
