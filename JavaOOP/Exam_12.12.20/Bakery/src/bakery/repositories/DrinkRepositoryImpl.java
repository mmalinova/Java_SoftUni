package bakery.repositories;

import bakery.entities.drinks.Tea;
import bakery.entities.drinks.Water;
import bakery.entities.drinks.interfaces.Drink;
import bakery.repositories.interfaces.DrinkRepository;

import java.util.ArrayList;
import java.util.Collection;

public class DrinkRepositoryImpl<Drink> implements DrinkRepository<Drink> {
    private Collection<Drink> models;

    public DrinkRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        for (Drink model : models) {
            if (model instanceof Tea) {
                if (((Tea) model).getName().equals(drinkName) && ((Tea) model).getBrand().equals(drinkBrand)) {
                    return model;
                }
            }
            if (model instanceof Water) {
                if (((Water) model).getName().equals(drinkName) && ((Water) model).getBrand().equals(drinkBrand)) {
                    return model;
                }
            }
        }
        return null;
    }

    @Override
    public Collection<Drink> getAll() {
        return this.models;
    }

    @Override
    public void add(Drink drink) {
        this.models.add(drink);
    }
}
