package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipTests {
    private Spaceship spaceship;
    private Astronaut astronaut;

    @Before
    public void setUp() {
        spaceship = new Spaceship("Az", 2);
        astronaut = new Astronaut("Ameli", 450);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstrThExWhenCapacity() {
        spaceship = new Spaceship("Az", -1);
    }

    @Test(expected = NullPointerException.class)
    public void testConstrThExWhenName() {
        spaceship = new Spaceship("  ", 20);
    }

    @Test
    public void testConst() {
        spaceship = new Spaceship("Pesho", 230);
        assertEquals(230, spaceship.getCapacity());
        assertEquals("Pesho", spaceship.getName());
        assertEquals(0, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThExWhenSize() {
        spaceship.add(astronaut);
        spaceship.add(new Astronaut("Gosho", 23));
        spaceship.add(new Astronaut("Maria", 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThExWhenExist() {
        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }

    @Test
    public void testAdd() {
        spaceship.add(astronaut);
        assertEquals(1, spaceship.getCount());
    }

    @Test
    public void testRemove() {
        spaceship.add(astronaut);
        assertTrue(spaceship.remove("Ameli"));
    }

    @Test
    public void testRemoveFalse() {
        assertFalse(spaceship.remove("Ameli"));
    }
}
