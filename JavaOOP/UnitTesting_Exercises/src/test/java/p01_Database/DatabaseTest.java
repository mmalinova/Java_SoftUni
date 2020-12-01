package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private final static Integer[] NUMBERS = {13, 42, 69, 72};
    private Database database;

    @Before
    public void createDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorHasToCreateValidObject() {
        Integer[] databaseElements = database.getElements();
        Assert.assertEquals("Count of elements is incorrect!", databaseElements.length, NUMBERS.length);

        for (int i = 0; i < databaseElements.length; i++) {
            Assert.assertEquals(NUMBERS[i], databaseElements[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testElementsCountShouldNotBeMoreThan16() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test(expected =  OperationNotSupportedException.class)
    public void testElementsCountShouldBeMoreThanZero() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullElementShouldThrowEx() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testShouldAddNotNullElement() throws OperationNotSupportedException {
        database.add(3);
        Integer[] databaseElements = database.getElements();
        Assert.assertEquals(5, databaseElements.length);
        Assert.assertEquals(Integer.valueOf(3), databaseElements[databaseElements.length - 1]);
    }

    @Test
    public void testRemoveShouldRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Integer[] databaseElements = database.getElements();
        Assert.assertEquals(3, database.getElements().length);
        Assert.assertEquals(Integer.valueOf(69), databaseElements[databaseElements.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowExWhenIndexIsOutOfBounds() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }
}
