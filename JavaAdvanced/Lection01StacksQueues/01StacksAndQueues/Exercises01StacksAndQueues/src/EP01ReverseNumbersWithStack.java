import java.util.*;
import java.util.stream.Collectors;

public class EP01ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());



        for (int i = 0; i < numbers.size(); i++){
            stack.push(numbers.get(i));
        }

        for (Integer element : stack)
        {
            System.out.print(element+ " ");
        }

    }
}
