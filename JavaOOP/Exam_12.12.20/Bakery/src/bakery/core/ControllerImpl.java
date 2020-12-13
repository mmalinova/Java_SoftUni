package bakery.core;

import bakery.common.ExceptionMessages;
import bakery.common.OutputMessages;
import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.BaseFood;
import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.Tea;
import bakery.entities.drinks.Water;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.InsideTable;
import bakery.entities.tables.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

import java.net.CookieHandler;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static bakery.common.ExceptionMessages.*;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foods;
    private DrinkRepository<Drink> drinks;
    private TableRepository<Table> tables;
    private double totalIncome = 0;


    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository,
                          TableRepository<Table> tableRepository) {
        this.foods = foodRepository;
        this.drinks = drinkRepository;
        this.tables = tableRepository;
    }


    @Override
    public String addFood(String type, String name, double price) {
        boolean anyMatch = foods.getAll().stream().anyMatch(bakedFood -> bakedFood.getName().equals(name));
        if (anyMatch) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        BaseFood food;
        if ("Bread".equals(type)) {
            food = new Bread(name, price);
            foods.add(food);
            return String.format(FOOD_ADDED, name, type);
        } else if ("Cake".equals(type)) {
            food = new Cake(name, price);
            foods.add(food);
            return String.format(FOOD_ADDED, name, type);
        }
        return null;
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        boolean anyMatch = drinks.getAll().stream().anyMatch(drink -> drink.getName().equals(name));
        if (anyMatch) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        Drink drink;
        if ("Tea".equals(type)) {
            drink = new Tea(name, portion, brand);
            drinks.add(drink);
            return String.format(DRINK_ADDED, name, brand);
        } else if ("Water".equals(type)) {
            drink = new Water(name, portion, brand);
            drinks.add(drink);
            return String.format(DRINK_ADDED, name, brand);
        }
        return null;
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        boolean anyMatch = tables.getAll().stream().anyMatch(table -> table.getTableNumber() == tableNumber);
        if (anyMatch) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }

        Table table;
        if ("InsideTable".equals(type)) {
            table = new InsideTable(tableNumber, capacity);
            tables.add(table);
            return String.format(TABLE_ADDED, tableNumber);
        } else if ("OutsideTable".equals(type)) {
            table = new OutsideTable(tableNumber, capacity);
            tables.add(table);
            return String.format(TABLE_ADDED, tableNumber);
        }
        return null;
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        Table tableNotReserved = tables.getAll().stream().filter(table -> !table.isReserved())
                .filter(table -> table.getCapacity() >= numberOfPeople).findFirst().orElse(null);

        if(tableNotReserved == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        tables.getByNumber(tableNotReserved.getTableNumber()).reserve(numberOfPeople);
        return String.format(TABLE_RESERVED, tableNotReserved.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table table1 = tables.getAll().stream().filter(table -> table.getTableNumber() == tableNumber)
                .findFirst().orElse(null);

        if (table1 == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        BakedFood bakedFood = foods.getByName(foodName);
        if (bakedFood == null) {
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }

        tables.getByNumber(tableNumber).orderFood(bakedFood);
        return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Table table1 = tables.getAll().stream().filter(table -> table.getTableNumber() == tableNumber)
                .findFirst().orElse(null);

        if (table1 == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        Drink drink = drinks.getByNameAndBrand(drinkName, drinkBrand);
        if (drink == null) {
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }

        tables.getByNumber(tableNumber).orderDrink(drink);
        return String.format(DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);
    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table1 = tables.getAll().stream().filter(table -> table.getTableNumber() == tableNumber)
                .findFirst().orElse(null);

        if (table1 == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        double bill = table1.getBill();
        totalIncome += bill;
        table1.clear();
        return String.format(BILL, tableNumber, bill).trim();
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder sb = new StringBuilder();
        tables.getAll().stream().filter(table -> !table.isReserved())
                .forEach(table -> sb.append(table.getFreeTableInfo()).append(System.lineSeparator()));

        return sb.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format(TOTAL_INCOME, totalIncome);
    }
}
