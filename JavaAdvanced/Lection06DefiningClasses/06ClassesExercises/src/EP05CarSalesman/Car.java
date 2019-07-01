package EP05CarSalesman;

public class Car {
    private static final String notAvailable = "n/a";

    String model;
    Engine engine;
    String weight;
    String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = Car.notAvailable;
        this.color = Car.notAvailable;
    }

    public Car(String model, Engine engine, String weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n%sWeight: %s%nColor: %s%n", this.model, this.engine.toString(),this.weight, this.color );
    }
}
