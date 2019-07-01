package p03wildFarm;

public class Mouse extends Mammal {
    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    protected void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")){
            super.eat(food);
        }else{
            System.out.println("Mice are not eating that type of food!");
        }

    }
}
