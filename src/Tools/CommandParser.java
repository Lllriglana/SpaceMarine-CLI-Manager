package Tools;

import java.util.Arrays;

public class CommandParser {
    private CommandParser() {}

    public static ParsedCommand parse(String input) {
        if (input == null || input.isBlank()) {
            return null;
        }

        String[] tokens = input.strip().split("\\s+");
        String commandName = tokens[0];
        String[] commandArgs = Arrays.copyOfRange(tokens, 1, tokens.length);

        return new ParsedCommand(commandName, commandArgs);
    }
}
