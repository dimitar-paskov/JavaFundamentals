/**
 * @author dimitar
 *
 */
package solidExercises.logger.controllers;

import java.util.Scanner;

public class InputParser {

	private Scanner scanner;

	public InputParser() {
		this.scanner = new Scanner(System.in);
	}

	public String readLoggerInfo() {
		int n = Integer.parseInt(this.scanner.nextLine());
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			sb.append(this.scanner.nextLine()).append(System.lineSeparator());
		}
		
		return sb.toString();
	}
}
