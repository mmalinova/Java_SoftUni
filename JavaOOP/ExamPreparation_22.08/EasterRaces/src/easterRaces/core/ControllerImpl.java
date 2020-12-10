package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static easterRaces.common.ExceptionMessages.*;
import static easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Driver> drivers;
    private Repository<Car> cars;
    private Repository<Race> races;

    public ControllerImpl(Repository<Driver> drivers, Repository<Car> cars, Repository<Race> races) {
        this.drivers = drivers;
        this.cars = cars;
        this.races = races;
    }

    @Override
    public String createDriver(String driver) {
        Driver dr = new DriverImpl(driver);

        if (drivers.getAll().contains(dr)) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }

        drivers.add(dr);
        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car;
        if ("Muscle".equals(type)) {
            car = new MuscleCar(model, horsePower);

            if (cars.getAll().contains(car)) {
                throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
            }

            cars.add(car);
            return String.format(CAR_CREATED, car.getClass().getSimpleName(), model);
        }
        if ("Sports".equals(type)) {
            car = new SportsCar(model, horsePower);

            if (cars.getAll().contains(car)) {
                throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
            }

            cars.add(car);
            return String.format(CAR_CREATED, car.getClass().getSimpleName(), model);
        }
        return null;
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver dr = drivers.getByName(driverName);
        if (!drivers.getAll().contains(dr)) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        Car car = cars.getAll().stream().filter(c -> c.getModel().equals(carModel))
                .findFirst().orElse(null);
        if (!cars.getAll().contains(car)) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }

        dr.addCar(car);
        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Driver dr = drivers.getByName(driverName);
        if (!drivers.getAll().contains(dr)) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        Race race = races.getAll().stream().filter(c -> c.getName().equals(raceName))
                .findFirst().orElse(null);
        if (!races.getAll().contains(race)) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        assert race != null;
        race.addDriver(dr);
        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = races.getByName(raceName);

        if (!races.getAll().contains(race)) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        if (race.getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        List<Driver> sorted = drivers.getAll().stream().sorted((d1, d2) -> Double.compare(
                d2.getCar().calculateRacePoints(race.getLaps()),
                d1.getCar().calculateRacePoints(race.getLaps())))
                .collect(Collectors.toList());

        StringBuilder output = new StringBuilder();
        output.append(String.format(DRIVER_FIRST_POSITION, sorted.get(0).getName(), raceName))
                .append(System.lineSeparator());
        output.append(String.format(DRIVER_SECOND_POSITION, sorted.get(1).getName(), raceName))
                .append(System.lineSeparator());
        output.append(String.format(DRIVER_THIRD_POSITION, sorted.get(2).getName(), raceName))
                .append(System.lineSeparator());

        return output.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);

        if (races.getAll().contains(race)) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }

        races.add(race);
        return String.format(RACE_CREATED, name);
    }
}
