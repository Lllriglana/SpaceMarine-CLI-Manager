package Commands;

import Managers.EnumManager;
import Model.Weapon;

public class CommandCountLessThanWeaponType implements Command {
    EnumManager enumManager;

    public CommandCountLessThanWeaponType(EnumManager enumManager) {
        this.enumManager = enumManager;
    }

    @Override
    public void execute(String[] args) {
        if (args == null || args.length == 0 || args[0].isBlank()) {
            System.out.println("Ошбибка: укажите тип оружия.");
            return;
        }
        
        try {
            Weapon weapon = Model.Weapon.valueOf(args[0].toUpperCase());

            Integer counter = enumManager.countLessThanWeaponType(weapon);

            if (counter == null) {
                System.out.println("Коллекция пуста.");
            } else if (counter == 0) {
                System.out.println("Количество бойцов, значение поля weaponType которых меньше '" + weapon + "' не найдено.");
            } else {
                System.out.println("Количество бойцов, значение поля weaponType которых меньше '" + weapon + "': " + counter + " единиц.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: такой категории не существует. Доступны варианты из списка: MELTAGUN, COMBI_FLAMER, GRENADE_LAUNCHER.");
        }
    }
}
