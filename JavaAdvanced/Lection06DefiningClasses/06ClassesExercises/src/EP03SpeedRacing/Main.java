package EP03SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Car> carsInfo = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model  = tokens[0];
            Double fuelAmount = Double.parseDouble(tokens[1]);
            Double fuelCostFor1km = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, fuelCostFor1km);
            carsInfo.putIfAbsent(model, car);


        }

        String line = "";
        while (!"End".equals(line = scanner.nextLine())){
            String[] tokens = line.split("\\s+");
            String carModel = tokens[1];
            Integer distance = Integer.parseInt(tokens[2]);

            carsInfo.get(carModel).drive(distance);


        }

        carsInfo.forEach((carModel, car) -> System.out.printf("%s %.2f %d%n", carModel, car.getFuelAmount(), car.getDistanceTraveled()));
    }
}
