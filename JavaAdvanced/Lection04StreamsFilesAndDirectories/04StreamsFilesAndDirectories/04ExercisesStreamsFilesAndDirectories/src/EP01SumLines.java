import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EP01SumLines {
	public static void main(String[] args) {

		String basePath = "JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources";
		String outputPath = basePath + "/output.txt";
		String inputPath = basePath + "/input.txt";

		try (BufferedReader in = Files.newBufferedReader(Paths.get(inputPath));

		) {
			String line = in.readLine();
			while (line != null) {
				long sum = 0;
				for (char c : line.toCharArray()) {
					sum += c;
				}
				System.out.println(sum);
				line = in.readLine();
			}

		} catch (IOException ex) {
			ex.printStackTrace();

		}
	}
}
