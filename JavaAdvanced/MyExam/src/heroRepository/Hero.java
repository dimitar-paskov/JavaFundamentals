package heroRepository;

public class Hero {
    private String name;
    private int level;
    private Item item;

    public Hero(String name, int level, Item item) {
        this.name = name;
        this.level = level;
        this.item = item;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public Item getItem() {
        return this.item;
    }

    public int getStrengthOfItem(){
        return this.item.getStrength();
    }

    public int getAgilityOfItem(){
        return this.item.getAgility();
    }

    public int getIntelligenceOfItem(){
        return this.item.getIntelligence();
    }

    @Override
    public String toString() {
        return "Hero: " + this.name + " – " +this.level+ "\n" + this.item.toString();
//        "  *  Strength: " + this.item.getStrength() +
//        "  *  Agility: " + this.item.getAgility() +
//        "  *  Intelligence: "+ this.item.getIntelligence();
    }


}
