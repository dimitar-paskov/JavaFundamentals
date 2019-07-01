import java.io.*;

public class LabP05WriteEveryThirdLine {
    public static void main(String[] args) {

        String basePath = "/media/D/Programming/SoftUni/7.JavaFundamentals/JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String outputPath = basePath + "/output.txt";
        String inputPath = basePath + "/input.txt";

        try (BufferedReader in =
                     new BufferedReader(new FileReader(inputPath));
             PrintWriter out =
                     new PrintWriter(new FileWriter(outputPath))) {
            int counter = 1;
            String line = in.readLine();
            while (line != null) {
                if (counter % 3 == 0)
                    out.println(line);
                counter++;
                line = in.readLine();
            }
        }catch (IOException ex){
            ex.printStackTrace();

        }
    }
}
