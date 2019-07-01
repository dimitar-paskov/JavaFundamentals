import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EP06WordCount {
    public static void main(String[] args) {

        String basePath = "/media/D/Programming/SoftUni/7.JavaFundamentals/JavaAdvanced/Lection04StreamsFilesAndDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String textPath = basePath + "/text.txt";
        String wordsPath = basePath + "/words.txt";

        LinkedHashMap<String, Integer> countMap = new LinkedHashMap<>();
        LinkedHashSet<String> keys = new LinkedHashSet<>();

        try (BufferedReader textIn =
                     new BufferedReader(new FileReader(textPath));
             BufferedReader wordsIn =
                     new BufferedReader(new FileReader(wordsPath))) {

            String line = "";
            while ((line = wordsIn.readLine()) != null){
                String[] words = line
                        .split("\\s+");
                for (String word :
                        words) {
                    keys.add(word);
                    countMap.putIfAbsent(word.toLowerCase(),0);
                }
            }

            while ((line = textIn.readLine()) != null){

                List<String> toRemove = Arrays.asList(".", ",", "!");

//                line=toRemove.stream()
//                        .map(toRem-> (Function<String,String>) s->s.replaceAll(toRem, ""))
//                        .reduce(Function.identity(), Function::andThen)
//                        .apply(line);

                line = Pattern.compile("").splitAsStream(line)
                        .filter(s -> !toRemove.contains(s))
                        .collect(Collectors.joining());


                String[] words = line
                        .split("\\s+");
                for (String word :
                        words) {
                   if (countMap.containsKey(word.toLowerCase())){
                       countMap.put(word.toLowerCase(), countMap.get(word.toLowerCase())+1);
                   }

                }
            }



        }catch (IOException ex){
            ex.printStackTrace();

        }

        for (String key :
                keys) {
            System.out.printf("%s - %d%n", key, countMap.get(key.toLowerCase()));
        }
    }
}
