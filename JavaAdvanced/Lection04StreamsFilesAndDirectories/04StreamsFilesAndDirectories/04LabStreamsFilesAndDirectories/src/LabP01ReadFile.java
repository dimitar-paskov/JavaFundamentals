import java.io.FileInputStream;
import java.io.IOException;

public class LabP01ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";

//        String currentPath = new java.io.File(".").getCanonicalPath();
//        System.out.println("Current dir:" + currentPath);

//        FileInputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream(path);
//            int byteData = inputStream.read();
//            while (byteData >=0 ){
//                System.out.print(Integer.toBinaryString(byteData) + " ");
//                byteData = inputStream.read();
//            }
//
//
//        }catch (IOException e){
//            System.out.println(e.getMessage());
//        }finally {
//            if (inputStream!=null){
//                inputStream.close();
//            }
//        }
        
        try(FileInputStream inputStream = new FileInputStream(path)){
        	int byteData = inputStream.read();
        	int count = 1;
        	 while (byteData >=0 ){
               System.out.println("" + count++ + "->" + Integer.toBinaryString(byteData) + " ");
               byteData = inputStream.read();
           }
        }catch (IOException e){
        	e.printStackTrace();
      }
        

    }
}
