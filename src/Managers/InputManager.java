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
    private final BufferedReader br;

    public InputManager(BufferedReader br) {
        this.br = br;
    }

    public SpaceMarine buildSpaceMarine() {
        String Name = askName();
        Coordinates coordinates = askCoordinates();
        Double health = askHealth();
        AstartesCategory astartesCategory = askСategory();
        Weapon weapon = askWeaponType();
        MeleeWeapon meleeWeapon = askMeleeWeapon();
        Chapter chapter = askChapter();
        try {
            return new SpaceMarine(1, Name, coordinates, null, health, astartesCategory, weapon, meleeWeapon, chapter); 
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
                String inputx = br.readLine().trim();
                if (inputx.isBlank()) {
                    throw new ValidationException("Координата X не может быть пустой.");
                }
                Double inputX = Double.parseDouble(inputx);

                System.out.print("Введите координату Y: ");
                String inputy = br.readLine().trim();
                if (inputy.isBlank()) { // TODO нужна ли проверка на null?
                    throw new ValidationException("Координата Y не может быть пустой.");
                }
                Float inputY = Float.parseFloat(inputy);
                
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
                String inputName = br.readLine().trim();
                
                if (inputName.isBlank()) {
                    throw new ValidationException("Имя не может быть пустым.");
                }

                System.out.print("Общая численность братьев по оружию в этом ордене: ");
                int inputMarinesCount = Integer.parseInt(br.readLine().trim());

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

