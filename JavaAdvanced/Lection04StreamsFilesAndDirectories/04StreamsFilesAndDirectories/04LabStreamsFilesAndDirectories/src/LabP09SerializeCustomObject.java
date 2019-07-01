import java.io.*;

public class LabP09SerializeCustomObject {
    public static void main(String[] args) {

        String path = "/media/D/Programming/SoftUni/7.JavaFundamentals/JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources/saveCube.txt";


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
