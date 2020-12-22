package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood{
    public GangNeighbourhood() {
    }

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Collection<Gun> guns = mainPlayer.getGunRepository().getModels();
        for (Gun gun : guns) {

                for (Player civilPlayer : civilPlayers) {

                        while (civilPlayer.isAlive() && gun.canFire()) {
                            civilPlayer.takeLifePoints(gun.fire());
                        }

                        if (!gun.canFire()) {
                            break;
                        }
                }
        }


        for (Player civilPlayer : civilPlayers) {
            if (!civilPlayer.isAlive()) {
                continue;
            }

            Collection<Gun> gunsCivil = civilPlayer.getGunRepository().getModels();

            for (Gun gun : gunsCivil) {

                while (mainPlayer.isAlive() && gun.canFire()) {
                    mainPlayer.takeLifePoints(gun.fire());
                }

                if (!mainPlayer.isAlive()) {
                    break;
                }
            }

            if (!mainPlayer.isAlive()) {
                break;
            }
        }
    }
}
