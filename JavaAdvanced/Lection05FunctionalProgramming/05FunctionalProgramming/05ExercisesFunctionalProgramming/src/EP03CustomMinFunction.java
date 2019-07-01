import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EP03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Integer[], Integer> findTheSmallest = array -> Arrays.stream(array).mapToInt(Integer::intValue).min().getAsInt();
        String[] input = scanner.nextLine().split(" ");
        Integer[] arr = Arrays.stream(input).mapToInt(Integer::valueOf).boxed().toArray(Integer[]::new);
        System.out.println(findTheSmallest.apply(arr));

    }
}
