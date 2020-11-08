package shoppingSpree;

import constantMessages.ConstantMessages;
import validation.NumericValidator;
import validation.StringValidator;

public class Product {
    private String name;
    private double cost;

    public Product (String name,  double cost) {
        setName(name);
        setCost(cost);
    }

    private void setCost (double cost) {
        if (!NumericValidator.isNonNegative(cost)) {
            throw new IllegalArgumentException(ConstantMessages.INVALID_NUMERIC_MESSAGE);
        }
        this.cost = cost;
    }

    private void setName (String name) {
        if (!StringValidator.isNonEmpty(name)) {
            throw new IllegalArgumentException(ConstantMessages.INVALID_STRING_EXCEPTION);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getCost () {
        return cost;
    }
}
