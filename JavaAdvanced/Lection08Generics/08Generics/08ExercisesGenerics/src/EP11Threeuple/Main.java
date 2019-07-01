package EP11Threeuple;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        String firestName = tokens[0];
        String secondName = tokens[1];
        String address = tokens[2];
        String town = tokens[3];

        Threeuple<String, String, String> tuple1 = new Threeuple<>(firestName + " " + secondName, address, town);

        tokens = scanner.nextLine().split("\\s+");
        String name = tokens[0];
        int littersofBeer  = Integer.parseInt(tokens[1]);
        Boolean drunkOrNot = tokens[2].equals("drunk");
        Threeuple<String, Integer, Boolean> tuple2 = new Threeuple<>(name, littersofBeer,drunkOrNot);

        tokens = scanner.nextLine().split("\\s+");
        name = tokens[0];
        Double balance = Double.parseDouble(tokens[1]);
        String bankName = tokens[2];

        Threeuple<String, Double, String> tuple3 = new Threeuple<>(name,balance, bankName);

        System.out.println(tuple1.getItem1() + " -> " + tuple1.getItem2() + " -> " + tuple1.getItem3());
        System.out.println(tuple2.getItem1() + " -> " + tuple2.getItem2() + " -> " + tuple2.getItem3());
        System.out.println(tuple3.getItem1() + " -> " + tuple3.getItem2() + " -> " + tuple3.getItem3());

    }
}
