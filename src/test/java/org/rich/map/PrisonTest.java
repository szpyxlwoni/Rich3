package org.rich.map;

import org.junit.Test;
import org.rich.player.Player;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PrisonTest {
    @Test
    public void should_stop_player_move_when_player_arrive() {
        Prison prison = new Prison();
        Player player = new Player("孙小美", "S");
        assertFalse(prison.isStop(player));
    }
}
