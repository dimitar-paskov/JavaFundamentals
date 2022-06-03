import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class LabP08AcademyGraduation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());

		TreeMap<String, Double> grades = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			String name = scanner.nextLine();
			double grade = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).average()
					.getAsDouble();

			grades.put(name, grade);

		}

		for (String name : grades.keySet()) {
			System.out.println(name + " is graduated with " + grades.get(name));
		}
	}
}
