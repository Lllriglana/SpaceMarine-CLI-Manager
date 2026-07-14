package Commands;

import Managers.CollectionManager;
import Managers.InputManager;

public class CommandShuffle implements Command {
    InputManager inputManager;
    CollectionManager collectionManager;

    public CommandShuffle(InputManager inputManager, CollectionManager collectionManager) {
        this.inputManager = inputManager;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.shuffle();
        System.out.println("Элементы коллекции перемешаны.");
    }
}