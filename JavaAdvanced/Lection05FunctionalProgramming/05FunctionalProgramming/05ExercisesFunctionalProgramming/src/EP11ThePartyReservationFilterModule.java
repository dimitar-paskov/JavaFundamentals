import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EP11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        HashSet<String> filters = new LinkedHashSet<>();


        String line = "";
        while (!"Print".equals(line = scanner.nextLine())){
            String[] tokens = line.split(";");
            String command = tokens[0];
            String condition = tokens[1];
            String arg = tokens[2];

            if ("Add filter".equals(command)){
                   filters.add(condition+";"+arg);
            }else {
                filters.remove(condition+";"+arg);
            }


        }


        for (String entry :
                filters) {
            String[] tokens = entry.split(";");
            String condition = tokens[0];
            String arg = tokens[1];

            Predicate<String> check = null;

            switch (condition){
                case "Starts with":{
                    check = str-> !str.startsWith(arg);
                }break;
                case "Ends with":{
                    check = str-> !str.endsWith(arg);
                }break;
                case "Length": {
                    check = str->!(str.length()==Integer.parseInt(arg));
                }break;
                default:{
                    //Contains
                    check = str->!str.contains(arg);
                }
            }

            names = Arrays.stream(names).filter(check).toArray(String[]::new);


        }

        System.out.println(String.join(" ", names));


    }
}
