package halfLife;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTests {
    private Player player;
    private List<Player> playerList;
    private Gun gun;
    private List<Gun> guns;

    @Before
    public void setUp() {
        playerList = new ArrayList<>();
        player = new Player("Pesho", 120);
        playerList.add(player);
        guns = new ArrayList<>();
        gun = new Gun("Pistol", 30);
        guns.add(gun);
    }

    @Test(expected = NullPointerException.class)
    public void testPlayerConstructorShouldThrowExWhenUsernameIsNull() {
        player = new Player(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testPlayerConstructorShouldThrowExWhenUsernameTrimmedIsNUll() {
        player = new Player("   ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayerConstructorShouldThrowExWhenHealthIsLessThanZero() {
        player = new Player("Gosho", -1);
    }

    @Test
    public void testConstructorShouldCreateCorrectPlayer() {
        Player secondPlayer = new Player("Gosho", 50);
        playerList.add(secondPlayer);
        assertEquals(2, playerList.size());
        assertEquals("Gosho", playerList.get(1).getUsername());
        assertEquals(50, playerList.get(1).getHealth());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnmodifiableCollectionShouldThrowExWhenRemove() {
        player.getGuns().remove(0);
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageShouldThrowExWhenHealthIsLessThanZero() {
        player = new Player("Sasho", 0);
        player.takeDamage(120);
    }

    @Test
    public void testTakeDamageShouldSetHealthToZero() {
        player.takeDamage(130);
        assertEquals(0, player.getHealth());
    }

    @Test
    public void testTakeDamageShouldDecreaseHealth() {
        player.takeDamage(30);
        assertEquals(90, player.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullGunShouldThrowEx() {
        player.addGun(null);
    }

    @Test
    public void testAddGunShouldAddCorrectGun() {
        Gun secondGun = new Gun("Pistol", 5);
        guns.add(secondGun);
        assertEquals(2, guns.size());
        assertEquals("Pistol", guns.get(1).getName());
        assertEquals(5, guns.get(1).getBullets());
    }

    @Test
    public void testRemoveExistingGun() {
        player.addGun(gun);
        boolean removeGun = player.removeGun(gun);
        assertTrue(removeGun);
    }

    @Test
    public void testGetGunShouldReturnFirstGunWithThatName() {
        player.addGun(gun);
        player.addGun(new Gun("Gun", 55));
        player.addGun(new Gun("Pistol", 22));
        assertEquals(3, player.getGuns().size());
        assertEquals(30, player.getGun("Pistol").getBullets());
    }
}
