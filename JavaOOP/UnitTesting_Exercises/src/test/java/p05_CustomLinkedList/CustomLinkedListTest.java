package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {
    private CustomLinkedList<String> customLinkedList;

    @Before
    public void createCustomLinkedList() {
        customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Gosho");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMethodShouldThrowExWhenIndexIsLessThenZero() {
        customLinkedList.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMethodShouldThrowExWhenIndexIsBiggerThenCount() {
        customLinkedList.get(1);
    }

    @Test()
    public void testGetMethodShouldReturnCorrectElement() {
        Assert.assertEquals("Gosho", customLinkedList.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetMethodShouldThrowExWhenIndexIsLessThenZero() {
        customLinkedList.set(-1, "Pesho");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetMethodShouldThrowExWhenIndexIsBiggerThenCount() {
        customLinkedList.set(1, "Pesho");
    }

    @Test()
    public void testSetMethodShouldSetCorrectElement() {
        customLinkedList.set(0, "Ivan");
        Assert.assertEquals("Ivan", customLinkedList.get(0));
    }

    @Test
    public void addMethodShouldAddElementInEmptyList() {
        customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Ivan");
        Assert.assertEquals("Ivan", customLinkedList.get(0));
    }

    @Test
    public void addMethodShouldAddElementInNonEmptyList() {
        customLinkedList.add("Mariika");
        Assert.assertEquals("Mariika", customLinkedList.get(1));
        Assert.assertEquals(1, customLinkedList.indexOf("Mariika"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtMethodShouldThrowExWhenIndexIsLessThenZero() {
        customLinkedList.removeAt(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtMethodShouldThrowExWhenIndexIsBiggerThenCount() {
        customLinkedList.removeAt(1);
    }

    @Test
    public void testRemoveAtMethodShouldReturnRemovedElement() {
        String toRemove = customLinkedList.get(0);
        Assert.assertEquals(toRemove, customLinkedList.removeAt(0));
    }

    @Test
    public void testRemoveMethodShouldReturnNegativeWhenElementIsNotFound() {
        Assert.assertEquals(-1, customLinkedList.remove("Velin"));
    }

    @Test
    public void testRemoveMethodShouldReturnIndexOfElementWhenPresent() {
        Assert.assertEquals(0, customLinkedList.remove("Gosho"));
    }

    @Test
    public void testIndexOfMethodShouldReturnNegativeWhenElementIsNotFound() {
        Assert.assertEquals(-1, customLinkedList.indexOf("Velin"));
    }

    @Test
    public void testIndexOfMethodShouldReturnCorrectIndexWhenElementPresent() {
        Assert.assertEquals(0, customLinkedList.indexOf("Gosho"));
    }

    @Test
    public void testContainsMethodShouldReturnFalseIfItemNotPresent() {
        Assert.assertFalse(customLinkedList.contains("Petar"));
    }

    @Test
    public void testContainsMethodShouldReturnTrueIfItemPresent() {
        Assert.assertTrue(customLinkedList.contains("Gosho"));
    }
}
