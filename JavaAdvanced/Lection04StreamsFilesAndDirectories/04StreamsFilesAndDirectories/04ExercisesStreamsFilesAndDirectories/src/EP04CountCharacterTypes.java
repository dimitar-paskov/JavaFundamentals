import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class EP04CountCharacterTypes {
	public static void main(String[] args) {
		String basePath = "JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources";
		String outputPath = basePath + "/output.txt";
		String inputPath = basePath + "/input.txt";

		List<Character> punctuation = Arrays.asList(',', '.', '!', '?');
		List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

		try (BufferedReader in = new BufferedReader(new FileReader(inputPath));
				PrintWriter out = new PrintWriter(new FileWriter(outputPath))) {

			int vowelCount = 0;
			int punctuationCount = 0;
			int consonantCount = 0;
			String line = in.readLine();
			while (line != null) {
				String[] words = line.split("\\s+");
				for (String word : words) {
					for (char c : word.toCharArray()) {
						if (punctuation.contains(c)) {
							punctuationCount++;
						} else if (vowels.contains(c)) {
							vowelCount++;
						} else {
							consonantCount++;
						}
					}
				}

				line = in.readLine();
			}
			out.println("Vowels: " + vowelCount);
			out.println("Consonants: " + consonantCount);
			out.println("Punctuation: " + punctuationCount);
		} catch (IOException ex) {
			ex.printStackTrace();

		}
	}
}
