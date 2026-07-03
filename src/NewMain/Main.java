package NewMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Commands.CommandExit;
import Commands.CommandHelp;
import Managers.Invoker;
import Tools.CommandParser;
import Tools.ParsedCommand;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Invoker invoker = new Invoker();
            System.out.println("Система готова. Введите 'help' для получения списка доступных команд.");
            invoker.register("help", new CommandHelp());
            invoker.register("exit", new CommandExit());
            while(true) {
                System.out.print("> ");
                String input = br.readLine();

                if (input == null) break;
                if (input.isBlank()) continue;
                
                ParsedCommand command = CommandParser.parse(input);
                invoker.executeCommand(command.name(), command.args());
            }
        } catch (IOException e) {
                System.out.println("Критическая ошибка " + e.getMessage());
        }

    }
}
