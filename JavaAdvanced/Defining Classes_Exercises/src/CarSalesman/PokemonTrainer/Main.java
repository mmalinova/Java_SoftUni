package PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Trainer> mapInfo = new LinkedHashMap<>();

        String command = scan.nextLine();
        while(!"Tournament".equals(command)) {
            //"<TrainerName> <PokemonName> <PokemonElement> <PokemonHealth>
            String[] tokens = command.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer trainer = new Trainer(trainerName);
            mapInfo.putIfAbsent(trainerName, trainer);
            mapInfo.get(trainerName).addPokemon(pokemon);
            command = scan.nextLine();
        }

        command = scan.nextLine();
        while(!"End".equals(command)) {
            String element = command;
            for (Trainer trainer : mapInfo.values()) {
                if(trainer.hasElement(element)) {
                    trainer.increaseBadges(1);
                } else {
                    trainer.damagePokemonsHealth(10);
                }
            }
            command = scan.nextLine();
        }

        mapInfo.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().getBudges() - e1.getValue().getBudges())
                .forEach(entry -> {
                    System.out.println(entry.getValue().toString());
                });
    }
}
