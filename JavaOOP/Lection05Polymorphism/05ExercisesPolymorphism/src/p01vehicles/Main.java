package p01vehicles;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        String [] tokens = scanner.nextLine().split(" ");
        Car car = new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]) );
        tokens = scanner.nextLine().split(" ");
        Truck truck = new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]) );
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            tokens = scanner.nextLine().split(" ");
            String command = tokens[0];
            String vehicle = tokens[1];
            double value = Double.parseDouble(tokens[2]);

            switch (command){
                case "Drive":{
                    if ("Car".equals(vehicle)){
                        try {
                            car.drive(value);
                            System.out.printf("Car travelled %s km%n", df.format(value));
                        } catch (ValidationException e) {
                            System.out.println(e.getMessage());
                        }
                    }else{
                        try {
                            truck.drive(value);
                            System.out.printf("Truck travelled %s km%n", df.format(value));
                        } catch (ValidationException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                }break;
                case "Refuel":{
                    if ("Car".equals(vehicle)){
                       car.refuel(value);
                    }else{
                        truck.refuel(value);
                    }
                }break;
            }

        }

        System.out.println(car);
        System.out.println(truck);
    }
}
