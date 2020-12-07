package CounterStriker.repositories;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerRepository implements Repository<Player>{
    private Collection<Player> players;

    public PlayerRepository() {
        this.players = new ArrayList<>();
    }

    @Override
    public Collection<Player> getModels() {
        return this.players;
    }

    @Override
    public void add(Player player) {
        if (player == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_PLAYER_REPOSITORY);
        }
        this.players.add(player);
    }

    @Override
    public boolean remove(Player player) {
        return players.remove(player);
    }

    @Override
    public Player findByName(String name) {
        return players.stream().filter(player -> player.getUsername().equals(name))
                .findFirst().orElse(null);
    }
}
