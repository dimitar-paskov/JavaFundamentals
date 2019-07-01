package EP06StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Person> personsByName = new TreeSet<>(Person.comparator1);
        TreeSet<Person> personsByAge = new TreeSet<>(Person.comparator2);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            Integer age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            personsByName.add(person);
            personsByAge.add(person);

        }

        personsByName.forEach(x-> System.out.println(x.name+ " " + x.age));
        personsByAge.forEach(x-> System.out.println(x.name+ " " + x.age));


    }
}
