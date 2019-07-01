package p01vehicles;
public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    void drive(double distance) throws ValidationException {
        if (distance * this.getFuelConsumption() > this.getFuelQuantity()){
            throw new ValidationException("Car needs refueling");
        }

        this.setFuelQuantity(this.getFuelQuantity() - (distance * this.getFuelConsumption()) );

    }

    @Override
    void refuel(double refilQuantity){
        super.setFuelQuantity(this.getFuelQuantity() + refilQuantity);
    }

    @Override
    void setFuelQuantity(double fuelQuantity) {
        super.setFuelQuantity(fuelQuantity);
    }

    @Override
    void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 0.9);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", this.getFuelQuantity());
    }
}
