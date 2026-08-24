package Commands;

import java.util.Queue;

import Managers.CommandManager;
import Managers.FileManager;
import Tools.CommandParser;
import Tools.ParsedCommand;

public class CommandExecuteScript implements Command {
    FileManager fileManager;
    CommandManager commandManager;

    public CommandExecuteScript(FileManager fileManager, CommandManager commandManager){
        this.fileManager = fileManager;
        this.commandManager = commandManager;
    }

    @Override
    public void execute(String[] args) {

        Queue<String> queue = fileManager.readFile(args[0]);
        String line;
        while ((line = queue.poll()) != null) {
            if (line.isBlank()) continue;
            ParsedCommand pc = CommandParser.parse(line);
            if (pc == null) continue;
            commandManager.executeCommand(pc.name(), pc.args());
        }
    }
}
