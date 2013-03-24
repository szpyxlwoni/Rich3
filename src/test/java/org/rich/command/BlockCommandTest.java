package org.rich.command;

import org.junit.Before;
import org.junit.Test;
import org.rich.map.Map;
import org.rich.player.Player;
import org.rich.util.CommandContext;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.rich.util.CommandContext.NO_ITEM;
import static org.rich.util.CommandContext.SUCCESS;

public class BlockCommandTest {
    private Player player;
    private BlockCommand blockerCommand;
    private CommandContext commandContext;

    @Before
    public void setUp() throws Exception {
        blockerCommand = new BlockCommand();
        commandContext = new CommandContext();
        player = new Player("孙小美", "S");

        commandContext.setPlayer(player);
    }

    @Test
    public void should_do_nothing_when_player_have_not_blocker() {
        blockerCommand.execute(commandContext);

        assertThat(commandContext.getState(), is(NO_ITEM));
        assertFalse(player.hasBomb());
    }

    @Test
    public void should_set_blocker_when_player_have_blocker() {
        Map map = mock(Map.class);
        commandContext.setMap(map);
        commandContext.setLocation(-10);

        blockerCommand.execute(commandContext);

        assertThat(commandContext.getState(), is(SUCCESS));
        assertTrue(player.hasBomb());
    }
}
