package EP05CarSalesman;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Engine> enginsRegister = new LinkedHashMap<>();
        LinkedList<Car> carsRegister = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            String power = tokens[1];
            String displacement = "n/a";
            String efficiency = "n/a";
            if (tokens.length == 3){
                try{
                    int number = Integer.parseInt(tokens[2]);
                    displacement = tokens[2];
                }catch (NumberFormatException ex){
                    efficiency = tokens[2];
                }
            }

            if (tokens.length == 4){
                try{
                    int number = Integer.parseInt(tokens[2]);
                    displacement = tokens[2];
                    efficiency = tokens[3];
                }catch (NumberFormatException ex){
                    efficiency = tokens[2];
                    displacement = tokens[3];

                }
            }


            Engine newEngine = new Engine(model, power, displacement, efficiency);

            enginsRegister.putIfAbsent(model, newEngine);



        }

        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            String engine = tokens[1];

            String weight = "n/a";
            String color = "n/a";

            if (tokens.length == 3){
                try{
                    int number = Integer.parseInt(tokens[2]);
                    weight = tokens[2];
                }catch (NumberFormatException ex){
                    color = tokens[2];
                }
            }

            if (tokens.length == 4){
                try{
                    int number = Integer.parseInt(tokens[2]);
                    weight = tokens[2];
                    color = tokens[3];
                }catch (NumberFormatException ex){
                    color = tokens[2];
                    weight = tokens[3];

                }
            }

            Car newCar = new Car(model, enginsRegister.get(engine), weight, color);

            carsRegister.add(newCar);

        }

        System.out.println();
        for (Car car :
                carsRegister) {
            System.out.print(car.toString());
        }


    }
}
