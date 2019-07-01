import java.util.ArrayDeque;
import java.util.Scanner;

public class EP09InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
//            String symbol = tokens[i];
            if (tokens[i].equals("*")){
                if (stack.size()!=0 ){
                    while (stack.size() > 0 &&( stack.peek().equals("*") || stack.peek().equals("/"))){
                        queue.offer(stack.pop());
                    }

                }

                stack.push(tokens[i]);

            }else if (tokens[i].equals("/")){
                if (stack.size()!=0 ){
                    while (stack.size() > 0 &&( stack.peek().equals("*") || stack.peek().equals("/"))){
                        queue.offer(stack.pop());
                    }

                }

                stack.push(tokens[i]);

            }else if (tokens[i].equals("+")){
                if (stack.size()!=0 ){
                    while (stack.size() > 0 && !stack.peek().equals("(")){
                        queue.offer(stack.pop());
                    }

                }

                stack.push(tokens[i]);

            }else if (tokens[i].equals("-")){
                if (stack.size()!=0 ){
                    while (stack.size() > 0 && !stack.peek().equals("(")){
                        queue.offer(stack.pop());
                    }

                }

                stack.push(tokens[i]);

            }else if (tokens[i].equals("(")){
                stack.push(tokens[i]);

            }else if (tokens[i].equals(")")){
                if (stack.size()!=0 ){
                    while (stack.size() > 0 && !stack.peek().equals("(")){
                        queue.offer(stack.pop());
                    }

                }

                stack.pop();

            }else{
                queue.offer(tokens[i]);
            }
        }

        while (stack.size()>0){
            queue.offer(stack.pop());
        }

        for (String element : stack)
        {
            System.out.print(element+ " ");
        }

        for (String element : queue)
        {
            System.out.print(element+ " ");
        }


    }
}
