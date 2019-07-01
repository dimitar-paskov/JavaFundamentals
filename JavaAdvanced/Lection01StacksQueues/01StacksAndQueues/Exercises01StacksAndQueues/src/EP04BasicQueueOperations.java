import java.util.*;
import java.util.stream.Collectors;

public class EP04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
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
            queue.offer(inputs.get(i));
        }

        for (int i = 0; i < s; i++) {
            queue.poll();
        }

        if (queue.contains(x)) {
            System.out.println(true);
        }else{
            if (queue.size()>0){
                System.out.println((int) Collections.min(queue));
            }else{
                System.out.println(0);
            }
        }
    }
}
