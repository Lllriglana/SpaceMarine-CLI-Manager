package Commands;

import Fast.InputManager;
import Managers.CollectionManager;

public class CommandShow implements Command {
    InputManager inputManager;
    CollectionManager collectionManager;

    public CommandShow(InputManager inputManager, CollectionManager collectionManager) {
        this.inputManager = inputManager;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        System.out.println(collectionManager.getAll());
    }
}
