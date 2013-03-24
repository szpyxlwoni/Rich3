package org.rich.command;

import org.rich.map.Map;
import org.rich.player.Players;

public interface Command {
    void execute(Players players, Map map);
}
