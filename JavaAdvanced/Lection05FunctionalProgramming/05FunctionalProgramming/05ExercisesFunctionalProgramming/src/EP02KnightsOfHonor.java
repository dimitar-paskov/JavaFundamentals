import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class EP02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> printOnNewLine = str-> System.out.println("Sir " + str);
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(printOnNewLine);
    }
}
