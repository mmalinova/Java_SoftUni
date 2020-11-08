package shoppingSpree;

import constantMessages.ConstantMessages;
import validation.NumericValidator;
import validation.StringValidator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    private void setName(String name) {
        if (!StringValidator.isNonEmpty(name)) {
            throw new IllegalArgumentException(ConstantMessages.INVALID_STRING_EXCEPTION);
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (!NumericValidator.isNonNegative(money)) {
            throw new IllegalArgumentException(ConstantMessages.INVALID_NUMERIC_MESSAGE);
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (money >= product.getCost()) {
            products.add(product);
            System.out.println(name + " bought " + product.getName());
            money -= product.getCost();
        } else {
            //System.out.println(name + " can't afford " + product.getName());
            throw new IllegalArgumentException(name + " can't afford " + product.getName());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return products.isEmpty() ? name + " – Nothing bought"
                : name + " - " + products.stream().map(Product::getName)
                .collect(Collectors.joining(", "));
    }
}
