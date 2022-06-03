import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EP07FixEmails {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, String> addressBook = new LinkedHashMap<>();
		String name = "";

		while (!"stop".equals(name = scanner.nextLine())) {
			String address = scanner.nextLine();
			if (!(address.toLowerCase().endsWith("us") || address.toLowerCase().endsWith("com")
					|| address.toLowerCase().endsWith("uk"))) {
				addressBook.put(name, address);
			}
		}

		for (String person : addressBook.keySet()) {
			System.out.printf("%s -> %s\n", person, addressBook.get(person));
		}
	}
}
