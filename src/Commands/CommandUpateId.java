package Commands;

import Managers.CollectionManager;
import Managers.InputManager;

public class CommandUpateId implements Command{
    CollectionManager collectionManager;
    InputManager inputManager;

    public CommandUpateId(InputManager inputManager, CollectionManager collectionManager) {
        this.inputManager = inputManager;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        int id = Integer.parseInt(args[0]);
        boolean flag = collectionManager.removeById(id);

        if (!flag) {
            System.out.println("Элемент id=" + id + " не найден.");
            return;
        }

        System.out.println("Обновление элемента c id: " + id);
        collectionManager.addWithId(inputManager.buildSpaceMarine(), id);
        System.out.println("Обновление прошло успешно.");
    }
}
