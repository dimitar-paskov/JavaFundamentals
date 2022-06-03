import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class EP02SetsOfElements {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] sizesOfSets = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int n = sizesOfSets[0];
		int m = sizesOfSets[1];

		Set<Integer> set1 = new LinkedHashSet<>();
		Set<Integer> set2 = new LinkedHashSet<>();

		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(scanner.nextLine());
			set1.add(number);
		}

		for (int i = 0; i < m; i++) {
			int number = Integer.parseInt(scanner.nextLine());
			set2.add(number);
		}

		Set<Integer> commonElements = new LinkedHashSet<>(set1);
		commonElements.retainAll(set2);

		for (int element : commonElements) {
			System.out.print(element + " ");
		}

	}
}
