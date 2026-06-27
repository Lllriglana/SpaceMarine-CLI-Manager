package NewMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Tools.CommandParser;
import Tools.ParsedCommand;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while(true) {
                System.out.print("> ");
                String input = br.readLine();
                if(input.strip().equals("exit")) break;

                ParsedCommand command = CommandParser.parse(input);

                // Создать инвокер класс который будет держать ключи всех комманд
            }
        } catch (IOException e) {
                System.out.println("Критическая ошибка " + e.getMessage());
        }

    }
}
