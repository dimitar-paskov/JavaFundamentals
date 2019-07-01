package EP10Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        String firestName = tokens[0];
        String secondName = tokens[1];
        String address = tokens[2];

        Tuple<String, String> tuple1 = new Tuple<>(firestName + " " + secondName, address);

        tokens = scanner.nextLine().split("\\s+");
        String name = tokens[0];
        int littersofBeer  = Integer.parseInt(tokens[1]);
        Tuple<String, Integer> tuple2 = new Tuple<>(name, littersofBeer);

        tokens = scanner.nextLine().split("\\s+");
        Integer n = Integer.parseInt(tokens[0]);
        Double d = Double.parseDouble(tokens[1]);
        Tuple<Integer, Double> tuple3 = new Tuple<>(n,d);

        System.out.println(tuple1.getItem1() + " -> " + tuple1.getItem2());
        System.out.println(tuple2.getItem1() + " -> " + tuple2.getItem2());
        System.out.println(tuple3.getItem1() + " -> " + tuple3.getItem2());

    }
}
