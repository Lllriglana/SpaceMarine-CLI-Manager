package Commands;

import java.io.BufferedReader;

import Managers.CollectionManager;
import Managers.InputManager;

public class CommandAdd implements Command {
    InputManager inputManager;
    CollectionManager collectionManager;

    public CommandAdd(InputManager inputManager, CollectionManager collectionManager) {
        this.inputManager = inputManager;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        System.out.println("--- Создание нового SpaceMarine ---");
        collectionManager.add(inputManager.buildSpaceMarine());
        System.out.println("--- SpaceMarine успешно создан ---");
    }
}
