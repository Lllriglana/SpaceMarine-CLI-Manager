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
        return "Coordinates [x=" + x + ", y=" + y + "]";
    }

        @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinates other = (Coordinates) obj;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
            return false;
        if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + Float.floatToIntBits(y);
        return result;
    }
    
}
