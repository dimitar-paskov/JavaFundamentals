import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LabP01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        numbers.removeIf(n -> n % 2 != 0);

        System.out.println(String.join(", ", numbers.stream().map(String::valueOf).collect(Collectors.toList())));
        System.out.println(String.join(", ", numbers.stream().sorted().map(String::valueOf).collect(Collectors.toList())));

        numbers.sort((a, b) -> a.compareTo(b));



    }
}
