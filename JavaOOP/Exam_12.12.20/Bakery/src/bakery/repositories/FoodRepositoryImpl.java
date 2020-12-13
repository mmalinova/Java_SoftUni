package bakery.repositories;

import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.Tea;
import bakery.repositories.interfaces.FoodRepository;

import java.util.ArrayList;
import java.util.Collection;

public class FoodRepositoryImpl<BakedFood> implements FoodRepository<BakedFood> {
    private Collection<BakedFood> models;

    public FoodRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public BakedFood getByName(String name) {
        for (BakedFood model : models) {
            if (model instanceof Bread) {
                if (((Bread) model).getName().equals(name)) {
                    return model;
                }
            }
            if (model instanceof Cake) {
                if (((Cake) model).getName().equals(name)) {
                    return model;
                }
            }
        }
        return null;
    }

    @Override
    public Collection<BakedFood> getAll() {
        return this.models;
    }

    @Override
    public void add(BakedFood food) {
        this.models.add(food);
    }
}
