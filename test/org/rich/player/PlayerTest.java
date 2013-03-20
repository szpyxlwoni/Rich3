package org.rich.player;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlayerTest {
    @Test
    public void should_move() {
        Player player = new Player("a");
        player.move(1);
        assertThat(player.getLocation(), is(1));
    }
}
