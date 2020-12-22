package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Collection<Player> civils;
    private MainPlayer mainPlayer;
    private Deque<Gun> guns;
    private GangNeighbourhood gangNeighbourhood;

    public ControllerImpl() {
        civils = new ArrayList<>();
        mainPlayer = new MainPlayer();
        guns = new ArrayDeque<>();
        gangNeighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        CivilPlayer player = new CivilPlayer(name);
        this.civils.add(player);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        if ("Pistol".equals(type)) {
            gun = new Pistol(name);
            this.guns.add(gun);
            return String.format(GUN_ADDED, name, type);
        } else if ("Rifle".equals(type)) {
            gun = new Rifle(name);
            this.guns.add(gun);
            return String.format(GUN_ADDED, name, type);
        } else {
            return GUN_TYPE_INVALID;
        }
    }

    @Override
    public String addGunToPlayer(String name) {
        if (this.guns.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }

        Gun gun = this.guns.peek();

        if (name.contains("Vercetti")) {
            mainPlayer.getGunRepository().add(gun);
            this.guns.poll();
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), "Tommy Vercetti");

        }

        Player player = this.civils.stream().filter(player1 -> player1.getName().equals(name)).findFirst().orElse(null);
        if (player == null) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        player.getGunRepository().add(gun);
        this.guns.poll();
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
    }

    @Override
    public String fight() {
        StringBuilder sb = new StringBuilder();

        int mainPlayerPoints = mainPlayer.getLifePoints();
        long civilPlayersPoints = civils.stream().filter(Player::isAlive).count();

        gangNeighbourhood.action(mainPlayer, civils);

        int mainPlayerPointsAfter = mainPlayer.getLifePoints();
        long civilPlayersPointsAfter = civils.stream().filter(Player::isAlive).count();

        if (mainPlayerPoints == mainPlayerPointsAfter && civilPlayersPoints == civilPlayersPointsAfter) {
            return FIGHT_HOT_HAPPENED;
        }
            //"A fight happened:"
            //"Tommy live points: {main player life points}!"
            //"Tommy has killed: {dead civil players} players!"
            //"Left Civil Players: {civil players count}!"

            sb.append(FIGHT_HAPPENED).append(System.lineSeparator());
            sb.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayerPointsAfter))
                    .append(System.lineSeparator());
            sb.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, civilPlayersPoints
                    - civilPlayersPointsAfter))
                    .append(System.lineSeparator());
            sb.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, civilPlayersPointsAfter));

        return sb.toString().trim();
    }
}
