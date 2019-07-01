package EP03StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        String line = "";

        while (!"END".equals(line = scanner.nextLine())){

            String command = line.split("\\s+")[0];


            switch (command){
                case "Push":{
                    line = line.substring(line.indexOf(" ")+1).trim();
                    String[] tokens = line.split(", ");
                    Integer[] arr = Arrays.stream(tokens).map(Integer::parseInt).toArray(Integer[]::new);
                    stack.push(arr);
                }break;
                case "Pop":{
                    stack.pop();
                }break;
            }
        }

        for (Integer n :
                stack) {
            System.out.println(n);
        }
    }
}
