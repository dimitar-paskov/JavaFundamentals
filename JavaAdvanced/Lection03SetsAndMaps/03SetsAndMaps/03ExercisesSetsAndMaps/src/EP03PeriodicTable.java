import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class EP03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> elements = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            List<String> compounds = Arrays.asList(scanner.nextLine().split("\\s+"));
            elements.addAll(compounds);
        }

        for (String element :
                elements) {
            System.out.print(element + " ");
        }
    }
}
