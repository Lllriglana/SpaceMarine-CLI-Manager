package Model;

import java.time.LocalDate;

import Exception.ValidationException;
import Tools.Validator;

public class SpaceMarine {
    private int id;
    private String name;
    private Coordinates coordinates = new Coordinates();
    private LocalDate creationDate;
    private double healh;
    private AstartesCategory category;
    private Weapon weapon;
    private MeleeWeapon meleeWeapon;
    private Chapter chapter = new Chapter();

    public SpaceMarine(
        int id,
        String name,
        Coordinates coordinates,
        LocalDate creationDate,
        double healh,
        AstartesCategory category,
        Weapon weapon,
        MeleeWeapon meleeWeapon,
        Chapter chapter
    ) throws ValidationException {
        this.id = Validator.requireValidId(id);
        this.name = Validator.requireSpecial(name, "Name");
        this.coordinates = Validator.requireSpecial(coordinates, "Coordinates");
        this.creationDate = Validator.requireSpecial(creationDate, "Creation Date");
        this.healh = Validator.healhRequireGreaterThanZero(healh, "Healh");
        this.category = category;
        this.weapon = weapon;
        this.meleeWeapon = meleeWeapon;
        this.chapter = Validator.requireSpecial(chapter, "Chapter");
    }
    
     
}
