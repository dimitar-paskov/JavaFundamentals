import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EP03ALLCAPITALS {
    public static void main(String[] args) {

        String basePath = "JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String outputPath = basePath + "/output.txt";
        String inputPath = basePath + "/input.txt";

        try (BufferedReader in =
                     new BufferedReader(new FileReader(inputPath));
             PrintWriter out =
                     new PrintWriter(new FileWriter(outputPath))) {

            String line = in.readLine();
            while (line != null) {
                out.println(line.toUpperCase());

                line = in.readLine();
            }
        }catch (IOException ex){
            ex.printStackTrace();

        }
    }
}
