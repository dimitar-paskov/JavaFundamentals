import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOther {




//        String basePath = "/media/D/Programming/SoftUni/7.JavaFundamentals/JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources";
//        String path1 = basePath + "/input.txt";
//        String path2 = basePath + "/inputLineNumbers.txt";
//        String path3 = basePath + "/inputOne.txt";

    public static void main(String[] args) throws IOException {

        String sourceFile = "/Users/umesh/personal/tutorials/source/index.html";
        String zipName="/Users/umesh/personal/tutorials/source/testzip.zip";

        File targetFile = new File(sourceFile);

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipName));
        zipOutputStream.putNextEntry(new ZipEntry(targetFile.getName()));
        FileInputStream inputStream = new FileInputStream(targetFile);

        final byte[] buffer = new byte[1024];
        int length;
        while((length = inputStream.read(buffer)) >= 0) {
            zipOutputStream.write(buffer, 0, length);
        }
        zipOutputStream.close();
        inputStream.close();



        String sourceDirectoryPath = "/Users/umesh/personal/tutorials/source";
        String zipFilePath = "/Users/umesh/personal/tutorials/source.zip";

        zipDirectory(sourceDirectoryPath, zipFilePath);
    }

    public static void zipDirectory(String sourceDirectoryPath, String zipPath) throws IOException {
        Path zipFilePath = Files.createFile(Paths.get(zipPath));

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFilePath))) {
            Path sourceDirPath = Paths.get(sourceDirectoryPath);

            Files.walk(sourceDirPath).filter(path -> !Files.isDirectory(path))
                    .forEach(path -> {
                        ZipEntry zipEntry = new ZipEntry(sourceDirPath.relativize(path).toString());
                        try {
                            zipOutputStream.putNextEntry(zipEntry);
                            zipOutputStream.write(Files.readAllBytes(path));
                            zipOutputStream.closeEntry();
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                    });
        }
    }


}
