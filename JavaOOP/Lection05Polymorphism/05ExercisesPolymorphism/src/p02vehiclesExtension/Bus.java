package p02vehiclesExtension;

public class Bus extends Vehicle {
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) throws ValidationException {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    void drive(double distance) throws ValidationException {
        if (distance * this.getFuelConsumption() > this.getFuelQuantity()){
            throw new ValidationException("Bus needs refueling");
        }

        this.setFuelQuantity(this.getFuelQuantity() - (distance * this.getFuelConsumption()) );

    }


    void driveEmpty(double distance) throws ValidationException {
        if (distance * (this.getFuelConsumption() - 1.4) > this.getFuelQuantity()){
            throw new ValidationException("Bus needs refueling");
        }

        this.setFuelQuantity(this.getFuelQuantity() - (distance * this.getFuelConsumption()) );

    }

    @Override
    void refuel(double refilQuantity)throws ValidationException{
        if (refilQuantity + this.getFuelQuantity() > this.getTankCapacity()){
            throw new ValidationException("Cannot fit fuel in tank");
        }
        if (refilQuantity <= 0){
            throw new ValidationException("Fuel must be a positive number");
        }

        super.setFuelQuantity(this.getFuelQuantity() + refilQuantity);
    }

    @Override
    void setFuelQuantity(double fuelQuantity) throws ValidationException{
        super.setFuelQuantity(fuelQuantity);
    }

    @Override
    void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 1.4);
    }

    @Override
    public String toString() {
        return String.format("Bus: %.2f", this.getFuelQuantity());
    }
}
