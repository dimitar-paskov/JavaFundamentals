import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class EP09CopyAPicture {
    public static void main(String[] args) {
        String basePath = "/home/dimitar/Pictures";
        String path = basePath + "/MineCraftMini_NativeLibrariesAddedForLinux.png";
        String outPath = basePath + "/MineCraftMini_NativeLibrariesAddedForLinux2.png";
        byte[] buffer = null;


        try (InputStream in = new FileInputStream(path); OutputStream out = new FileOutputStream(outPath)){


            int byteData = in.read();
            while (byteData >=0){
                out.write(byteData);
                byteData = in.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
