package p02vehiclesExtension;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        String[] tokens;
        Car car = null;
        Truck truck = null;
        Bus bus = null;
        for (int i = 0; i < 3; i++) {
            tokens = scanner.nextLine().split(" ");
            String type = tokens[0];
            switch (type) {
                case "Car": {
                    try {
                        car = new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
                    } catch (ValidationException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case "Truck": {
                    try {
                        truck = new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
                    } catch (ValidationException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case "Bus": {
                    try {
                        bus = new Bus(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
                    } catch (ValidationException e) {
                        System.out.println(e.getMessage());
                    }

                }
                break;
            }
        }

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            tokens = scanner.nextLine().split(" ");
            String command = tokens[0];
            String vehicle = tokens[1];
            double value = Double.parseDouble(tokens[2]);

            switch (command) {
                case "Drive": {
                    if ("Car".equals(vehicle)) {
                        try {
                            car.drive(value);
                            System.out.printf("Car travelled %s km%n", df.format(value));
                        } catch (ValidationException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if ("Truck".equals(vehicle)){
                        try {
                            truck.drive(value);
                            System.out.printf("Truck travelled %s km%n", df.format(value));
                        } catch (ValidationException e) {
                            System.out.println(e.getMessage());
                        }
                    }else{
                        try {
                            bus.drive(value);
                            System.out.printf("Bus travelled %s km%n", df.format(value));
                        } catch (ValidationException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                }
                break;
                case "Refuel": {
                    if ("Car".equals(vehicle)) {
                        try {
                            car.refuel(value);
                        } catch (ValidationException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if ("Truck".equals(vehicle)){
                        try {
                            truck.refuel(value);
                        } catch (ValidationException e) {
                            System.out.println(e.getMessage());
                        }
                    }else{
                        try {
                            bus.refuel(value);
                        } catch (ValidationException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                break;
                case "DriveEmpty":{
                    try {
                        bus.driveEmpty(value);
                        System.out.printf("Bus travelled %s km%n", df.format(value));
                    } catch (ValidationException e) {
                        System.out.println(e.getMessage());
                    }

                }break;
            }

        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
