package Managers;

import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

import Model.SpaceMarine;

public class CollectionManager {
    private final List<SpaceMarine> list;
    private final ZonedDateTime initTime;
    private int nextId;
    
    public CollectionManager() {
        this.list = new LinkedList<SpaceMarine>();
        this.initTime = ZonedDateTime.now();
        nextId = 1;
    }

    public synchronized void add(SpaceMarine marine) {
        marine.setId(generateId());
        list.add(marine);
    }

    public int generateId() {
        return nextId++;
    }

    public void show() {
        System.out.println(list);
    }

    public void updateId(int tempID) {
        remove_by_id(tempID);
        // буду в main делать
    }

    public void remove_by_id(int tempID) {
        for (SpaceMarine num : list) {
            if (num.getId() == tempID) {
                list.remove(tempID - 1);
                break;
            }
        };
    }

    @Override // не обязательная штука, но лан
    public String toString() {
        return list.toString();
    }
}
