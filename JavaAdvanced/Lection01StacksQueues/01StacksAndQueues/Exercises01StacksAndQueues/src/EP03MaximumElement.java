import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class EP03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++){
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens[0].equals("1")){
                stack.push(Integer.parseInt(tokens[1]));
            }else if(tokens[0].equals("2")){
                stack.pop();
            }else if (tokens[0].equals("3")){
                if (stack.size() > 0){
                    System.out.println(Collections.max(stack));
                }
            }
        }

    }
}
