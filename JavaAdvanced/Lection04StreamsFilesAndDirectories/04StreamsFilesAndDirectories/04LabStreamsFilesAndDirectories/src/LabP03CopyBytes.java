import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LabP03CopyBytes {

    public static void main(String[] args) throws IOException {
        String basePath = "JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String outputPath = basePath + "/output.txt";
        String inputPath = basePath + "/input.txt";


        try(FileInputStream in = new FileInputStream(inputPath);
            FileOutputStream out  = new FileOutputStream(outputPath)){
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    out.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++)
                        out.write(digits.charAt(i));
                }
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
