package in.ashwanik.pdp.behavioral.command;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class New extends Command {

    New(String name,
        String info) {
        super(name, info);
    }

    @Override
    void execute(String[] arguments) {
        log.info("New game created: " + arguments[0]);
    }
}
