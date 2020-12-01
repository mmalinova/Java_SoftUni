package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void testSortMethodShouldSortArray() {
        int[] array = {34, 69, 72, 1, 0, -5};
        Bubble.sort(array);
        int[] sortedArray = {-5, 0, 1, 34, 69, 72};
        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(sortedArray[i], array[i]);
        }
    }
}
