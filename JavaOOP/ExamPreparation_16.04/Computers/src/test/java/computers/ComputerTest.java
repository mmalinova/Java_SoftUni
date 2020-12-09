package computers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ComputerTest {
    private Computer computer;

    @Before
    public void setUp() {
        this.computer = new Computer("Lenovo");
        fillComputerWhitParts();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThExWhenNameIsNull() {
        computer = new Computer(null);
    }

    @Test
    public void testConstructorShouldCreateComputer() {
        computer = new Computer("Acer");
        assertNotNull(computer);
    }

    @Test
    public void testGetNameShouldReturnCorrectName() {
        assertEquals("Lenovo", computer.getName());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetPartsShouldReturnUnmodifiableList() {
        computer.getParts().add(new Part("Mouse", 35));
    }

    @Test
    public void testGetTotalPriceShouldReturnCorrectValue() {
        assertEquals(710.5, computer.getTotalPrice(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPartShouldThExWhenPartIsNull() {
        computer.addPart(null);
    }

    @Test
    public void testAddPartShouldAddPart() {
        computer.addPart(new Part("Mouse", 35));
        assertEquals("Mouse", computer.getParts().get(computer.getParts().size() - 1).getName());
    }

    @Test
    public void testRemoveShouldRemovePart() {
        assertTrue(computer.removePart(computer.getPart("Monitor")));
        assertEquals(2, computer.getParts().size());
    }

    @Test
    public void testGetPartShouldReturnFirstMatchPart() {
        Part actual = computer.getPart("Monitor");
        assertEquals("Monitor", actual.getName());
    }

    private void fillComputerWhitParts() {
        this.computer.addPart(new Part("Monitor", 130));
        this.computer.addPart(new Part("Keyboard", 30));
        this.computer.addPart(new Part("Processor", 550.50));
    }
}