package CounterStriker.core;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.common.OutputMessages;
import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ControllerImpl implements Controller{
    private GunRepository guns;
    private	PlayerRepository players;
    private	Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        switch (type) {
            case "Pistol":
                Pistol pistol = new Pistol(name, bulletsCount);
                guns.add(pistol);
                return String.format(OutputMessages.SUCCESSFULLY_ADDED_GUN, pistol.getName());
            case "Rifle":
                Rifle rifle = new Rifle(name, bulletsCount);
                guns.add(rifle);
                return String.format(OutputMessages.SUCCESSFULLY_ADDED_GUN, rifle.getName());
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_TYPE);
        }
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun byName = guns.findByName(gunName);
        if (byName == null) {
            throw new NullPointerException(ExceptionMessages.GUN_CANNOT_BE_FOUND);
        }
        switch (type) {
            case "Terrorist":
                Terrorist terrorist = new Terrorist(username, health, armor, byName);
                players.add(terrorist);
                return String.format(OutputMessages.SUCCESSFULLY_ADDED_PLAYER, terrorist.getUsername());
            case "CounterTerrorist":
                CounterTerrorist counterTerrorist =
                        new CounterTerrorist(username, health, armor, byName);
                players.add(counterTerrorist);
                return String.format(OutputMessages.SUCCESSFULLY_ADDED_PLAYER,
                        counterTerrorist.getUsername());
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }
    }

    @Override
    public String startGame() {
        List<Player> alivePlayers = players.getModels().stream().filter(Player::isAlive)
                .collect(Collectors.toList());
        return field.start(alivePlayers);
    }

    @Override
    public String report() {
        StringBuilder output = new StringBuilder();
        List<Player> player = new ArrayList<>(players.getModels());
        player.stream().sorted(Comparator.comparing(p -> p.getClass().getSimpleName()))
                .sorted(Comparator.comparing(Player::getHealth)
                .thenComparing(Player::getUsername)).forEach(p -> output.append(p.toString())
                .append(System.lineSeparator()));
        return output.toString().trim();
    }
}
