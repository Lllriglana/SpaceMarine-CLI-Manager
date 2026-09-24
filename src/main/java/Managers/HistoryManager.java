package Managers;

import java.util.ArrayDeque;
import java.util.Queue;

public class HistoryManager {
    private Queue<String> historyCommands = new ArrayDeque<>();

    public void add(String command) {
        if (historyCommands.size() == 6) {
            historyCommands.poll();
        }
        historyCommands.offer(command);
    }

    public ArrayDeque<String> getHistory() {
        return new ArrayDeque<>(historyCommands);
    }
}
