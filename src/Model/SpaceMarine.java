package Model;

import java.time.LocalDate;

import Exception.ValidationException;
import Tools.Validator;

public class SpaceMarine implements Comparable {
    private int id;
    private String name;
    private Coordinates coordinates;
    private LocalDate creationDate;
    private double health;
    private AstartesCategory category;
    private Weapon weapon;
    private MeleeWeapon meleeWeapon;
    private Chapter chapter;

    public SpaceMarine(
        int id,
        String name,
        Coordinates coordinates,
        LocalDate creationDate,
        double health,
        AstartesCategory category,
        Weapon weapon,
        MeleeWeapon meleeWeapon,
        Chapter chapter
    ) throws ValidationException {
        this.id = Validator.requireValidId(id);
        this.name = Validator.requireSpecial(name, "Name");
        this.coordinates = Validator.requireSpecial(coordinates, "Coordinates");
        this.creationDate = Validator.requireSpecial(creationDate, "Creation Date");
        this.health = Validator.healthRequireGreaterThanZero(health, "Health");
        this.category = category;
        this.weapon = weapon;
        this.meleeWeapon = meleeWeapon;
        this.chapter = Validator.requireSpecial(chapter, "Chapter");
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public double getHealth() {
        return health;
    }

    public AstartesCategory getCategory() {
        return category;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public Chapter getChapter() {
        return chapter;
    }

    @Override
    public String toString() {
        return "SpaceMarine [id=" + id + ", name=" + name + ", coordinates=" + coordinates + ", creationDate="
                + creationDate + ", healh=" + health + ", category=" + category + ", weapon=" + weapon + ", meleeWeapon="
                + meleeWeapon + ", chapter=" + chapter + "]";
    }

    // TODO: переопредели ть самому, узнать требуется ли знание в интерпрайсе\
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((coordinates == null) ? 0 : coordinates.hashCode());
        result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
        long temp;
        temp = Double.doubleToLongBits(health);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((weapon == null) ? 0 : weapon.hashCode());
        result = prime * result + ((meleeWeapon == null) ? 0 : meleeWeapon.hashCode());
        result = prime * result + ((chapter == null) ? 0 : chapter.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SpaceMarine other = (SpaceMarine) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (coordinates == null) {
            if (other.coordinates != null)
                return false;
        } else if (!coordinates.equals(other.coordinates))
            return false;
        if (creationDate == null) {
            if (other.creationDate != null)
                return false;
        } else if (!creationDate.equals(other.creationDate))
            return false;
        if (Double.doubleToLongBits(health) != Double.doubleToLongBits(other.health))
            return false;
        if (category != other.category)
            return false;
        if (weapon != other.weapon)
            return false;
        if (meleeWeapon != other.meleeWeapon)
            return false;
        if (chapter == null) {
            if (other.chapter != null)
                return false;
        } else if (!chapter.equals(other.chapter))
            return false;
        return true;
    }

    // TODO: Вспомнить как переопределять
    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
    
}
