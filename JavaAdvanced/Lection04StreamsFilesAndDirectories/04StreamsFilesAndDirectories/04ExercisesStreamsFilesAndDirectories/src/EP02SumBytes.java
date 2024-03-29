import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EP02SumBytes {
	public static void main(String[] args) {

		String basePath = "JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources";
		String outputPath = basePath + "/output.txt";
		String inputPath = basePath + "/input.txt";

		try (BufferedReader in = new BufferedReader(new FileReader(inputPath));

		) {
			String line = in.readLine();
			long sum = 0;
			while (line != null) {
				for (char c : line.toCharArray()) {
					sum += c;
				}
				line = in.readLine();
			}
			System.out.println(sum);

		} catch (IOException ex) {
			ex.printStackTrace();

		}
	}
}
