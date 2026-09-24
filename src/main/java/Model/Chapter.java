package Model;

import java.util.Objects;

import Exception.ValidationException;
import Tools.Validator;

public class Chapter {
    private String name;
    private int marinesCount;
    
    public Chapter(String name, int marinesCount) throws ValidationException {
        this.name = Validator.requireSpecial(name, "Name");
        this.marinesCount = Validator.requireLessOrEqual(marinesCount, 1000, "Marines Count");
    }

/* 
    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else System.out.println("Пустая строка");
    }

    public void setMarinesCount(int marinesCount) {
        if (marinesCount > 0 && marinesCount <= 1000) {
            this.marinesCount = marinesCount;
        } else System.out.println("Пустая строка");
    }
*/

    public String getName() {
        return name;
    }

    public int getMarinesCount() {
        return marinesCount;
    }


    @Override
    public String toString() {
        return "Chapter [name=" + name + ", marinesCount=" + marinesCount + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chapter chapter)) return false;
        return marinesCount == chapter.marinesCount &&
                Objects.equals(name, chapter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, marinesCount);
    }
}
