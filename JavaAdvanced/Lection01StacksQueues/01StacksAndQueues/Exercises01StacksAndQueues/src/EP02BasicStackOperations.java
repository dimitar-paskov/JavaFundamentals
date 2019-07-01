import java.util.*;
import java.util.stream.Collectors;

public class EP02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = numbers[0];
        int s = numbers[1];
        int x = numbers[2];

        List<Integer> inputs = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        for (int i = 0; i < n; i++) {
            stack.push(inputs.get(i));
        }

        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if (stack.contains(x)) {
            System.out.println(true);
        }else{
            if (stack.size()>0){
                System.out.println((int) Collections.min(stack));
            }else{
                System.out.println(0);
            }
        }


    }
}
