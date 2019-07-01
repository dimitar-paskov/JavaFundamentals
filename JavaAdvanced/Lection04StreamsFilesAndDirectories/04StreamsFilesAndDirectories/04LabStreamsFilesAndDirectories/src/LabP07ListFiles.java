import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LabP07ListFiles {
    public static void main(String[] args) {

        String basePath = "/media/D/Programming/SoftUni/7.JavaFundamentals/JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources";
        Path inputPath = Paths.get(basePath + "/Files-and-Streams");


        File file = new File(inputPath.toString());


        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    if (!f.isDirectory()) {		System.out.printf("%s: [%s]%n",
                            f.getName(), f.length());
                    }
                }
            }
        }
    }
}
