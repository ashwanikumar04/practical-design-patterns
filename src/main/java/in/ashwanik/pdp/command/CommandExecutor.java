package in.ashwanik.pdp.command;


import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

class CommandExecutor {

    private static Command getCommand(IssuedCommand issuedCommand) {
        Command command = CommandList.get().getCommand(issuedCommand.getCommand());
        if (Objects.isNull(command)) {
            return CommandList.getHelp();
        } else {
            return command;
        }
    }

    static void execute(IssuedCommand issuedCommand) {
        if (!StringUtils.isBlank(issuedCommand.getCommand())) {
            Command command = getCommand(issuedCommand);
            command.execute(issuedCommand.getArgs());
        }
    }
}
