package EP04RawData;
import java.util.LinkedList;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<Car> cars = new LinkedList<>();


        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String model = data[0];
            Integer engineSpeed = Integer.parseInt(data[1]);
            Integer enginePower = Integer.parseInt(data[2]);
            Integer cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            Double tire1Pressure = Double.parseDouble(data[5]);
            Integer tire1Age = Integer.parseInt(data[6]);
            Double tire2Pressure = Double.parseDouble(data[7]);
            Integer tire2Age = Integer.parseInt(data[8]);
            Double tire3Pressure = Double.parseDouble(data[9]);
            Integer tire3Age = Integer.parseInt(data[10]);
            Double tire4Pressure = Double.parseDouble(data[11]);
            Integer tire4Age = Integer.parseInt(data[12]);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);

            cars.add(car);


        }


        String command = scanner.nextLine();
        if (command.equals("fragile")){
            cars.stream()
                    .filter(c->c.cargo.getType().equals("fragile"))
                    .filter(c-> c.isTyreFlat())
                    .forEach(c-> System.out.println(c.getModel()));

        }else{
            cars.stream()
                    .filter(c->c.cargo.getType().equals("flamable"))
                    .filter(c->c.isEngineEvil())
                    .forEach(c-> System.out.println(c.getModel()));

        }
    }
}
