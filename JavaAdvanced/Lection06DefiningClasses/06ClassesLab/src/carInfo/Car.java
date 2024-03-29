package carInfo;

public class Car {

    public static final String unknown = "unknown";

    private String make;
    private String model;
    private int horsePower;

    public Car(String make, String model, int horsePower) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car(String make){
        this();
        this.make = make;
    }

    public Car(){
        this.make = unknown;
        this.model = unknown;
        this.horsePower = -1;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getInfo(){
        return String.format("The car is: %s %s - %d HP.",this.make, this.model, this.horsePower);
    }
}
