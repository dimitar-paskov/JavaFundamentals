package p01vehicles;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    abstract void drive(double distance)throws ValidationException;

    abstract void refuel(double refilQuantity);

     void setFuelQuantity(double fuelQuantity){
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


}
