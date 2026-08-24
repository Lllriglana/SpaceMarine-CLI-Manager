package Managers;

public class test {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager("script.txt");
        
        System.out.println(fileManager.readFile());
    }
}
