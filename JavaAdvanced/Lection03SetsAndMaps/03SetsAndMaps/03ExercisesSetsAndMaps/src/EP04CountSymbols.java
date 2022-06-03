import java.util.Scanner;
import java.util.TreeMap;

public class EP04CountSymbols {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String line = scanner.nextLine();

		TreeMap<Character, Integer> counts = new TreeMap<>();
		for (int i = 0; i < line.length(); i++) {
			Character ch = line.charAt(i);
			counts.putIfAbsent(ch, 0);
			counts.put(ch, counts.get(ch) + 1);
		}

		for (Character ch : counts.keySet()) {
			System.out.printf("%c: %d time/s\n", ch, counts.get(ch));
		}
	}
}
