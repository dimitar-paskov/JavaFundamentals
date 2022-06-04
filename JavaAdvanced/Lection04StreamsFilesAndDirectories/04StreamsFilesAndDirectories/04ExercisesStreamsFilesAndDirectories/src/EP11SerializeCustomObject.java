import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EP11SerializeCustomObject {
    public static void main(String[] args) {

        String basePath = "JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String path = basePath + "/CustomObject.ser";

        Course math = new Course("math", 20);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(math);
        }catch (IOException ex){
            ex.printStackTrace();
        }

        Course math1=null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            math1=(Course) ois.readObject();
        }catch (ClassNotFoundException | IOException ex){
            ex.printStackTrace();
        }

        System.out.println(math1.name);
    }
}
