package guild;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Guild {
    private ArrayList<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.roster = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    //•	Method addPlayer(Player player) - adds an entity to the roster if there is room for it
    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }
    //•	Method removePlayer(String name) - removes a player by given name, if such exists, and returns boolean
    public boolean removePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                this.roster.remove(player);
                return true;
            }
        }
        return false;
    }
    //•	Method promotePlayer(String name) - promote (set his rank to "Member") the first player with the given name. If the player is already a "Member", do nothing.
    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
                return;
            }
        }
    }
    //•	Method demotePlayer(String name)- demote (set his rank to "Trial") the first player with the given name. If the player is already a "Trial",  do nothing.
    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
                return;
            }
        }
    }
    //•	Method kickPlayersByClass(String clazz) - removes all the players by the given class and returns all removed players from that class as an array
    public Player[] kickPlayersByClass(String clazz) {
        ArrayList<Player> list = new ArrayList<>();
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                list.add(player);
                //this.roster.remove(player);
            }
        }
        this.roster.removeAll(list);
        Player[] player = new Player[list.size()];
        for (int i = 0; i < list.size(); i++) {
            player[i] = list.get(i);
        }
        return player;
    }
    //•	Method count() - returns the number of players
    public int count() {
        return this.roster.size();
    }
    //•	Method report() - returns a String in the following format:
    //o	"Players in the guild: {guildName}:
    //{Player1}
    //{Player2}
    //(…)"
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%nPlayers in the guild: %s:%n", this.name));
        for (Player player : roster) {
            sb.append(player.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
