package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private static final String[] STRINGS = new String[]{"First", "Second", "Third"};
    private ListIterator listIterator;

    @Before
    public void createListIterator() throws OperationNotSupportedException {
        listIterator = new ListIterator(STRINGS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowExWhenAddNullElement() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testHasNextShouldReturnCorrectBooleanValue() {
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    //separate
    @Test
    public void testHasNextShouldReturnTrueIfThereIsNextElement() {
        Assert.assertTrue(listIterator.hasNext());
    }

    //separate
    @Test
    public void testHasNextShouldReturnFalseIfThereIsNoNextElement() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMoveShouldReturnCorrectBooleanValue() {
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.move());
    }

    //separate
    @Test
    public void testMoveShouldReturnTrueIfThereIsNextElement() {
        Assert.assertTrue(listIterator.move());
    }

    //separate
    @Test
    public void testMoveShouldReturnFalseIfThereIsNoNextElement() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        Assert.assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintShouldThrowExWhenThereIsNoElements() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintShouldReturnCorrectString() {
        int index = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(STRINGS[index], listIterator.print());
            index++;
            listIterator.move();
        }
    }
}