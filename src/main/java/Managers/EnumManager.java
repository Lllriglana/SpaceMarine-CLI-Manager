package Managers;

import java.util.LinkedList;
import java.util.List;

import Model.AstartesCategory;
import Model.SpaceMarine;
import Model.Weapon;

public class EnumManager {
    private CollectionManager collectionManager;

    public EnumManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
    
    public List<SpaceMarine> filterByWeaponType(Weapon weapon) {
        List<SpaceMarine> marines = new LinkedList<>();
        for (SpaceMarine marine : collectionManager.getAll()) {
            if (marine.getWeapon() == weapon) {
                marines.add(marine);
            }
        }
        if (!marines.isEmpty()) {
            return marines;
        } else {
            return null;
        }
    }

    public List<String> uniqueAstartesCategory() {
        List<String> marinesEnum = new LinkedList<>();

        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;

        for (SpaceMarine marine : collectionManager.getAll()) {
            if (marine.getCategory() == null) {
                continue;
            }
            switch (marine.getCategory()) {
                case SCOUT:
                    flag1 = true;
                    break;
                case INCEPTOR:
                    flag2 = true;
                    break;
                case TERMINATOR:
                    flag3 = true;
                    break;
                case LIBRARIAN:
                    flag4 = true;
                    break;
                case CHAPLAIN:
                    flag5 = true;
                    break;
                default:
                    break;
            }
            if (flag1 && flag2 && flag3 && flag4 && flag5) {
                break;
            }
        }

        if (flag1) marinesEnum.add(AstartesCategory.values()[0].name());
        if (flag2) marinesEnum.add(AstartesCategory.values()[1].name()); 
        if (flag3) marinesEnum.add(AstartesCategory.values()[2].name()); 
        if (flag4) marinesEnum.add(AstartesCategory.values()[3].name()); 
        if (flag5) marinesEnum.add(AstartesCategory.values()[4].name()); 

        if (!marinesEnum.isEmpty()) {
            return marinesEnum;
        } else {
            return null;
        }
        
    }

    
}