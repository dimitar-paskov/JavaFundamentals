package EP04RawData;
import java.util.LinkedList;

public class Car {
    String model;
    Engine engine;
    Cargo cargo;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public LinkedList<Tyre> getTyres() {
        return tyres;
    }

    public void setTyres(LinkedList<Tyre> tyres) {
        this.tyres = tyres;
    }

    LinkedList<Tyre> tyres;



    public Car(String model, Integer engineSpeed, Integer enginePower, Integer cargoWeight, String cargoType, Double tire1Pressure, Integer tire1Age, Double tire2Pressure, Integer tire2Age, Double tire3Pressure, Integer tire3Age, Double tire4Pressure, Integer tire4Age) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        Tyre tyre1 = new Tyre(tire1Pressure, tire1Age);
        Tyre tyre2 = new Tyre(tire2Pressure, tire2Age);
        Tyre tyre3 = new Tyre(tire3Pressure, tire3Age);
        Tyre tyre4 = new Tyre(tire4Pressure, tire4Age);
        this.tyres = new LinkedList<>();
        this.tyres.add(tyre1);
        this.tyres.add(tyre2);
        this.tyres.add(tyre3);
        this.tyres.add(tyre4);
    }

    public boolean isTyreFlat(){
        for (int i = 0; i < 4; i++) {
            if (this.tyres.get(i).pressure < 1){
                return true;
            }
        }

        return false;
    }

    public boolean isEngineEvil(){
        if (this.engine.power > 250){
            return true;
        }else{
            return false;
        }

    }
}
