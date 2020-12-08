package computers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ComputerManagerTests {
    private Computer computer;
    private List<Computer> computers;
    private ComputerManager computerManager;

    @Before
    public void setUp() {
        computer = new Computer("Lenovo", "ThinkPad", 2000);
        computerManager = new ComputerManager();
        computerManager.addComputer(computer);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetComputersShouldReturnUnmodifiableList() {
        computerManager.getComputers().remove(computer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerShouldThExWhenComputerExist() {
        computerManager.addComputer(computer);
    }

    @Test
    public void testAddComputerShouldAddComputerWhenNotExist() {
        computerManager.addComputer(new Computer("Asus", "ROG", 1500));
        assertEquals(2, computerManager.getCount());
    }

    @Test
    public void testRemoveComputerShouldRemoveComputerWhenExist() {
        computerManager.removeComputer("Lenovo", "ThinkPad");
        assertEquals(0, computerManager.getCount());
    }

    @Test
    public void testRemoveComputerShouldReturnRemovedComputerWhenExist() {
        Computer expected = computer;
        Computer actual = computerManager.removeComputer("Lenovo", "ThinkPad");
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveComputerShouldThExWhenComputerNotExist() {
        computerManager.removeComputer("Acer", "Aspire");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputersByManufacturerShouldThExWhenIsNull() {
        computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void testGetComputersByManufacturerShouldReturnListOfComputers() {
        List<Computer> expected = new ArrayList<>();
        expected.add(computer);
        List<Computer> actual = computerManager.getComputersByManufacturer("Lenovo");
        assertEquals(expected, actual);
    }
}