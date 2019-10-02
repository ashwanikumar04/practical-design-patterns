package in.ashwanik.pdp.command;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

class CommandList {
    private static CommandList list;
    private final Map<String, Command> commandsMap = new LinkedHashMap<>();

    private CommandList() {
    }

    static CommandList get() {
        if (Objects.isNull(list)) {
            throw new IllegalStateException("Command list is not initialized");
        }
        return list;
    }

    static void initCommands() {
        CommandList commandList = new CommandList();
        commandList.addCommand(new New("new", "Start a new game"));
        commandList.addCommand(new Start("start", "Start the game"));
        commandList.addCommand(new Help("help", "Lists all the supported commands"));
        commandList.addCommand(new Quit("quit", "Quit the game"));
        list = commandList;
    }

    static Command getHelp() {
        return get().getCommand("help");
    }

    Command getCommand(String token) {
        return commandsMap.get(token.toLowerCase(Locale.ENGLISH));
    }

    private void addCommand(Command command) {
        String name = command.getDescription().getName().toLowerCase(Locale.ENGLISH);
        if (commandsMap.containsKey(name)) {
            throw new IllegalArgumentException("Tried to add '" + name + "' multiple times.");
        }
        commandsMap.put(name, command);
    }

    List<CommandDetail> getCommands() {
        List<CommandDetail> details = new ArrayList<>(commandsMap.size());
        for (Command command : commandsMap.values()) {
            details.add(command.getDescription());
        }
        return details;
    }
}
