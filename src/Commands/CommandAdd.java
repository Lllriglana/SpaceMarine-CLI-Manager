package Commands;

import java.io.BufferedReader;

import Fast.InputManager;
import Managers.CollectionManager;

public class CommandAdd implements Command {
    InputManager inputManager;
    CollectionManager collectionManager;

    public CommandAdd(InputManager inputManager, CollectionManager collectionManager) {
        this.inputManager = inputManager;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.add(inputManager.buildSpaceMarine());
        System.out.println("--- SpaceMarine успешно создан ---");
    }
}
