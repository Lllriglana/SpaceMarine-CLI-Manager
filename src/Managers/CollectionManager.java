package Managers;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import Model.SpaceMarine;

public class CollectionManager {
    private final List<SpaceMarine> collection = new LinkedList<>();;
    private final String dateTime = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("d MMMM yyyy'г. в' HH:mm (z)", new Locale("ru")));
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
        }
        return false;
    }

    public synchronized void shuffle() {
        Collections.shuffle(collection);
    }

    public synchronized void info() {
        System.out.println("Информация о коллекции \nТип коллекции: " + collection.getClass().getSimpleName() + "\nДата инициализации: " +  dateTime + "\nКоличество элементов: " + collection.size());
    }

    public synchronized void syncNextId() {
        int max = collection.stream().mapToInt(SpaceMarine::getId).max().orElse(0);
        nextId = Math.max(nextId, max + 1);
    }
}

