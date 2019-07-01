package pizzaCalories;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) throws ValidationException {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) throws ValidationException {
        if ("Meat".equalsIgnoreCase(toppingType)
                || "Veggies".equalsIgnoreCase(toppingType)
                || "Sauce".equalsIgnoreCase(toppingType)
                || "Cheese".equalsIgnoreCase(toppingType)){
            this.toppingType = toppingType;
            return;
        }
        throw new ValidationException(String.format("Cannot place %s on top of your pizza.", toppingType));

    }

    private void setWeight(double weight) throws ValidationException {
        if (weight < 1 || 50 < weight){
            throw new ValidationException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        double toppingModifier = 0;
        switch (this.toppingType){
            case "Meat": toppingModifier = 1.2;break;
            case "Veggies": toppingModifier = 0.8;break;
            case "Cheese": toppingModifier = 1.1;break;
            case "Sauce": toppingModifier = 0.9;break;
        }

        return (this.weight*2)* toppingModifier;
    }
}
