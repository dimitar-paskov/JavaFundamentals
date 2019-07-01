package p03wildFarm;

public class Tiger extends Felime {


    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("ROAAR!!!");
    }


    @Override
    protected void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")){
            super.eat(food);
        }else{
            System.out.println("Tigers are not eating that type of food!");
        }

    }
}
