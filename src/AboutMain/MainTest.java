package AboutMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Tools.CommandParser;
import Tools.ParsedCommand;

/*
Тут я буду восоздавать Main здорового человека
*/

public class MainTest {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while(true) {
                System.out.print("> ");
                String input = br.readLine();
                if (input.strip().equals("exit")) break;
                
                ParsedCommand command = CommandParser.parse(input);
                if (command != null) {
                    execute(command);
                }
            }
        } catch (IOException e) {
            System.out.println("Критическая ошибка " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void execute(ParsedCommand cmd) {
        System.out.println("[Лог] Вызвана команда: " + cmd.name());
        System.out.println("[Лог] Вызвано аргументов: " + cmd.args().length);

        System.out.print("[Лог] Список аргументов: ");
        if (cmd.args().length == 0) System.out.println("null");
        for (String m : cmd.args()) {
            System.out.print("'" + m + "'" + " ");
            if (m == cmd.args()[cmd.args().length - 1]) System.out.println();
        }
    }

}
