package CounterStriker.models.field;

import CounterStriker.common.OutputMessages;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FieldImpl implements Field{
    private List<Player> counterTerrorists;
    private List<Player> terrorists;

    public FieldImpl() {
        counterTerrorists = new ArrayList<>();
        terrorists = new ArrayList<>();
    }

    @Override
    public String start(Collection<Player> players) {
        for (Player player : players) {
            if (player instanceof Terrorist) {
                terrorists.add(player);
            } else if (player instanceof CounterTerrorist) {
                counterTerrorists.add(player);
            }
        }

        while(counterTerrorists.stream().anyMatch(Player::isAlive) &&
                terrorists.stream().anyMatch(Player::isAlive)) {
            for (Player terrorist : terrorists) {
                for (Player counterTerrorist : counterTerrorists) {
                    counterTerrorist.takeDamage(terrorist.getGun().fire());
                }
            }
            counterTerrorists = counterTerrorists.stream().filter(Player::isAlive).collect(Collectors.toList());
            for (Player counterTerrorist : counterTerrorists) {
                for (Player terrorist : terrorists) {
                    terrorist.takeDamage(counterTerrorist.getGun().fire());
                }
            }
            terrorists = terrorists.stream().filter(Player::isAlive).collect(Collectors.toList());
        }

        if (terrorists.stream().anyMatch(Player::isAlive)) {
            return OutputMessages.TERRORIST_WINS;
        } else {
            return OutputMessages.COUNTER_TERRORIST_WINS;
        }
    }
}
