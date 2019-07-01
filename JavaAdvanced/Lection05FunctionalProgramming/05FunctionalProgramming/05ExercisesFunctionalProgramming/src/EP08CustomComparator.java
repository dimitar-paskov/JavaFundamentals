import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EP08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<Integer> compare = (x1,x2) -> {
            if (x1 % 2 == 0 && x2 % 2 !=0){
                return -1;
            }else if(x1 % 2 != 0 && x2 % 2 ==0){
                return 1;
            }

            return x1.compareTo(x2);

        };
        String[] input = scanner.nextLine().split(" ");
        Integer[] arr = Arrays.stream(input).mapToInt(Integer::valueOf).boxed().toArray(Integer[]::new);
        Arrays.sort(arr,compare);
        System.out.println(String.join(" ",Arrays.stream(arr).map(String::valueOf).collect(Collectors.toList())));
    }
}


/*
* public class EP08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<Integer> compare = (x1,x2) -> {
            if (x1 % 2 == 0 && x2 % 2 !=0){
                return -1;
            }else if(x1 % 2 != 0 && x2 % 2 ==0){
                return 1;
            }else{
                if (x1>=x2){
                    return 1;
                }else{
                    return -1;
                }
            }

        };
        String[] input = scanner.nextLine().split(" ");
        Integer[] arr = Arrays.stream(input).mapToInt(Integer::valueOf).boxed().toArray(Integer[]::new);
        Arrays.sort(arr,compare);
        System.out.println(String.join(" ",Arrays.stream(arr).map(String::valueOf).collect(Collectors.toList())));
    }
}
*
* */