package lection02encapsulation;
public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) throws ValidationException {
        this.setName(name);
        this.setCost(cost);
    }


    public void setName(String name) throws ValidationException {
        if (name == null || name.isEmpty() || name.trim().length() < 1) {
            throw new ValidationException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setCost(double cost) throws ValidationException {
        if (cost < 0 ) {
            throw new ValidationException("Money cannot be negative");
        }
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
