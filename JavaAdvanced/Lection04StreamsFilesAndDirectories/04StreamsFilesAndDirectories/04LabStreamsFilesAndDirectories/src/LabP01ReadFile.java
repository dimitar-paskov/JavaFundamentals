import java.io.FileInputStream;
import java.io.IOException;

public class LabP01ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "/media/D/Programming/SoftUni/7.JavaFundamentals/JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
            int byteData = inputStream.read();
            while (byteData >=0 ){
                System.out.print(Integer.toBinaryString(byteData) + " ");
                byteData = inputStream.read();
            }


        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            if (inputStream!=null){
                inputStream.close();
            }
        }

    }
}
