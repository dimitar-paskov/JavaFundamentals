import java.util.LinkedHashMap;
import java.util.Scanner;

public class EP06AMinerTask {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String resource = "";

		LinkedHashMap<String, Long> records = new LinkedHashMap<>();

		while (!"stop".equals(resource = scanner.nextLine())) {
			int quantity = Integer.parseInt(scanner.nextLine());

			records.putIfAbsent(resource, 0L);
			records.put(resource, records.get(resource) + quantity);

		}

		for (String stock : records.keySet()) {
			System.out.printf("%s -> %d\n", stock, records.get(stock));
		}
	}
}
