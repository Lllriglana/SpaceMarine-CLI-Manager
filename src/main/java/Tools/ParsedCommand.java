package Tools;

public record ParsedCommand(String name, String[] args) {
    // getters and settears there are auto created in record
}


/*
import java.util.Arrays;

public final class ParsedCommand {
    private final String name;
    private final String[] args;

    public ParsedCommand(String name, String[] args) {
        this.name = name;
        this.args = args;
    }

    public String name() {
        return name;
    }

    public String[] args() {
        return args;
    }

    @Override
    public String toString() {
        return "ParsedCommand[name=" + name + ", args=" + Arrays.toString(args) + "]";
    }

    @Override
    public boolean equals(Object other) {
        // нормальная реализация сравнения
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
*/