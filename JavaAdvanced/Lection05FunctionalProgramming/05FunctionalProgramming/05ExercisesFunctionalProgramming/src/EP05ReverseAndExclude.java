import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EP05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> isNotDivisible = x-> x % n != 0;

        List<String> result = list.stream().filter(isNotDivisible).map(String::valueOf).collect(Collectors.toList());
        Collections.reverse(result);
        System.out.println(String.join(" ", result));
    }
}
