package org.rich.command;

import org.rich.util.CommandContext;

public interface Command {
    CommandContext execute(CommandContext commandContext);
}
