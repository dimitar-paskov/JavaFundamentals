package EP06PokemonTrainer;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Trainer {
    String name;
    Integer numberOfbadges;
    ArrayList<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.numberOfbadges = 0;
        this.pokemons = new ArrayList<>();
    }

    public Integer getNumberOfbadges() {
        return numberOfbadges;
    }

    public void setNumberOfbadges(Integer numberOfbadges) {
        this.numberOfbadges = numberOfbadges;
    }

    public void increaseNumberOfbadgesByOne() {
        this.numberOfbadges += 1;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void removeDeadPockemons(){
        this.pokemons = this.pokemons.stream().filter(pokemon -> !pokemon.getDead()).collect(Collectors.toCollection(ArrayList::new));
    }
}
