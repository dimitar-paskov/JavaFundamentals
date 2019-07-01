package heroRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeroRepository {
    private List<Hero> data;

    public HeroRepository() {
        this.data = new ArrayList<>();
    }

    public void add(Hero entity){
        data.add(entity);
    }

    public void remove(String name){
//        this.data = this.data.stream().filter(x->!x.getName().equals(name)).collect(Collectors.toList());
        for (int i = this.data.size()-1; i >=0 ; i--) {
            if (this.data.get(i).getName().equals(name)){
                this.data.remove(i);
            }
        }

    }

    public Hero getHeroWithHighestStrength(){
        Hero hero = this.data.get(0);

        int maxStrength = hero.getStrengthOfItem();
        for (int i = 1; i < this.data.size(); i++) {
            if (this.data.get(i).getStrengthOfItem() > maxStrength){
                maxStrength = this.data.get(i).getStrengthOfItem();
                hero = this.data.get(i);
            }
        }

        return hero;

    }

    public Hero getHeroWithHighestAgility(){
        Hero hero = this.data.get(0);

        int maxAgility = hero.getAgilityOfItem();
        for (int i = 1; i < this.data.size(); i++) {
            if (this.data.get(i).getAgilityOfItem() > maxAgility){
                maxAgility = this.data.get(i).getAgilityOfItem();
                hero = this.data.get(i);
            }
        }

        return hero;

    }


    public Hero getHeroWithHighestIntelligence(){
        Hero hero = this.data.get(0);

        int maxIntelligence = hero.getIntelligenceOfItem();
        for (int i = 1; i < this.data.size(); i++) {
            if (this.data.get(i).getIntelligenceOfItem() > maxIntelligence){
                maxIntelligence = this.data.get(i).getIntelligenceOfItem();
                hero = this.data.get(i);
            }
        }

        return hero;

    }


    public int getCount(){
        return this.data.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.data.size(); i++) {
            sb.append(this.data.get(i).toString());
        }
        return sb.toString();
    }
}
