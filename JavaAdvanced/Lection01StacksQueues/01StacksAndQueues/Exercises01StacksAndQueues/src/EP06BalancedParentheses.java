import java.util.ArrayDeque;
import java.util.Scanner;

public class EP06BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Character> stack = new ArrayDeque<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == '{'
                    || input.charAt(i) == '('
                    || input.charAt(i) == '['){
                stack.push(input.charAt(i));
            }else if (input.charAt(i) == '}'){
                if (stack.size()==0 || stack.peek() != '{'){
                    System.out.println("NO");
                    return;
                }else {
                    stack.pop();
                }
            }else if (input.charAt(i) == ']'){
                if (stack.size()==0 || stack.peek() != '['){
                    System.out.println("NO");
                    return;
                }else {
                    stack.pop();
                }
            }else if (input.charAt(i) == ')'){
                if (stack.size()==0 || stack.peek() != '('){
                    System.out.println("NO");
                    return;
                }else {
                    stack.pop();
                }
            }

        }

        if (stack.size()==0){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
