package bakery.entities.tables;

import bakery.common.ExceptionMessages;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {
    private Collection<BakedFood> foodOrders;
    private	Collection<Drink> drinkOrders;

    private	int tableNumber;
    private	int capacity;
    private	int numberOfPeople;
    private	double pricePerPerson;
    private	boolean isReserved;
    private double price;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
        this.tableNumber = tableNumber;
        setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return tableNumber;
    }

    @Override
    public double getPricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return getPricePerPerson() * getNumberOfPeople();
    }

    @Override
    public void reserve(int numberOfPeople) {
        if(numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.isReserved = true;
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public void orderFood(BakedFood food) {
        foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double food = foodOrders.stream().mapToDouble(BakedFood::getPrice).sum();
        double drinks = drinkOrders.stream().mapToDouble(Drink::getPrice).sum();
        return food + drinks + getPrice();
    }

    @Override
    public void clear() {
        drinkOrders.clear();
        foodOrders.clear();
        numberOfPeople = 0;
        isReserved = false;
        price = 0;
    }

    @Override
    public String getFreeTableInfo() {
        String sb = String.format("Table: %d", getTableNumber()) + System.lineSeparator() +
                String.format("Type: %s", getClass().getSimpleName()) + System.lineSeparator() +
                String.format("Capacity: %d", getCapacity()) + System.lineSeparator() +
                String.format("Price per Person: %.2f", getPricePerPerson()) + System.lineSeparator();
        return sb.trim();
    }
}
