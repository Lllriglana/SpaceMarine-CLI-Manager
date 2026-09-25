package Commands;

import java.util.List;

import Managers.EnumManager;
import Model.SpaceMarine;
import Model.Weapon;

public class CommandFilterByWeaponType implements Command {
    private EnumManager enumManager;

    public CommandFilterByWeaponType(EnumManager enumManager) {
        this.enumManager = enumManager;
    }

    @Override
    public void execute(String[] args) {
        try {
            Weapon weapon = Model.Weapon.valueOf(args[0].toUpperCase());
            List<SpaceMarine> marines = enumManager.filterByWeaponType(weapon);
            if (marines != null) {
                System.out.println(marines);
            } else {
                System.out.println("Список элементов с weaponType = '" + weapon + "' пуст");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: такой категории не существует. Доступны варианты из списка: MELTAGUN, COMBI_FLAMER, GRENADE_LAUNCHER.");
        }
        
    }
}
