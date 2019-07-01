import java.util.ArrayDeque;
import java.util.Scanner;

public class EP08SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String current = "";

        ArrayDeque<String> history = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");

            int command = Integer.parseInt(tokens[0]);
            switch (command){
                case 1:{
                    String argument = tokens[1];
                    history.push(current);
                    current += argument;
                };break;
                case 2:{
                    int count = Integer.parseInt(tokens[1]);
                    history.push(current);
                    current = current.substring(0, current.length() - count);
                };break;
                case 3:{
                    int index = Integer.parseInt(tokens[1]);
                    System.out.println(current.charAt(index-1));
                };break;
                case 4:{
                    current = history.pop();
                };break;
            }

        }

    }
}
