package Commands;

public interface Command {
    /**
     * Выполняет логику команды.
     * @param args Массив аргументов (может быть пустым, если команда одиночная)
     */
    void execute(String[] args);
}
