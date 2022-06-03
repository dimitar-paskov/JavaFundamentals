import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LabP07CitiesByContinentAndCountry {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());

		LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> geography = new LinkedHashMap<>();

		for (int i = 0; i < n; i++) {
			String[] data = scanner.nextLine().split(" ");
			String continent = data[0];
			String country = data[1];
			String town = data[2];

			geography.putIfAbsent(continent, new LinkedHashMap<>());
			geography.get(continent).putIfAbsent(country, new ArrayList<String>());
			geography.get(continent).get(country).add(town);

		}

		for (String continent : geography.keySet()) {
			System.out.println(continent + ":");
			for (String country : geography.get(continent).keySet()) {
				System.out.printf("%s -> ", country);
				String list = geography.get(continent).get(country).stream().collect(Collectors.joining(", "));
				System.out.printf("%s\n", list);
			}
		}
	}
}
