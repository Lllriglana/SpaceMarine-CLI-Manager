package Managers;
    
import java.io.BufferedReader;
import java.io.IOException;


import Exception.ValidationException;
import Model.AstartesCategory;
import Model.Chapter;
import Model.Coordinates;
import Model.MeleeWeapon;
import Model.SpaceMarine;
import Model.Weapon;
import Tools.Validator;

public class InputManager {
    private final BufferedReader br; // TODO: нада узнать нужно ли закрывать ресурс

    public InputManager(BufferedReader br) {
        this.br = br;
    }

    public SpaceMarine buildSpaceMarine() {
        System.out.println("--- Создание нового SpaceMarine ---");

        String Name = askName();
        Coordinates coordinates = askCoordinates();
        Double health = askHealth();
        AstartesCategory astartesCategory = askСategory();
        Weapon weapon = askWeaponType();
        MeleeWeapon meleeWeapon = askMeleeWeapon();
        Chapter chapter = askChapter();
        try {
            return new SpaceMarine(1, Name, coordinates, null, health, astartesCategory, weapon, meleeWeapon, chapter); // TODO: id не проходит проверку сразу после рождения
        } catch (Exception e) {
            System.out.println("Критическая ошибка сборки: " + e.getMessage());
        }
        return null;
    }

    private String askName() {
        while (true) {
            try {
                System.out.print("Введите имя космодесантника: ");

                String inputName = br.readLine().trim();
                
                return Validator.notNull_String(inputName, "Имя");
            } catch (ValidationException e) {
               System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("Ошибка ввода");
            }
            
        }
    }

    private Coordinates askCoordinates() {
        while (true) {
            try {
                System.out.print("Введите координату X: ");
                Double inputX = Double.parseDouble(br.readLine().trim());

                System.out.print("Введите координату Y: ");
                Float inputY = Float.parseFloat(br.readLine().trim());
                
                return new Coordinates(inputX, inputY);
            } catch (NumberFormatException e) {
                System.out.println("Не верный формат ввода");
            } catch (ValidationException e) {
               System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("Ошибка ввода");
            }
            
        }
    }

    private Double askHealth() {
        while (true) {
            try {
                System.out.print("Введите кол-во здоровья: ");

                Double inputHealth = Double.parseDouble(br.readLine().trim());

                return Validator.healthRequireGreaterThanZero(inputHealth, "Здоровье");
            } catch (NumberFormatException e) {
                System.out.println("Не верный формат ввода");
            } catch (ValidationException e) {
               System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("Ошибка ввода");
            }
        }
    }

    private AstartesCategory askСategory() {
        while (true) {
            try {
                System.out.print("Введите категорию солдата(SCOUT, INCEPTOR, TERMINATOR, LIBRARIAN, CHAPLAIN): ");

                String inputСategory = br.readLine().trim();

                if (inputСategory.isBlank()) return null;
                return AstartesCategory.valueOf(inputСategory.toUpperCase()); // toUpperCase() - для строчного ввода
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: такой категории не существует. Выберите вариант из списка: SCOUT, INCEPTOR, TERMINATOR, LIBRARIAN, CHAPLAIN.");
            } catch (IOException e) {
                System.out.println("Ошибка ввода");
            }
        }
    }

    private Weapon askWeaponType() {
        while (true) {
            try {
                System.out.print("Введите тип орижия солдата(MELTAGUN, COMBI_FLAMER, GRENADE_LAUNCHER): ");

                String inputWeapon = br.readLine().trim();

                if (inputWeapon.isBlank()) return null;
                return Weapon.valueOf(inputWeapon.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: такой категории не существует. Выберите вариант из списка: MELTAGUN, COMBI_FLAMER, GRENADE_LAUNCHER.");
            } catch (IOException e) {
                System.out.println("Ошибка ввода");
            }
        }
    }

        private MeleeWeapon askMeleeWeapon() {
        while (true) {
            try {
                System.out.print("Введите тип орижия ближнего боя солдата(CHAIN_AXE, LIGHTING_CLAW, LIGHTING_CLAW, POWER_FIST): ");

                String inputMeleeWeapon = br.readLine().trim();

                if (inputMeleeWeapon.isBlank()) return null;
                return MeleeWeapon.valueOf(inputMeleeWeapon.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: такой категории не существует. Выберите вариант из списка: CHAIN_AXE, LIGHTING_CLAW, LIGHTING_CLAW, POWER_FIST.");
            } catch (IOException e) {
                System.out.println("Ошибка ввода");
            }
        }
    }

    private Chapter askChapter() {
        while (true) {
            try {
                System.out.print("Введите название ордена: ");
                String inputName = br.readLine();

                System.out.print("Общая численность братьев по оружию в этом ордене: ");
                int inputMarinesCount = Integer.parseInt(br.readLine());

                return new Chapter(inputName, inputMarinesCount);
            } catch (NumberFormatException e) {
                System.out.println("Не верный формат ввода");
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("Ошибка ввода");
            }
        }
    }


}

