import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class EP04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).boxed().toArray(Integer[]::new);

        Function<Integer[], Integer[]> operation = x->x;
        String command= null;
        while (!"end".equals(command=scanner.nextLine().toLowerCase())){
            switch (command){
                case "add":{
                    operation = array-> {array = Arrays.stream(array).map(x->x+1).toArray(Integer[]::new);return array; };
                }break;
                case "multiply": {
                    operation = array-> {array = Arrays.stream(array).map(x->x*2).toArray(Integer[]::new);return array; };
                }break;
                case "subtract": {
                    operation = array-> {array = Arrays.stream(array).map(x->x-1).toArray(Integer[]::new);return array; };
                }break;
                case "print":{
                    operation = array-> {Arrays.stream(array).forEach(x-> System.out.print(x+ " "));
                        System.out.println();return array; };
                }break;
            }

            arr = operation.apply(arr);
        }

    }

}
