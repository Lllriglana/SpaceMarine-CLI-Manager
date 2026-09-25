package Commands;

import java.util.List;

import Managers.EnumManager;

public class CommandPrintUniqueCategory implements Command {
    private EnumManager enumManager;

    public CommandPrintUniqueCategory(EnumManager enumManager) {
        this.enumManager = enumManager;
    }

    @Override
    public void execute(String[] args) {
        List<String> enumList = enumManager.uniqueAstartesCategory();
        if (enumList != null) {
            System.out.println(enumList);
        } else {
            System.out.println("Не найдено бойцов с категорией");
        }
    }
}
