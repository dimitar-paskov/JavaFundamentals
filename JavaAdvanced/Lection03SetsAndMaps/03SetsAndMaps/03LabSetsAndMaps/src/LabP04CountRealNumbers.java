import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class LabP04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<Double, Integer> count = new LinkedHashMap<>();


        double[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        for (double entry:arr
             ) {
            count.putIfAbsent(entry, 0);
            count.put(entry, count.get(entry)+1);
        }

        for (double key :
                count.keySet()) {
            System.out.println(String.format("%.1f -> %d", key, count.get(key)));
        }
    }
}
