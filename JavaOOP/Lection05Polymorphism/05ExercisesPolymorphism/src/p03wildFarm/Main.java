package p03wildFarm;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new LinkedList<>();
        String line = "";
        while (!"End".equals(line = scanner.nextLine())) {
            String[] tokens = line.split(" ");
            String animalName = tokens[1];
            String animalType = tokens[0];
            double animalWeight = Double.parseDouble(tokens[2]);
            String livingRegion = tokens[3];
            Animal animal = null;
            switch (animalType) {
                case "Cat": {
                    String breed = tokens[4];
                    animal = new Cat(animalName, animalType, animalWeight, livingRegion, breed);
                }
                break;
                case "Tiger": {
                    animal = new Tiger(animalName, animalType, animalWeight, livingRegion);
                }
                break;
                case "Mouse": {
                    animal = new Mouse(animalName, animalType, animalWeight, livingRegion);

                }
                break;
                case "Zebra": {
                    animal = new Zebra(animalName, animalType, animalWeight, livingRegion);
                }
                break;


            }

            line = scanner.nextLine();
            tokens = line.split(" ");
            String foodType = tokens[0];
            int quantity = Integer.parseInt(tokens[1]);

            Food food = null;
            switch (foodType) {
                case "Vegetable": {
                    food = new Vegetable(quantity);
                }
                break;
                case "Meat": {
                    food = new Meat(quantity);
                }
            }

            animal.makeSound();
            animal.eat(food);
            animals.add(animal);

        }

        for (Animal animal :
                animals) {
            System.out.println(animal);
        }


    }
}

