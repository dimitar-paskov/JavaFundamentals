import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LabP05AverageStudentsGrades {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		DecimalFormat formatter = new DecimalFormat("0.00");

		TreeMap<String, List<Double>> grades = new TreeMap<String, List<Double>>();

		for (int i = 0; i < n; i++) {
			String[] tokens = scanner.nextLine().split("\\s+");
			String name = tokens[0];
			double grade = Double.parseDouble(tokens[1]);
			System.out.println(grade);

			grades.putIfAbsent(name, new ArrayList<Double>());
			grades.get(name).add(grade);
		}

		for (String name : grades.keySet()) {
//            OptionalDouble average = grades.get(name)
//                    .stream()
//                    .mapToDouble(a -> a)
//                    .average();
			double sum = 0;
			for (Double grade : grades.get(name)) {
				sum += grade;
//                sum = Double.valueOf(formatter.format(sum));
			}
//            sum = Math.round(sum*100)/100.0;
			double average = sum / grades.get(name).size();

			System.out.println(name + " -> "
					+ grades.get(name).stream().map(x -> formatter.format(x)).collect(Collectors.joining(" "))
					+ " (avg: " + formatter.format(average) + ")");

		}
	}
}
