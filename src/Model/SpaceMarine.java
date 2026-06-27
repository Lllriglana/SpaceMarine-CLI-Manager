package Model;

import Exception.ValidationException;
import Tools.Validation;

public class SpaceMarine {
    private int id;
    private String name;
    Coordinates coordinates = new Coordinates();
    private double health;
    private AstartesCategory astartesCategory;
    private Weapon weapon;
    private MeleeWeapon meleeWeapon;
    Chapter chapter = new Chapter();
    double s1;
    float s2;
    String c1;
    int c2;

    public SpaceMarine() {}
    public SpaceMarine(
            int id, 
            String name, 
            double s1, 
            float s2, 
            double health, 
            AstartesCategory astartesCategory, 
            Weapon weapon, 
            MeleeWeapon meleeWeapon, 
            String c1, 
            int c2
    ) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.astartesCategory = astartesCategory;
        this.weapon = weapon;
        this.meleeWeapon = meleeWeapon;
        this.coordinates.setX(s1);
        this.s1 = s1;
        this.coordinates.setY(s2);
        this.s2 = s2;
        this.chapter.setName(c1);
        this.c1 = c1;
        this.chapter.setMarinesCount(c2);
        this.c2 = c2;
    }

    public SpaceMarine(
            int id, 
            String name, 
            double s1, 
            float s2, 
            double health, 
            String c1, 
            int c2
    ) throws ValidationException {
        this.id = id;
        this.name = Validation.validNull(name, "name");
        this.health = health;
        this.coordinates.setX(s1);
        this.s1 = s1;
        this.coordinates.setY(s2);
        this.s2 = s2;
        this.chapter.setName(c1);
        this.c1 = c1;
        this.chapter.setMarinesCount(c2);
        this.c2 = c2;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public AstartesCategory getAstartesCategory() {
        return astartesCategory;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public double getS1() {
        return s1;
    }

    public float getS2() {
        return s2;
    }

    public String getC1() {
        return c1;
    }

    public int getC2() {
        return c2;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setCoordinates(double X, float Y) {
        try {
            coordinates.setX(X);
            coordinates.setY(Y);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Напортачил с файлами");
        }
    }

    public void setHealth(double health) {
        if (health > 0) 
            this.health = health;
        else 
            System.out.println("Нельзя");
    }

    public void setAstartesCategory(AstartesCategory astartesCategory) {
        System.out.println("Возможные варианты: SCOUT, INCEPTOR, TERMINATOR, LIBRARIAN, CHAPLAIN");
        this.astartesCategory = astartesCategory;
    }

    public void setWeapon(Weapon weapon) {
        System.out.println("Возможные варианты: MELTAGUN, COMBI_FLAMER, GRENADE_LAUNCHER");
        this.weapon = weapon;
    }

    public void setMeleeWeapon(MeleeWeapon meleeWeapon) {
        System.out.println("Возможные варианты: CHAIN_AXE, LIGHTING_CLAW, POWER_BLADE, POWER_FIST");
        this.meleeWeapon = meleeWeapon;
    }

    public void setChapter(String name, int marinesCount) {
        try {
            chapter.setMarinesCount(marinesCount);
            chapter.setName(name);

        } catch (Exception e) {
            System.out.println("Напортачил с файлами");
            e.printStackTrace();
        }
    }

    /* Можно попробовать сделать ввод прямо из этого места */
    public void inputManager() {
        
    }

    @Override
    public String toString() {
        return "[ ID=" + id + ", NMAE=" + name + ", HEALTH=" + health + ", COORDINATES=" + coordinates.toString() + ", CHAPTER=" + chapter.toString() + " ]";
        // сеттер для координат 
    }
}
