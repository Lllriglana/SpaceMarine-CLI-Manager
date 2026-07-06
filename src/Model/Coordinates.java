package Model;

import Exception.ValidationException;
import Tools.Validator;

public class Coordinates {
    private double x;
    private float y;

    public Coordinates() {}

    public Coordinates(double x, float y) throws ValidationException {
        this.x = Validator.requireValidX(x);
        this.y = Validator.requireSpecial(y, "Координата Y");
    }

    public void setX(double x) {
        if (x != 0 && x > -540) {
            this.x = x;
        } else {
            System.out.println("Нельзя");
        }
    }

    public void setY(float y) {
        if (y != 0 && y > -540) {
            this.y = y;
        } else {
            System.out.println("Нельзя");
        }
    }
    
    private double getX() {
        return x;
    }

    private float getY() {
        return y;
    }
    
    @Override
    public String toString() {
        return "{ " + x + " ; " + y + " }";
    }
}
