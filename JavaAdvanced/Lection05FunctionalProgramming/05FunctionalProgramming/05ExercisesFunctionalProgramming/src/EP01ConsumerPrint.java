import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class EP01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> printOnNewLine = System.out::println;
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(printOnNewLine);
    }

}
