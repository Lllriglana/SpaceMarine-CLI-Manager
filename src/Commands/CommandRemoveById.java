package Commands;

import Managers.CollectionManager;

public class CommandRemoveById implements Command {
    CollectionManager collectionManager;

    public CommandRemoveById(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        int id = Integer.parseInt(args[0]);
        collectionManager.removeById(id);
        System.out.println("Объект с id='" + id + "' удален.");
    }
}
