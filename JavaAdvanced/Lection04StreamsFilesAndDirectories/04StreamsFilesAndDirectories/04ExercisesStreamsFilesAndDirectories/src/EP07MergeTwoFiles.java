import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EP07MergeTwoFiles {
	public static void main(String[] args) {

		String basePath = "JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources";
		String inputPath1 = basePath + "/inputOne.txt";
		String inputPath2 = basePath + "/inputTwo.txt";
		String outputPath = basePath + "/merged.txt";

		try (BufferedReader in1 = new BufferedReader(new FileReader(inputPath1));
				BufferedReader in2 = new BufferedReader(new FileReader(inputPath2));
				PrintWriter out = new PrintWriter(new FileWriter(outputPath))) {

			String line = in1.readLine();
			while (line != null) {
				out.println(line.toUpperCase());

				line = in1.readLine();
			}
			line = in2.readLine();
			while (line != null) {
				out.println(line.toUpperCase());

				line = in2.readLine();
			}

		} catch (IOException ex) {
			ex.printStackTrace();

		}

	}
}
