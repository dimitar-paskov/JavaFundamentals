package EP07Google;

public class Car {
    String model;
    String speed;

    public Car(String model, String speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n", this.model, this.speed);
    }
}
