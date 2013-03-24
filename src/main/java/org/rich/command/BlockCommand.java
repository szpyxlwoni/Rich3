package org.rich.command;

import org.rich.util.CommandContext;

import static org.rich.util.CommandContext.SUCCESS;

public class BlockCommand implements Command {
    @Override
    public CommandContext execute(CommandContext commandContext) {
        return commandContext;
    }
}
