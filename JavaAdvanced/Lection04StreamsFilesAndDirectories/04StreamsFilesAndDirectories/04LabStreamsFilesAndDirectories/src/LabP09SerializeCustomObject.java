import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LabP09SerializeCustomObject {
    public static void main(String[] args) {

        String path = "JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources/saveCube.ser";


        Cube cube = new Cube("Green", 15.3, 12.4, 3.0);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(cube);
        }catch (IOException ex){
            ex.printStackTrace();
        }

        Cube cube1=null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
        cube1=(Cube) ois.readObject();
        }catch (ClassNotFoundException | IOException ex){
            ex.printStackTrace();
        }

        System.out.println(cube1.color);

    }
}
