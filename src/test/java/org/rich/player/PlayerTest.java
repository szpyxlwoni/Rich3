package org.rich.player;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player("孙小美", "S");
    }

    @Test
    public void should_move() {
        player.moveOneStep();
        assertThat(player.getLocation(), is(1));
    }

    @Test
    public void should_on_start_point_when_move_70_steps() {
        for (int i = 0; i < 70; i++) {
            player.moveOneStep();
        }
        assertThat(player.getLocation(), is(0));
    }
}
