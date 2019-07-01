package pizzaCalories;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split("\\s+");
        String name = tokens[1];
        int numberOfToppings = Integer.parseInt(tokens[2]);
        Pizza pizza = null;
        try {
            pizza = new Pizza(name, numberOfToppings);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return;
        }

        tokens = br.readLine().split("\\s+");
        String typeOfFlour = tokens[1];
        String bakingTechnique = tokens[2];
        double weightInGrams = Double.parseDouble(tokens[3]);

        try {
            Dough dough = new Dough(typeOfFlour, bakingTechnique, weightInGrams);
            pizza.setDough(dough);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return;
        }

        String line;
        while (!"END".equals(line=br.readLine())){
            tokens = line.split("\\s+");
            String nameOfTopping = tokens[1];
            double weight = Double.parseDouble(tokens[2]);
            Topping topping = null;
            try {
                topping = new Topping(nameOfTopping, weight);
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
                return;
            }
            pizza.addTopping(topping);

        }

        System.out.println(pizza.toString());


    }
}
