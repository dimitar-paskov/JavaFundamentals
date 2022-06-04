import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LabP05WriteEveryThirdLine {
    public static void main(String[] args) {

        String basePath = "JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String outputPath = basePath + "/output.txt";
        String inputPath = basePath + "/input.txt";
        
//        try (BufferedReader reader = 
//        		Files.newBufferedReader(path)) {
//        	  // TODO: work with file
//        	} catch (IOException e) {
//        	  // TODO: handle exception
//        	}

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
