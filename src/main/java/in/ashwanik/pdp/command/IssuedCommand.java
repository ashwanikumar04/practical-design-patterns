package in.ashwanik.pdp.command;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

class IssuedCommand {
    private final String stringRepresentation;
    private final List<String> tokens;

    IssuedCommand(String issuedCommand) {
        this.stringRepresentation = issuedCommand;
        this.tokens = new ArrayList<>();
    }

    IssuedCommand addToken(String token) {
        tokens.add(token);
        return this;
    }

    public String getCommand() {
        return CollectionUtils.isEmpty(tokens) ? "" : tokens.get(0);
    }

    String[] getArgs() {
        if (CollectionUtils.isEmpty(tokens)) {
            return new String[0];
        } else {
            String[] tokenArray = tokens.toArray(new String[tokens.size()]);
            int argumentCount = tokens.size() - 1;
            String[] arguments = new String[tokens.size() - 1];
            System.arraycopy(tokenArray, 1, arguments, 0, argumentCount);
            return arguments;
        }
    }
}
