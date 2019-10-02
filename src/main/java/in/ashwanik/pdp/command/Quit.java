package in.ashwanik.pdp.command;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Quit extends Command {

    Quit(String name,
         String info) {
        super(name, info);
    }

    @Override
    void execute(String[] arguments) {
        log.info("Quit");
    }
}
