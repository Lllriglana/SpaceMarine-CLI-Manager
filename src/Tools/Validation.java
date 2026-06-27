package Tools;

import Exception.ValidationException;

public class Validation {
    public Validation() {}

    public static String validNull(String value, String fieldName) throws ValidationException{
        if (value == null)
            throw new ValidationException(fieldName + "Поле дне может быть нулевым");
        if (value.trim().isEmpty()) {
            throw new ValidationException(fieldName + "Поле дне может быть нулевым");
        } else 
            return value;
    }
    
}






//public class Valid {
//    public static String nullCheck(String a) {
//        if ("".equals(a)) {
//            System.out.println("Нельзя");
//            
//        } else return a;
//    }
//
//    public static void intCheck(String a) {
//        
//    } 
//}