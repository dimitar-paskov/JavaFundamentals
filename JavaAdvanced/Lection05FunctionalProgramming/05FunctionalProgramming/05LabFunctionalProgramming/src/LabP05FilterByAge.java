import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class LabP05FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(", ");
            map.putIfAbsent(data[0], Integer.parseInt(data[1]));
        }

        String condition = scanner.nextLine();
        Integer age = Integer.parseInt(scanner.nextLine());
        String[] format = scanner.nextLine().split(" ");

        Consumer<Map.Entry> print;
        if (format.length>1){
            print = (Map.Entry x)-> System.out.println(x.getKey() + " - " + x.getValue());
        }else{
            if (format[0].equals("name")){
                print = (Map.Entry x)-> System.out.println(x.getKey());
            }else{
                print = (Map.Entry x)-> System.out.println(x.getValue());
            }
        }

        if ("older".equals(condition)){

            map.entrySet().stream().filter(x-> x.getValue() >= age).forEach(print);
        }else{
            map.entrySet().stream().filter(x-> x.getValue() < age).forEach(print);
        }
    }
}
