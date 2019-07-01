import java.util.*;

public class EP01ClubParty {

    private static HashMap<String, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();


        List<String> inputs = Arrays.asList(scanner.nextLine().split("\\s+"));
        Collections.reverse(inputs);

        for (int i = 0; i < inputs.size(); i++) {
            try {
                int current = Integer.parseInt(inputs.get(i));
                while (queue.size() > 0) {

                    String key = queue.peek();
                    int sum = map.get(key).stream().mapToInt(Integer::intValue).sum();
                    if (sum + current > n) {
                        queue.poll();
                        printEntry(key);
                    } else {
                        map.get(key).add(current);
                        break;
                    }

                }

            } catch (NumberFormatException ex) {
                queue.offer(inputs.get(i));
                map.put(inputs.get(i), new ArrayList<>());
            }
        }

    }

    private static void printEntry(String key) {
        System.out.printf("%s -> %s%n", key, String.join(", ", map.get(key).stream().map(String::valueOf).toArray(size -> new String[size])));

    }
}
