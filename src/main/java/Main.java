import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Commands.CommandAdd;
import Commands.CommandAddIfMin;
import Commands.CommandClear;
import Commands.CommandExecuteScript;
import Commands.CommandExit;
import Commands.CommandHelp;
import Commands.CommandHistory;
import Commands.CommandInfo;
import Commands.CommandRemoveById;
import Commands.CommandSave;
import Commands.CommandShow;
import Commands.CommandShuffle;
import Commands.CommandUpateId;
import Managers.CollectionManager;
import Managers.CommandManager; // местный инвокер
import Managers.FileManager;
import Managers.HistoryManager;
import Managers.InputManager;
import Managers.JsonManager;
import Tools.CommandParser;
import Tools.ParsedCommand;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            HistoryManager historyManager = new HistoryManager();
            CommandManager commandManager = new CommandManager(historyManager);
            InputManager inputManager = new InputManager(br);
            CollectionManager collectionManager = new CollectionManager();
            FileManager fileManager = new FileManager();
            JsonManager jsonManager = new JsonManager(collectionManager, br);

            System.out.println("Система готова. Введите 'help' для получения списка доступных команд.");
            commandManager.register("help", new CommandHelp());
            commandManager.register("exit", new CommandExit());
            commandManager.register("add", new CommandAdd(inputManager, collectionManager));
            commandManager.register("show", new CommandShow(inputManager, collectionManager));
            commandManager.register("shuffle", new CommandShuffle(inputManager, collectionManager));
            commandManager.register("clear", new CommandClear(collectionManager));
            commandManager.register("remove_by_id", new CommandRemoveById(collectionManager));
            commandManager.register("update", new CommandUpateId(inputManager, collectionManager));
            commandManager.register("add_if_min", new CommandAddIfMin(inputManager, collectionManager));
            commandManager.register("execute_script", new CommandExecuteScript(fileManager, commandManager));
            commandManager.register("info", new CommandInfo(collectionManager));
            commandManager.register("history", new CommandHistory(historyManager));
            commandManager.register("save", new CommandSave(jsonManager));
                        
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