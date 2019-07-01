import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class LabP05FilterByAge2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

//        for (int i = 0; i < n; i++) {
//            String[] data = scanner.nextLine().split(", ");
//            people.putIfAbsent(data[0], Integer.parseInt(data[1]));
//        }

        IntStream
                .rangeClosed(1,n)
                .boxed()
                .map(m->scanner.nextLine().split(", "))
                .map(data ->{people.putIfAbsent(data[0], Integer.parseInt(data[1])); return data[0];})
                .forEach(person -> System.out.print(""));


        String condition = scanner.nextLine();
        Integer age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Integer> tester = createTester(condition, age);

        Consumer<Map.Entry<String, Integer>> printer =
                createPrinter(format);

        printFilteredStudent(people, tester, printer);
    }

    private static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        switch (format) {
            case "name age":
                return person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
            case "name":
                return person -> System.out.printf("%s%n", person.getKey());
            case "age":
                return person -> System.out.printf("%d%n", person.getValue());
            default:
                return person -> System.out.printf("%d%n", person.getValue());

        }
    }

    private static Predicate<Integer> createTester(String condition, Integer age) {
        switch (condition) {
            case "younger":
                return x -> x < age;
            case "older":
                return x -> x >= age;
            default:
                return x -> x < age;
        }
    }

    public static void printFilteredStudent(
            LinkedHashMap<String, Integer> people,
            Predicate<Integer> tester,
            Consumer<Map.Entry<String, Integer>> printer) {

        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (tester.test(people.get(person.getKey()))) {
                printer.accept(person);
            }
        }
    }
}
