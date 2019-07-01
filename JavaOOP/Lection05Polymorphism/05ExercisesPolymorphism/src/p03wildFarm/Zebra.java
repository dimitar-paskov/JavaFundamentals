package p03wildFarm;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("Zs");
    }

    @Override
    protected void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")){
            super.eat(food);
        }else{
            System.out.println("Zebras are not eating that type of food!");
        }

    }
}
