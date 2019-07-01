package EP05CarSalesman;

public class Engine {
    private static final String notAvailable = "n/a";
    String model;
    String power;
    String displacement;
    String efficiency;

    public Engine(String model, String power) {
        this.model = model;
        this.power = power;
        this.displacement = Engine.notAvailable;
        this.efficiency = Engine.notAvailable;
    }

    public Engine(String model, String power, String displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, String power, String displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }



    @Override
    public String toString() {
        return String.format("%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s%n", this.model, this.power, this.displacement,this.efficiency);
    }
}
