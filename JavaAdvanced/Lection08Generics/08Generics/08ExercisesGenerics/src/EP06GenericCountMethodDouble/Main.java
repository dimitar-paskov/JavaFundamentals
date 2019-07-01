package EP06GenericCountMethodDouble;


import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Box<Double>> list = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Double num = Double.parseDouble(scanner.nextLine());
            Box<Double> box = new Box<>(num);
            list.add(box);
        }

        Double target = Double.parseDouble(scanner.nextLine());
        System.out.println(countGreater(list, target));


    }

    public static <P extends Comparable, T extends Comparable> long countGreater(ArrayList<P> list, T elem){
        return list.stream().filter(x -> x.compareTo(elem) > 0).count();

    }
}
