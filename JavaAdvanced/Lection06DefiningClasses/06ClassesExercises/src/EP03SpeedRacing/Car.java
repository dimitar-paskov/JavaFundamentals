package EP03SpeedRacing;

public class Car {

    String model;
    Double fuelAmount;
    Double fuelCostPerkilometer;
    Integer distanceTraveled;

    public Car(String model, Double fuelAmount, Double fuelCostPerkilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerkilometer = fuelCostPerkilometer;
        this.distanceTraveled = 0;
    }

    public void drive(Integer distance){
        if (this.fuelCostPerkilometer * distance > this.fuelAmount){
            System.out.println("Insufficient fuel for the drive");
        }else{
            this.distanceTraveled += distance;
            this.fuelAmount -= (this.fuelCostPerkilometer * distance);
        }

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(Double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public Double getFuelCostPerkilometer() {
        return fuelCostPerkilometer;
    }

    public void setFuelCostPerkilometer(Double fuelCostPerkilometer) {
        this.fuelCostPerkilometer = fuelCostPerkilometer;
    }

    public Integer getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(Integer distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }
}
