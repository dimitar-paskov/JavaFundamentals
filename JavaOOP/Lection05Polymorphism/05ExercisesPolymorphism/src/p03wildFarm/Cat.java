package p03wildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {

    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",this.getAnimalType(), this.getAnimalName(),this.breed ,df.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());

        //Tiger[Typcho, 167.7, Asia, 0]
    }


}
