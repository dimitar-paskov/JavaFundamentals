package EP04GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Box<Integer>> list = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Integer num = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(num);
            list.add(box);
        }

        List<Integer> swaps = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        swap(list, swaps.get(0), swaps.get(1));

        for (Box bx :
                list) {
            System.out.println(bx.toString());
        }


    }

    public static <T> void swap(ArrayList<T> list, int a, int b){
        T elem = list.get(a);
        list.set(a, list.get(b));
        list.set(b,elem);
    }
}
