package Managers;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import Model.SpaceMarine;

public class CollectionManager {
    private final List<SpaceMarine> collecton;
    private final ZonedDateTime initTime;
    
    public CollectionManager() {
        this.collecton = new LinkedList<SpaceMarine>();
        this.initTime = ZonedDateTime.now();
    }

    public synchronized void add(SpaceMarine marine) {
        collecton.add(marine);
    }

    public void shuffle() {
        Collections.shuffle(collecton);
    }

    public int generateId() {
        if (collecton.isEmpty()) {
            return 1;
        }
        
        int maxId = 0;
        
        for (SpaceMarine marine : collecton) {
            if (marine.getId() > maxId) {
                maxId = marine.getId();
            }
        }
        return maxId + 1;
    }
}
