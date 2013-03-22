package org.rich.map;

import org.junit.Test;
import org.rich.player.Player;
import org.rich.player.Players;

import java.util.Scanner;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MapTest {
    @Test
    public void should_init_map() {
        Map map = new Map();
        assertThat(map.getSize(), is(70));
    }

    @Test
    public void should_map_to_string_when_given_70_empty_house_and_two_player() {
        Map map = new Map();
        Players players = new Players("12");
        assertThat(map.toOutputType(players), is("Q0000000000000S0000000000000T\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "S0000000000000P0000000000000S\n"));
    }
}
