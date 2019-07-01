import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class EP09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        String[] input = scanner.nextLine().split(" ");
        Integer[] arr = Arrays.stream(input).mapToInt(Integer::valueOf).boxed().toArray(Integer[]::new);



        Predicate<Integer> isDivisible = x-> {
            boolean isDivisibl = true;
            for (int i = 0; i < arr.length; i++) {
                if (x%arr[i]!=0){
                    isDivisibl = false;
                    break;
                }
            }
            return isDivisibl;
        };

        IntStream
                .rangeClosed(1,n)
                .boxed()
                .filter(isDivisible)
                .forEach(x-> System.out.print(x+ " "));

    }
}
