package org.rich.command;

import org.rich.map.Map;
import org.rich.player.Players;

import java.io.InputStream;
import java.util.Scanner;

public interface Command {
    void execute(Players players, Map map, Scanner input);
}
