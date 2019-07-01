import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EP10SerializeArrayList {
    public static void main(String[] args) {

        String basePath = "/media/D/Programming/SoftUni/7.JavaFundamentals/JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String path = basePath + "/ListSerialization.ser";


        List<Double> list = new ArrayList<>();
        list.add(3.5);
        list.add(5.5);
        list.add(7.5);
        list.add(9.5);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(list);
        }catch (IOException ex){
            ex.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            List<Double> list2 = (ArrayList<Double>)ois.readObject();
            for (Double d :
                    list2) {
                System.out.println(d);
            }
        }catch (ClassNotFoundException | IOException ex){
            ex.printStackTrace();
        }


    }
}
