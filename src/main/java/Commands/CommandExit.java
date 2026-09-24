package Commands;

public class CommandExit implements Command {

    @Override
    public void execute(String[] args) {
        System.out.println("Программа завершена.");
        System.exit(1);
    }
}