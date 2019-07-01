import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class EP08GetFolderSize {
    public static void main(String[] args) {

        String basePath = "/media/D/Programming/SoftUni/7.JavaFundamentals/JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String path = basePath + "/Exercises Resources";

        Deque<File> queue = new ArrayDeque<>();

        File file = new File(path);
//        System.out.println(file.getUsableSpace());

        Long size = 0L;
        queue.offer(file);
        while (!queue.isEmpty()) {

//            System.out.println(queue.poll().isDirectory());

            for (File current :
                    queue.poll().listFiles()) {
//                System.out.println(current.getName());
                if (current.isDirectory()) {
                    queue.offer(current);
                } else {
                    size += current.length();
                }

            }


        }

        System.out.println(size);
    }
}
