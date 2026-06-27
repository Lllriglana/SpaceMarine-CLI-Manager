package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ModelTest {
    private String name;
    private String secName;
    private int year;
    private int countFriends;
    
    public ModelTest(String name, String secName, int year, int countFriends) {
        this.name = name;
        this.secName = secName;
        this.year = year;
        this.countFriends = countFriends;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSecName() {
        return secName;
    }
    public void setSecName(String secName) {
        this.secName = secName;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getCountFriends() {
        return countFriends;
    }
    public void setCountFriends(int countFriends) {
        this.countFriends = countFriends;
    }

    @Override
    public String toString() {
        return "ModelTest [name=" + name + ", secName=" + secName + ", year=" + year + ", countFriends=" + countFriends
                + "]";
    }
}

class CollectionTest {
    List<ModelTest> list = new LinkedList<ModelTest>();
    
}

class Check {
    public static void main(String[] args) throws IOException {
        String s = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CollectionTest col = new CollectionTest();

        while (true) {
            System.out.print("> ");
            try {
                s = br.readLine();
            } catch (IOException e) {
                System.out.println("Ошибка" + e);
            }
            if (s.equals("exit")) break;
            if (s.equals("add")) {
                int s3;
                int s4;
                System.out.println("Введите имя: ");
                String s1 = br.readLine();
                System.out.println("Введите фамилию: ");
                String s2 = br.readLine();
                
                System.out.println("Введите возраст: ");

                while(true) {
                    try {
                        s3 = Integer.parseInt(br.readLine());
                        break;
                    } catch (Exception e) {
                        System.out.println("повторите ввод");
                    }
                } 

                System.out.println("Введите кол-во друзей: ");

                while(true) {
                    try {
                        s4 = Integer.parseInt(br.readLine());
                        break;
                    } catch (Exception e) {
                        System.out.println("повторите ввод");
                    }
                } 

                col.list.add(new ModelTest(s1, s2, s3, s4));
            }
            if (s.equals("show")) System.out.println(col.list);
        }
        br.close();
    }
}