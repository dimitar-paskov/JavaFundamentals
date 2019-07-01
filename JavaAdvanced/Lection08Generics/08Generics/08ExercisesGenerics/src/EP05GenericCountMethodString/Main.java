package EP05GenericCountMethodString;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Box<String>> list = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            Box<String> box = new Box<>(line);
            list.add(box);
        }

        String target = scanner.nextLine();
        System.out.println(countGreater(list, target));


    }

    public static <P extends Comparable, T extends Comparable> long countGreater(ArrayList<P> list, T elem){
        return list.stream().filter(x -> x.compareTo(elem) > 0).count();

    }
}
