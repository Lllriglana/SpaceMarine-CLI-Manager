package Commands;

import java.util.Queue;

import Managers.HistoryManager;

public class CommandHistory implements Command {
    HistoryManager historyManager;

    public CommandHistory(HistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    @Override 
    public void execute(String[] args) {
        Queue<String> historyCommands = historyManager.getHistory();
        if (historyCommands.isEmpty()) {
            System.out.println("Список команд пуст");
        } else System.out.println("Список команд: \n" + historyCommands);
    }
}
