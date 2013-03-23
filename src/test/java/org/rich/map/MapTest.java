package org.rich.map;

import org.junit.Before;
import org.junit.Test;
import org.rich.player.Players;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MapTest {

    private Map map;

    @Before
    public void setUp() throws Exception {
        map = new Map();
    }

    @Test
    public void should_init_map() {
        assertThat(map.getSize(), is(70));
    }

    @Test
    public void should_map_to_string_when_given_70_empty_house_and_two_player() {
        Players players = new Players("12");
        assertThat(map.toOutputType(players), is("Q0000000000000H0000000000000T\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "M0000000000000P0000000000000G\n"));
    }
}
