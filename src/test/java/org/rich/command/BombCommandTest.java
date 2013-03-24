package org.rich.command;

import org.junit.Before;
import org.junit.Test;
import org.rich.map.Map;
import org.rich.player.Player;
import org.rich.util.CommandContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.rich.util.CommandContext.*;

public class BombCommandTest {
    private Player player;
    private BombCommand bombCommand;
    private CommandContext commandContext;

    @Before
    public void setUp() throws Exception {
        bombCommand = new BombCommand();
        commandContext = new CommandContext();
        player = new Player("孙小美", "S");

        commandContext.setPlayer(player);
    }

    @Test
    public void should_do_nothing_when_player_have_not_blocker() {
        bombCommand.execute(commandContext);

        assertThat(commandContext.getState(), is(NO_ITEM));
    }

    @Test
    public void should_set_blocker_when_player_have_blocker() {
        Map map = mock(Map.class);
        commandContext.setMap(map);
        commandContext.setLocation(-10);

        bombCommand.execute(commandContext);
    }
}
