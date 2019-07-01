package p02vehiclesExtension;

public abstract class Vehicle {

    private double tankCapacity;
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) throws ValidationException {
        this.tankCapacity = tankCapacity;
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    abstract void drive(double distance)throws ValidationException;

    abstract void refuel(double refilQuantity) throws ValidationException;

     void setFuelQuantity(double fuelQuantity) throws ValidationException {
         if (fuelQuantity <= 0){
             throw new ValidationException("Fuel must be a positive number");
         }
         if (fuelQuantity > this.tankCapacity){
             throw new ValidationException("Cannot fit fuel in tank");
         }
         this.fuelQuantity = fuelQuantity;
     }

     void setFuelConsumption(double fuelConsumption){
         this.fuelConsumption = fuelConsumption;
     }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }
}
