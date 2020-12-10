package easterRaces.repositories;

import easterRaces.entities.cars.Car;
import easterRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class CarRepository implements Repository<Car> {
    private Collection<Car> models;

    public CarRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Car getByName(String name) {
        for (Car model : models) {
            if (model.getModel().equals(name)){
                return model;
            }
        }
        return null;
    }

    @Override
    public Collection<Car> getAll() {
        return this.models;
    }

    @Override
    public void add(Car model) {
        this.models.add(model);
    }

    @Override
    public boolean remove(Car model) {
        return this.models.remove(model);
    }
}
