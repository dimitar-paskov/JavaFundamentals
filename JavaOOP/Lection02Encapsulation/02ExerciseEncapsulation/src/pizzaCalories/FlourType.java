package pizzaCalories;

public enum FlourType {
    white(1.5),
    wholegrain(1.0);


    double value;
    FlourType(double value){
        this.value = value;
    }

}
