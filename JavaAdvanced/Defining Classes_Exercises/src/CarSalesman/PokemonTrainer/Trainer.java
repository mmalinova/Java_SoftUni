package PokemonTrainer;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Trainer {
    private String name;
    private int numberOgBudges;
    private LinkedHashMap<String, ArrayList<Pokemon>> pokemons;

    public Trainer(String trainerName) {
        this.name = trainerName;
        this.numberOgBudges = 0;
        this.pokemons = new LinkedHashMap<>();
        setPokemons(this.pokemons);
    }

    private void setPokemons(LinkedHashMap<String, ArrayList<Pokemon>> pokemons) {
        this.pokemons.putIfAbsent("Fire", new ArrayList<>());
        this.pokemons.putIfAbsent("Water", new ArrayList<>());
        this.pokemons.putIfAbsent("Electricity", new ArrayList<>());
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.putIfAbsent(pokemon.getElement(), new ArrayList<>());
        this.pokemons.get(pokemon.getElement()).add(pokemon);
    }

    public boolean hasElement(String element) {
        return this.pokemons.get(element).size() != 0;
    }

    public void increaseBadges(int increment) {
        this.numberOgBudges += increment;
    }

    public void damagePokemonsHealth(int damage) {
        for (ArrayList<Pokemon> s : pokemons.values()) {
            for (Pokemon pokemon : s) {
                pokemon.takeDamage(damage);
            }
        }
        this.clearPokemons();
    }

    private  void clearPokemons() {
        for (ArrayList<Pokemon> value : pokemons.values()) {
            value.removeIf(p -> p.getHealth() <= 0);
        }
    }

    public int getBudges() {
        return this.numberOgBudges;
    }

    public int getPokemonsCount(){
        int count = 0;
        for (ArrayList<Pokemon> value : pokemons.values()) {
            count += value.size();
        }
        return count;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOgBudges, getPokemonsCount());
    }
}
