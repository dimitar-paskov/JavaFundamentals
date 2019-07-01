package EP06PokemonTrainer;

public class Pokemon {
    String name;
    String element;
    Integer health;
    Boolean isDead;

    public Pokemon(String name, String element, Integer health) {
        this.name = name;
        this.element = element;
        this.health = health;
        this.isDead = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Boolean getDead() {
        return isDead;
    }

    public void setDead(Boolean dead) {
        isDead = dead;
    }

    public void decreaseHealth(int points){
        this.health -= points;
        if (this.health <= 0){
            this.isDead = true;
        }
    }
}
