import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class EP07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Integer[], Integer> findTheSmallest = array -> {
            int minIndex = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < array.length; i++) {
                if (array[i]<=min){
                    min = array[i];
                    minIndex = i;
                }
            }
            return minIndex;
        };
        String[] input = scanner.nextLine().split(" ");
        Integer[] arr = Arrays.stream(input).mapToInt(Integer::valueOf).boxed().toArray(Integer[]::new);
        System.out.println(findTheSmallest.apply(arr));
        
    }
}
