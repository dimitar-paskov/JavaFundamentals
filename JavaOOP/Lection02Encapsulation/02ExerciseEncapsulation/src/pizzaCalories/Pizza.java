package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private int numberOfToppings;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) throws ValidationException {
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    private void setName(String name) throws ValidationException {
        if (name.trim().length() < 1 || name.trim().length() > 15){
            throw new ValidationException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping (Topping topping){
        this.toppings.add(topping);
    }

    private void setToppings(int numberOfToppings) throws ValidationException {
        if (numberOfToppings < 0 || 10 < numberOfToppings){
            throw new ValidationException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;

    }


    //FIXME check if stream calculates correct precision;
    public double getOverallCalories (){
        int a = 8;
        return this.dough.calculateCalories() + this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, this.getOverallCalories());
        //Meatless – 370.00
    }
}
