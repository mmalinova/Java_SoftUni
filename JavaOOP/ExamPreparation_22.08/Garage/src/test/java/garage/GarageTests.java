package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GarageTests {
    private Garage garage;
    private Car car;

    @Before
    public void setUp() {
        this.garage = new Garage();
        this.car = new Car("Golf", 160, 1200);
        this.garage.addCar(car);
        this.garage.addCar(new Car("Mazda", 120, 1000));
        this.garage.addCar(new Car("Rav4", 180, 12000));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetCarsShouldReturnUnmodifiableList() {
        this.garage.getCars().remove(car);
    }

    @Test
    public void testGetCountShouldReturnCorrectValue() {
        assertEquals(3, this.garage.getCount());
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAboveShouldReturnCorrectValues() {
        List<Car> expected = new ArrayList<>();
        expected.add(this.garage.getCars().get(0));
        expected.add(this.garage.getCars().get(2));
        List<Car> actual = this.garage.findAllCarsWithMaxSpeedAbove(150);
        assertEquals(expected, actual);
        assertEquals(2, actual.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarShouldThExWhenCarIsNull() {
        this.garage.addCar(null);
    }

    @Test
    public void testAddCarShouldAddNotNullCar() {
        this.garage.addCar(new Car("Seat", 100, 550));
        assertEquals(4, this.garage.getCount());
    }

    @Test
    public void testGetTheMostExpensiveCarShouldReturnCorrectCar() {
        Car expected = this.garage.getCars().get(2);
        Car actual = this.garage.getTheMostExpensiveCar();
        assertEquals(expected, actual);
    }

    @Test
    public void testFindAllCarsByBrandShouldReturnCorrectCars() {
        List<Car> expected = new ArrayList<>();
        expected.add(this.garage.getCars().get(2));
        List<Car> actual = this.garage.findAllCarsByBrand("Rav4");
        assertEquals(expected, actual);
    }
}