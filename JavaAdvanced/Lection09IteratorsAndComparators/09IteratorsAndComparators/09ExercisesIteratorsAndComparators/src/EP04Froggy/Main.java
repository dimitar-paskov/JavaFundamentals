package EP04Froggy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Integer[] arr = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).toArray(Integer[]::new);
		Lake lake = new Lake(arr);
		scanner.nextLine();
		String result = "";
		for (Integer num : lake) {
			result += (num + ", ");

		}
		System.out.println(result.substring(0, result.length() - 2));

	}
}
