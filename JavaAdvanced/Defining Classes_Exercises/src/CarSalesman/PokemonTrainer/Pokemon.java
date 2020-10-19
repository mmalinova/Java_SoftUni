package PokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String pokemonName, String pokemonElement, int pokemonHealth) {
        this.name = pokemonName;
        this.element = pokemonElement;
        this.health = pokemonHealth;
    }

    public String getElement() {
        return this.element;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public int getHealth() {
        return this.health;
    }
}
