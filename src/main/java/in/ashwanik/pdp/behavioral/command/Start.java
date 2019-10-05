package in.ashwanik.pdp.behavioral.command;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Start extends Command {

    Start(String name,
          String info) {
        super(name, info);
    }

    @Override
    void execute(String[] arguments) {
        log.info("Game started");
    }
}
