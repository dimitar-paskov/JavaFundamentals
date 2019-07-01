import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class LabP04ExtractIntegers {
    public static void main(String[] args) {

        String basePath = "/media/D/Programming/SoftUni/7.JavaFundamentals/JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String outputPath = basePath + "/output.txt";
        String inputPath = basePath + "/input.txt";

        try (
            Scanner scanner =
                    new Scanner(new FileInputStream(inputPath));

            PrintWriter out =
                    new PrintWriter(new FileOutputStream(outputPath));
        ){
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    out.println(number);
                    System.out.println(number);
                }
                scanner.next();
            }

        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }

    }

}
