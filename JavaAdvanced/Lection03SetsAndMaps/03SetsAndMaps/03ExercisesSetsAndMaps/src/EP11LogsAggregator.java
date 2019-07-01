import java.util.*;
import java.util.stream.Collectors;

public class EP11LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, TreeSet<String>> aggregator = new TreeMap<>();
        TreeMap<String, Integer> durations = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split("\\s+");
            String ip = parts[0];
            String user = parts[1];
            System.out.println();
            int duration = Integer.parseInt(parts[2]);

            aggregator.putIfAbsent(user, new TreeSet<>());
            durations.putIfAbsent(user, 0);
            aggregator.get(user).add(ip);
            durations.put(user, durations.get(user) + duration);


        }

        durations
                .entrySet()
                .stream()
                .forEach(x-> {
                    System.out.printf("%s: %d ", x.getKey(), x.getValue());
                    System.out.printf("[%s]\n", aggregator.get(x.getKey()).stream().collect(Collectors.joining(", ")));
                });
    }
}
