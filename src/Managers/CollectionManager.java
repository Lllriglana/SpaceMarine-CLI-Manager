package Managers;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import Exception.ValidationException;
import Model.SpaceMarine;

public class CollectionManager {
    private final List<SpaceMarine> collection = new LinkedList<>();;
    private final ZonedDateTime initTime = ZonedDateTime.now();
    private int nextId = 1;

    public CollectionManager() {}

    public synchronized void add(SpaceMarine m) {
        if (m.getId() <= 0) {
            m.setId(nextId++);
        } else {
            m.setId(nextId);
            if (m.getId() >= nextId) nextId = m.getId() + 1;
        }
        collection.add(m);
    }

    public synchronized void addWithId(SpaceMarine m, int id) {
        m.setId(id);
        collection.add(m);
    }

    public synchronized List<SpaceMarine> getAll() {
        return new LinkedList<>(collection);
    }

    public synchronized void clearAll() {
        collection.clear();
    }

    public synchronized boolean removeById(int id) {
        for (SpaceMarine m : collection) {
            if (m.getId() == id) {
                collection.remove(m);
            }
            return true;
        }
        return false;
    }

    public void shuffle() {
        Collections.shuffle(collection);
    }

    public synchronized void syncNextId() {
        int max = collection.stream().mapToInt(SpaceMarine::getId).max().orElse(0);
        nextId = Math.max(nextId, max + 1);
    }
}

