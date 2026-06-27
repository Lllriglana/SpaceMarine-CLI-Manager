import Model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Commands.CommandHelp;
import Exception.ValidationException;
import Managers.CollectionManager;

public class Main {
    public static void main(String[] args) throws IOException, ValidationException {
        CollectionManager marine = new CollectionManager();
        CommandHelp help = new CommandHelp();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = ""; 
        
        System.out.println("Введите help, чтобы получить список доступных команд");

        while(true) {
            System.out.print("> ");
            try {
                input = br.readLine().trim();
            } catch (NumberFormatException e) {
                System.out.println("Не правильный формат ввода");
            }

            if ("exit".equals(input)) { break; }

            switch(input) {
                case "help":
                    help.help();
                break;
                case "add":
                    // в начале каждой команды можно её кидать в массив history
                    int a1 = 0;
                    System.out.print("Name: ");
                    String a2 = br.readLine().trim();
                    System.out.print("X: ");
                    double a3 = Double.parseDouble(br.readLine().trim());
                    System.out.print("Y: ");
                    float a4 = Float.parseFloat(br.readLine().trim());
                    System.out.print("Health: ");
                    double a5 = Double.parseDouble(br.readLine().trim());
                    System.out.print("Chapter name: ");
                    String a6 = br.readLine().trim();
                    System.out.print("MarinesCount: ");
                    int a7 = Integer.parseInt(br.readLine().trim());

                    marine.add(new SpaceMarine(a1, a2, a3, a4, a5, a6, a7));
                    break;
                case "show":
                    marine.show();
                    break;
                case "remove_by_id":
                    System.out.print("Введите id: ");
                    int remID = Integer.parseInt(br.readLine());
                    marine.remove_by_id(remID);
                    break;
                case "update id":
                    System.out.print("Введите id: ");
                    int upID = Integer.parseInt(br.readLine());
                    marine.updateId(upID);

                    // add, но нужно инкапсуляцию реализовать :)

                    break;
                default:
                    break;
            }
        }
        br.close();
    }
}


