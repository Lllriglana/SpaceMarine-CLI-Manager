package Commands;

import Managers.JsonManager;

public class CommandSave implements Command {
    JsonManager jsonManager;

    public CommandSave(JsonManager jsonManager) {
        this.jsonManager = jsonManager;
    }

    @Override
    public void execute(String[] args) {
        jsonManager.save();
    }
}
