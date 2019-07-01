import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class LabP06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ranges = scanner.nextLine().split("\\s+");
        Integer lower = Integer.parseInt(ranges[0]);
        Integer upper = Integer.parseInt(ranges[1]);
        String condition = scanner.nextLine();

        Predicate<Integer> tester = createTester(condition);
        printNumbers(lower, upper, tester);
    }

    private static Predicate<Integer> createTester(String condition) {
        switch (condition) {
            case "even":
                return x -> x % 2 == 0;
            default:
                return x -> x % 2 != 0;
        }
    }

    public static void printNumbers(
            Integer lower,
            Integer upper,
            Predicate<Integer> tester) {

        IntStream
                .rangeClosed(lower, upper)
                .boxed()
                .filter(tester)
                .forEach(x-> System.out.print(x+ " "));

//        for (Integer i = lower; i <=upper ; i++) {
//            if (tester.test(i)){
//                System.out.print(i+ " ");
//            }
//
//        }
    }
}
