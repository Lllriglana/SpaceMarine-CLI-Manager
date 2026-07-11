package Tools;

import Exception.ValidationException;

public class Validator {
    private Validator() {}

    public static int requireValidId(int id) throws ValidationException {
        if (id <= 0) throw new ValidationException("Ошибка: ID должен быть больше нуля");
        return id;
    }

    public static String notNull_String(String val, String fieldName) throws ValidationException {
        if (val == null || val.isBlank()) {
            throw new ValidationException("Ошибка: Поле '" + fieldName + "' не может быть пустым");
        } 
        return val;
    }
    
    public static Double requireValidX(Double val) throws ValidationException {
        if (val == null) throw new ValidationException("Ошибка: Координата X не может быть null");
        if (val < -540) throw new ValidationException("Ошибка: Координата X не может быть меньше -540");
        return val;
    }

    public static double healthRequireGreaterThanZero(Double health, String fieldName) throws ValidationException { 
        if (health == null) throw new ValidationException("Ошибка: поле '" + fieldName + "' не должно быть пустым");
        if (health <= 0) throw new ValidationException("Ошибка: поле '" + fieldName + "' должно быть больше нуля");
        return health;
    }

    public static int requireNonZero(int val, String fieldName) throws ValidationException {
        if (val == 0) {
            throw new ValidationException("Ошибка: Поле '" + fieldName + "' не может равняться нулю");
        }
        return val;
    }

    public static <T> T requireSpecial(T object, String fieldName) throws ValidationException {
        if (object == null) {
            throw new ValidationException("Ошибка: Поле '" + fieldName + "' не может быть пустым");
        } else return object;
    }


}