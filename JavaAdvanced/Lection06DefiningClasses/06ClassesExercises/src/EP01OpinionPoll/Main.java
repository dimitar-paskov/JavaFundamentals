package EP01OpinionPoll;


import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Person> register = new LinkedList<>();



        int n = Integer.parseInt(scanner.nextLine());

        IntStream
                .rangeClosed(1,n)
                .boxed()
                .map(p-> scanner.nextLine().split(" "))
                .forEach(data -> {
                    Person person = new Person(data[0], Integer.parseInt(data[1]));
                    register.add(person);
                });

        register.stream()
                .filter(p->p.age > 30)
                .sorted((p1,p2) -> p1.name.compareTo(p2.name))
                .forEach(p-> System.out.println(p.getInfo()));


    }
}
