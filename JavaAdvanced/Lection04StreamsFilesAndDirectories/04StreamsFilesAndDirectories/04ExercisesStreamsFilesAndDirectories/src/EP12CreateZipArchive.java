import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class EP12CreateZipArchive {
    private final static Logger LOG = Logger.getLogger("Zip");
    public static void main(String[] args) {


        String basePath = "/media/D/Programming/SoftUni/7.JavaFundamentals/JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String path1 = basePath + "/input.txt";
        String path2 = basePath + "/inputLineNumbers.txt";
        String path3 = basePath + "/inputOne.txt";
        Path zipPath = Paths.get(basePath + "/zipArchive.zip");

        try(InputStream in1 = new FileInputStream(path1);
            InputStream in2 = new FileInputStream(path2);
            InputStream in3 = new FileInputStream(path3);
            ZipOutputStream zipStream = new ZipOutputStream(Files.newOutputStream(zipPath));
        ){
            ZipEntry entry = new ZipEntry(path1);
            zipStream.putNextEntry(entry);

            LOG.info("Generated new entry for: " + path1);

            byte[] readBuffer = new byte[2048];
            int amountRead;
            int written = 0;

            while ((amountRead = in1.read(readBuffer)) > 0) {
                zipStream.write(readBuffer, 0, amountRead);
                written += amountRead;
            }

            ZipEntry entry2 = new ZipEntry(path2);
            zipStream.putNextEntry(entry2);

            LOG.info("Generated new entry for: " + path2);

            while ((amountRead = in2.read(readBuffer)) > 0) {
                zipStream.write(readBuffer, 0, amountRead);
                written += amountRead;
            }

            ZipEntry entry3 = new ZipEntry(path3);
            zipStream.putNextEntry(entry3);

            LOG.info("Generated new entry for: " + path3);

            while ((amountRead = in3.read(readBuffer)) > 0) {
                zipStream.write(readBuffer, 0, amountRead);
                written += amountRead;
            }




            LOG.info("Stored " + written + " bytes to " + zipPath);


        }catch (IOException ex){

        }
    }
}
