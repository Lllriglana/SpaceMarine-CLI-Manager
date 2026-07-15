package Commands;

import Managers.CollectionManager;

public class CommandClear implements Command{
    CollectionManager collectionManager;

    public CommandClear(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.clearAll();
        System.out.println("Коллекция очищена.");
    }
}
