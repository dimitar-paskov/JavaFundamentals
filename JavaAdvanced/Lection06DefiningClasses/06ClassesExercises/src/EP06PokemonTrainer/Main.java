package EP06PokemonTrainer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        String line = "";

        while (!"Tournament".equals(line = scanner.nextLine())){
            String[] tokens = line.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            Integer health = Integer.parseInt(tokens[3]);

            Pokemon newPockemon = new Pokemon(pokemonName, element, health);

            if (!trainers.containsKey(trainerName)) {
                trainers.put(trainerName, new Trainer(trainerName));
            }

            trainers.get(trainerName).getPokemons().add(newPockemon);

        }

        while (!"End".equals(line = scanner.nextLine())){
            String inElement = line;
            for (Trainer trainer:
                 trainers.values()) {
                if (trainer.getPokemons().stream().anyMatch(pokemon -> pokemon.element.equals(inElement))){
                    trainer.increaseNumberOfbadgesByOne();
                }else{
                    trainer.getPokemons().stream().forEach(pokemon -> pokemon.decreaseHealth(10));
                    trainer.removeDeadPockemons();
                }
            }

        }

        trainers.entrySet().stream()
                .sorted(Comparator.comparing(t -> -t.getValue().getNumberOfbadges()))
                .forEach(t->{
                    System.out.println(t.getKey() + " " + t.getValue().getNumberOfbadges() + " " + t.getValue().getPokemons().size());
        });


    }
}
