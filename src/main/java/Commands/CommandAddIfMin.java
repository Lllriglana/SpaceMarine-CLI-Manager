package Commands;

import java.util.List;

import Managers.CollectionManager;
import Managers.InputManager;
import Model.SpaceMarine;

public class CommandAddIfMin implements Command {
    InputManager inputManager;
    CollectionManager collectionManager;

    public CommandAddIfMin(InputManager inputManager, CollectionManager collectionManager) {
        this.inputManager = inputManager;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        SpaceMarine newMarine = inputManager.buildSpaceMarine();
        
        List<SpaceMarine> list = collectionManager.getAll();
        
        if (list.isEmpty()) {
            collectionManager.add(newMarine);
            System.out.println("Элемент добавлен");
            return;
        }
        
        SpaceMarine min = list.get(0);
        for (SpaceMarine now : list) {
            if (now.compareTo(min) < 0) min = now; 
        }

        if (newMarine.compareTo(min) < 0) {
            collectionManager.add(newMarine);
            System.out.println("Элемент меньше минимального, добавлен.");
        } else {
            System.out.println("Элемент не меньше минимального, не добавлен.");
        }
    }
}
