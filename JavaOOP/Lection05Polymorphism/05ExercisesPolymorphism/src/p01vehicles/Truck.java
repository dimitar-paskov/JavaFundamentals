package p01vehicles;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    void drive(double distance) throws ValidationException {
        if (distance * this.getFuelConsumption() > this.getFuelQuantity()){
            throw new ValidationException("Truck needs refueling");
        }

        this.setFuelQuantity(this.getFuelQuantity() - (distance * this.getFuelConsumption()) );

    }

    @Override
    void refuel(double refilQuantity){
        super.setFuelQuantity(this.getFuelQuantity() + (0.95*refilQuantity));
    }

    @Override
    void setFuelQuantity(double fuelQuantity) {
        super.setFuelQuantity(fuelQuantity);
    }

    @Override
    void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 1.6);
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", this.getFuelQuantity());
    }
}
