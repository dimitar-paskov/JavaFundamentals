import java.util.LinkedHashSet;
import java.util.Scanner;

public class EP01UniqueUsernames {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		LinkedHashSet<String> usernames = new LinkedHashSet<>();
		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			String name = scanner.nextLine();
			usernames.add(name);
		}

		for (String username : usernames) {
			System.out.println(username);
		}
	}

}
