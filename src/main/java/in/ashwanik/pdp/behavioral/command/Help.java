package in.ashwanik.pdp.behavioral.command;


import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
class Help extends Command {

    Help(String name,
         String info) {
        super(name, info);
    }

    @Override
    void execute(String[] arguments) {
        List<CommandDetail> commandDetails = CommandList.get().getCommands();
        for (CommandDetail commandDetail : commandDetails) {
            log.info(commandDetail.toString());
        }
    }
}
