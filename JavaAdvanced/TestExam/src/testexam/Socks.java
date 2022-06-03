package testexam;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Socks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> left= new ArrayDeque<>();
        ArrayDeque<Integer> right= new ArrayDeque<>();
        ArrayList<Integer> pairs = new ArrayList<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(x->left.push(x));

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(x->right.offer(x));

        while (left.size()>0 && right.size()>0){
            int leftElement = left.peek();
            int rightElement = right.peekFirst();

            if (leftElement > rightElement){
                pairs.add(leftElement + rightElement);
                left.pop();
                right.poll();
            }

            if (leftElement == rightElement){
                right.poll();
                left.pop();
                left.push(leftElement+1);
            }

            if (leftElement < rightElement){
                left.pop();
            }
        }

        System.out.println(pairs.stream().mapToInt(Integer::valueOf).max().getAsInt());
        pairs.stream().forEach(x-> System.out.print(x+" "));
    }
}
