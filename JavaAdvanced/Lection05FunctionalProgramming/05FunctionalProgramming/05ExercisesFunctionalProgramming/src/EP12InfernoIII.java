import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EP12InfernoIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> gems =
                Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        HashMap<String, BiPredicate<Integer, Integer>> filters = new LinkedHashMap<>();

        String line = "";
        while (!"Forge".equals(line = scanner.nextLine())) {
            String[] tokens = line.split(";");
            String command = tokens[0];
            String condition = tokens[1];
            Integer arg = Integer.parseInt(tokens[2]);


            BiPredicate<Integer, Integer> check = null;

            switch (condition) {
                case "Sum Left": {
                    check = (target, index) -> {
                        int previous = 0;
                        if (index != 0) {
                            previous = gems.get(index - 1);
                        }

                        if (target == gems.get(index) + previous) {
                            return true;
                        }
                        return false;
                    };
                }
                break;
                case "Sum Right": {
                    check = (target, index) -> {

                        int next = 0;
                        if (index != gems.size() - 1) {
                            next = gems.get(index + 1);
                        }
                        if (target == gems.get(index) + next) {
                            return true;
                        }
                        return false;
                    };
                }break;
                default: {
                    check = (target, index) -> {
                        int previous = 0;
                        if (index != 0) {
                            previous = gems.get(index - 1);
                        }
                        int next = 0;
                        if (index != gems.size() - 1) {
                            next = gems.get(index + 1);
                        }
                        if (target == gems.get(index) + previous + next) {
                            return true;
                        }
                        return false;
                    };
                }

            }
            if ("Exclude".equals(command)) {
                filters.putIfAbsent(condition + ";" + arg, check);
            }else {
                filters.remove(condition + ";" + arg);
            }


        }

        for (int i = 0; i < gems.size(); i++) {
            boolean isValid = true;
            for (String predicate :
                    filters.keySet()) {
                Integer target = Integer.parseInt(predicate.split(";")[1]);
                if(filters.get(predicate).test(target, i)){
                    isValid = false;
                }

            }

            if (isValid){
                System.out.print(gems.get(i) + " ");
            }


        }



    }
}


