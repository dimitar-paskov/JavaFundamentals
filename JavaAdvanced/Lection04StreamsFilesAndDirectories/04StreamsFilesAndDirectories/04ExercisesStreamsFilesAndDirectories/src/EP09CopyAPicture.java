import java.io.*;

public class EP09CopyAPicture {
    public static void main(String[] args) {
        String basePath = "/media/D/Documents";
        String path = basePath + "/10629574_782220328520128_5746665168718511826_n.png";
        String outPath = basePath + "/JavaCopyOfPic.png";
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
