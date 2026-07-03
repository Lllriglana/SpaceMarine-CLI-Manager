package Managers;

import java.util.HashMap;
import java.util.Map;
import Commands.Command;

public class Invoker {
    private final Map<String, Command> commandBox = new HashMap<>();

    public void register(String commandName, Command command) {
        commandBox.put(commandName, command);
    }

    public void executeCommand(String commandName, String[] args) {
        Command command = commandBox.get(commandName);

        if (command == null) {
            System.out.println("Ошибка: команда '" + commandName + "' не найдена. Введите help для получения возможных команд.");
            return;
        }

        try {
            command.execute(args);
        } catch (Exception e) {
            System.out.println("Произошла ошибка при выполнении " + e.getMessage());
        }
    }

    public Map<String, Command> getCommands() {
        return commandBox;
    }
}
