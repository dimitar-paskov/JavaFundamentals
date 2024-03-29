import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LabP02WriteToFile {
	public static void main(String[] args) throws IOException {
		String basePath = "JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources";
		String outputhPath = basePath + "/output.txt";
		String inputhPath = basePath + "/input.txt";

		List<Character> punctuation = Arrays.asList(',', '.', '!', '?');

		try (FileInputStream inputStream = new FileInputStream(inputhPath);
				FileOutputStream outputStream = new FileOutputStream(outputhPath);) {

			int byteData = inputStream.read();
			while (byteData >= 0) {
				if (!punctuation.contains((char) byteData)) {
					outputStream.write(byteData);
//					System.out.println(byteData);
				}
				byteData = inputStream.read();
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());

		}

//        FileInputStream inputStream = null;
//        FileOutputStream outputStream = null;
//
//        try {
//            inputStream = new FileInputStream(inputhPath);
//            outputStream = new FileOutputStream(outputhPath);
////            outputStream.write(65);
//
//
//            int byteData = inputStream.read();
//            while (byteData >=0 ){
//                if (!punctuation.contains((char)byteData)){
//                    outputStream.write(byteData);
//                    System.out.println(byteData);
//                }
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
//
//            if (outputStream!=null){
//                outputStream.close();
//            }
//        }

	}

}
