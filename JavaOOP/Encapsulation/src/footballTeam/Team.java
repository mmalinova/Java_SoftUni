package footballTeam;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team (String name) {
        setName(name);
        players = new ArrayList<>();
    }

    private void setName(String name) {
        if(!NameValidation.isNonEmpty(name)) {
            throw new IllegalArgumentException(ConstantMessages.INVALID_STRING_EXCEPTION);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void	addPlayer(Player player) {
        this.players.add(player);
    }

    public void	removePlayer(String playerName) {
        boolean isRemoved = this.players.removeIf(player -> player.getName().equals(playerName));
        if(!isRemoved) {
            throw new IllegalArgumentException("Player " + playerName + " is not in " + name + " team.");
        }
    }
//a rating (calculated by the average skill level of all players in the team)
    public double getRating() {
        return players.stream().mapToDouble(Player::overallSkillLevel).sum();
    }
}
