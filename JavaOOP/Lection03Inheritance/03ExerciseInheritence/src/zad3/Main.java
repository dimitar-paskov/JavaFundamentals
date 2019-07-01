package zad3;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] tokens = line.split(" ");
        String fName = tokens[0];
        String sName = tokens[1];
        String fNumber = tokens[2];
        Student student = new Student(fName, sName, fNumber);

        line = scanner.nextLine();
        tokens = line.split(" ");
        fName = tokens[0];
        sName = tokens[1];
        double salary = Double.parseDouble(tokens[2]);
        double whpd = Double.parseDouble(tokens[3]);

        Worker worker = new Worker(fName, sName, salary, whpd);

        System.out.println(student);
        System.out.println(worker);



    }


}
