package in.ashwanik.pdp.behavioral.command;

import lombok.Getter;

class Game {
    @Getter
    private boolean started;

    Game() {
        CommandList.initCommands();
    }

    public void help() {
        CommandExecutor.execute(new IssuedCommand("help"));
    }

    public void newGame() {
        CommandExecutor.execute(new IssuedCommand("new").addToken("test_game"));
    }

    public void start() {
        CommandExecutor.execute(new IssuedCommand("start"));
        this.started = true;
    }

    public void quit() {
        CommandExecutor.execute(new IssuedCommand("quit"));
        this.started = false;
    }
}
