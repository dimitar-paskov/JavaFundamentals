
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EP10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        String line = null;
        while (!"Party!".equals(line = scanner.nextLine())){
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            String condition = tokens[1];
            String arg = tokens[2];

           names = operation(names, command, arg, condition);

        }

        if (names.length<1){
            System.out.println("Nobody is going to the party!");
        }else{
            System.out.println(String.join(", ", names) + " are going to the party!");
        }
    }

    static String[] operation(String[] names,String command, String arg,String condition) {


        Predicate<String> check = null;
        String[] newNames = null;

        switch (condition){
            case "StartsWith":{
                check = str-> str.startsWith(arg);
            }break;
            case "EndsWith":{
                check = str-> str.endsWith(arg);
            }break;
            default: {
                check = str->str.length()==Integer.parseInt(arg);
            }
        }


        switch (command){
            case "Remove":{
                newNames = Arrays.stream(names).filter(check.negate()).toArray(String[]::new);
            }break;
            case "Double":{
                Arrays.sort(names);
                ArrayList<String> toBeDoubled = Arrays.stream(names).filter(check).collect(Collectors.toCollection(ArrayList::new));
                String[] result = new String[names.length + toBeDoubled.size()];
//                Collections.addAll(result, names);
                for (int i = 0, k = 0; i < names.length; i++, k++) {
                    result[k] = names[i];
                    if (toBeDoubled.size()> 0 && names[i].equals(toBeDoubled.get(0))){
                        result[++k] = toBeDoubled.remove(0);
                    }
                }
                newNames = result;
            }break;
        }

        return newNames;
    }


}
