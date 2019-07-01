package EP05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();

        String line = "";
        while (!"END".equals(line = scanner.nextLine())){
            String[] tokens = line.split(" ");
            String name = tokens[0];
            Integer age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            Person person = new Person(name, age,town);
            persons.add(person);


        }

        Integer n = Integer.parseInt(scanner.nextLine())-1;

        Person person = persons.get(n);

        long matches = persons.stream().filter(p->p.compareTo(person)==0).count();
        if (matches==1){
            System.out.println("No matches");
        }else{
            System.out.printf("%d %d %d", matches, persons.size()-matches, persons.size());
        }

    }
}
