import heroRepository.Hero;
import heroRepository.HeroRepository;
import heroRepository.Item;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        //Initialize the repository
        HeroRepository repository = new HeroRepository();
        System.out.println(repository);
//Initialize entity
        Item item = new Item(23, 35, 48);
//Print Item
        System.out.println(item);

//Item:
//  * Strength: 23
//  * Agility: 35
//  * Intelligence: 48

//Initialize entity
        Hero hero = new Hero("Hero Name", 24, item);
//Print Hero
        System.out.println(hero);

//Hero: Hero Name – 24
//Item:
//  * Strength: 23
//  * Agility: 35
//  * Intelligence: 48

//Add Hero
        repository.add(hero);
//Remove Hero
        repository.remove("Hero Name");

        Item secondItem = new Item(100, 20, 13);
        Hero secondHero = new Hero("Second Hero Name", 125, secondItem);

//Add Heroes
        repository.add(hero);
        repository.add(secondHero);

        Hero heroStrength = repository.getHeroWithHighestStrength(); //returns secondHero
        System.out.println(heroStrength);
        Hero heroAbility = repository.getHeroWithHighestAgility(); //returns hero
        System.out.println(heroAbility);
        Hero heroIntelligence = repository.getHeroWithHighestIntelligence(); //returns hero
        System.out.println(heroIntelligence);

        System.out.println("--------------");
        System.out.println(repository);
//Hero: Hero Name – 24
//Item:
//  * Strength: 23
//  * Agility: 35
//  * Intelligence: 48
//Hero: Second Hero Name – 125
//Item:
//  * Strength: 100
//  * Agility: 20
//  * Intelligence: 13

    }
}
