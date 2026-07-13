import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Commands.CommandAdd;
import Commands.CommandExit;
import Commands.CommandHelp;
import Commands.CommandShow;
import Fast.InputManager;
import Managers.CollectionManager;
import Managers.CommandManager; // местный инвокер
import Tools.CommandParser;
import Tools.ParsedCommand;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            CommandManager commandManager = new CommandManager();
            InputManager inputManager = new InputManager(br);
            CollectionManager collectionManager = new CollectionManager();

            System.out.println("Система готова. Введите 'help' для получения списка доступных команд.");
            commandManager.register("help", new CommandHelp());
            commandManager.register("exit", new CommandExit());
            commandManager.register("add", new CommandAdd(inputManager, collectionManager));
            commandManager.register("show", new CommandShow(inputManager, collectionManager));
            while(true) {
                System.out.print("> ");
                String input = br.readLine();

                if (input == null) break;
                if (input.isBlank()) continue;
                
                ParsedCommand command = CommandParser.parse(input);
                commandManager.executeCommand(command.name(), command.args());
            }
        } catch (IOException e) {
                System.out.println("Критическая ошибка " + e.getMessage());
        }

    }
}
