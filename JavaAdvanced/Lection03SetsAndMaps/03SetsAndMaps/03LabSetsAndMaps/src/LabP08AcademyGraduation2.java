import java.util.Scanner;
import java.util.TreeMap;

public class LabP08AcademyGraduation2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());

		TreeMap<String, Double> grades = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			String name = scanner.nextLine();
			String[] values = scanner.nextLine().split("\\s+");

			Double sum = 0.0;
			for (int j = 0; j < values.length; j++) {
				sum += Double.parseDouble(values[j]);
			}

			Double grade = sum / values.length;

			grades.put(name, grade);

		}

		for (String name : grades.keySet()) {
			System.out.println(name + " is graduated with " + grades.get(name));
		}
	}
}
