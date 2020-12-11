package store;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StoreTests {
    private Store store;
    private Product product;

    @Before
    public void setUp() {
        store = new Store();
        product = new Product("Fanta", 2, 2.40);
        store.addProduct(product);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetProductsShouldReturnUnmodifiableList() {
        store.getProducts().remove(product);
    }

    @Test
    public void testGetCountShouldReturnCorrectValue() {
        assertEquals(1, store.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProductShouldThExWhenProductIsNull() {
        store.addProduct(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProductShouldThExWhenQuantityIsLessOrEqualToZero() {
        store.addProduct(new Product("Coca-cola", 0, 1.2));
    }

    @Test
    public void testAddProductShouldAddProduct() {
        store.addProduct(new Product("Coca-cola", 1, 1.2));
        assertEquals(2, store.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyProductShouldThExWhenProductNotExist() {
        store.buyProduct("Crisp", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyProductShouldThExWhenThereIsNotEnoughQuantity() {
        store.buyProduct("Fanta", 5);
    }

    @Test
    public void testBuyProductShouldReturnCorrectPrice() {
        assertEquals(4.80, store.buyProduct("Fanta", 2), 0.0);
    }

    @Test
    public void testGetTheMostExpensiveProductShouldReturnCorrectProduct() {
        store.addProduct(new Product("Crisp", 3, 1.20));
        Product expected = store.getProducts().get(0);
        Product actual = store.getTheMostExpensiveProduct();
        assertEquals(expected, actual);
    }
}