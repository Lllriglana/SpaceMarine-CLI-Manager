package Tools;

import java.util.Arrays;

public class CommandParser {
    private CommandParser() {}

    public static ParsedCommand parse(String input) {
        if (input == null || input.isBlank()) {
            return null;
        }

        String[] token = input.strip().split("\\s+");
        String commandName = token[0];
        String[] commandArgs = Arrays.copyOfRange(token, 1, token.length);

        return new ParsedCommand(commandName, commandArgs);
    }
}
