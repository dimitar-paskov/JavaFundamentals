package EP07EqualityLogic;


import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Person> personsByTree = new TreeSet<>(Person.comparator1);
        HashSet<Person> personsByHash = new HashSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            Integer age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            personsByTree.add(person);
            personsByHash.add(person);

        }

        System.out.println(personsByTree.size());
        System.out.println(personsByHash.size());


    }
}
