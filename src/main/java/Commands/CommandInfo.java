package Commands;

import Managers.CollectionManager;

public class CommandInfo implements Command {
    CollectionManager collectionManager;

    public CommandInfo(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override 
    public void execute(String[] args) {
        collectionManager.info();
    }
}