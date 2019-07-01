//https://www.thecoderscorner.com/team-blog/java-and-jvm/63-writing-a-zip-file-in-java-using-zipoutputstream/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * This class generates a zip archive containing all the
 * files within constant ZIP_DIR.
 * For this example you'll need to put a few files in the
 * directory ZIP_DIR, and it will generate a zip archive
 * containing all those files in the location OUTPUT_ZIP.
 * Minimum Java version: 8
 */
public class ZipWriter2 {
    private final static Logger LOG = Logger.getLogger("Zip");

    public final static String ZIP_DIR = "c:/Dev/temp/zipwrite";
    public static final String OUTPUT_ZIP = "c:/dev/temp/output.zip";



    public void createZip(String dirName) {

        Path directory = Paths.get(dirName);
        File zipFileName = Paths.get(OUTPUT_ZIP).toFile();

        try( ZipOutputStream zipStream = new ZipOutputStream(
                new FileOutputStream(zipFileName)) ) {
            DirectoryStream<Path> dirStream = Files.newDirectoryStream(directory);
            dirStream.forEach(path -> addToZipFile(path, zipStream));

            LOG.info("Zip file created in " + directory.toFile().getPath());
        }
        catch(IOException|ZipParsingException e) {
            LOG.log(Level.SEVERE, "Error while zipping.", e);
        }
    }


    public void addToZipFile(Path file, ZipOutputStream zipStream) {
        String inputFileName = file.toFile().getPath();
        try (FileInputStream inputStream = new FileInputStream(inputFileName)) {

            ZipEntry entry = new ZipEntry(file.toFile().getName());
            entry.setCreationTime(FileTime.fromMillis(file.toFile().lastModified()));
            entry.setComment("Created by TheCodersCorner");
            zipStream.putNextEntry(entry);

            LOG.info("Generated new entry for: " + inputFileName);

            byte[] readBuffer = new byte[2048];
            int amountRead;
            int written = 0;

            while ((amountRead = inputStream.read(readBuffer)) > 0) {
                zipStream.write(readBuffer, 0, amountRead);
                written += amountRead;
            }

            LOG.info("Stored " + written + " bytes to " + inputFileName);


        }
        catch(IOException e) {
            throw new ZipParsingException("Unable to process " + inputFileName, e);
        }
    }

    private class ZipParsingException extends RuntimeException {
        public ZipParsingException(String reason, Exception inner) {
            super(reason, inner);
        }
    }
}