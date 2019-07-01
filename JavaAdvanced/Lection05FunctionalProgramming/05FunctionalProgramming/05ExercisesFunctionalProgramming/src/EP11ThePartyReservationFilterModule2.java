import java.util.*;
import java.util.function.Predicate;

public class EP11ThePartyReservationFilterModule2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        HashMap<String, Predicate<String>> filters = new LinkedHashMap<>();


        String line = "";
        while (!"Print".equals(line = scanner.nextLine())){
            String[] tokens = line.split(";");
            String command = tokens[0];
            String condition = tokens[1];
            String arg = tokens[2];

            Predicate<String> check = null;
            switch (condition){
                case "Starts with":{
                    check = str-> str.startsWith(arg);
                }break;
                case "Ends with":{
                    check = str-> str.endsWith(arg);
                }break;
                case "Length": {
                    check = str->(str.length()==Integer.parseInt(arg));
                }break;
                default:{
                    //Contains
                    check = str->str.contains(arg);
                }
            }

            if ("Add filter".equals(command)){
                filters.putIfAbsent(condition+";"+arg,check);
            }else {
                filters.remove(condition+";"+arg);
            }


        }


        for (String name :
                names) {
            boolean isValid = true;
            for (String filter :
                    filters.keySet()) {
                if (filters.get(filter).test(name)){
                    isValid = false;
                    break;
                }

            }

            if (isValid){
                System.out.print(name + " ");
            }
        }


    }

}
