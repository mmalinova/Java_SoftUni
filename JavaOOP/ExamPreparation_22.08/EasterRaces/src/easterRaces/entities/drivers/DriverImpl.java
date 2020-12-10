package easterRaces.entities.drivers;

import easterRaces.entities.cars.Car;

import static easterRaces.common.ExceptionMessages.*;

public class DriverImpl implements Driver{
    private	String name;
    //o	All names are unique
    private	Car car;
    private	int numberOfWins;
    private	boolean canParticipate;

    public DriverImpl(String name) {
        setName(name);
        this.car = null;
        this.numberOfWins = 0;
        this.canParticipate = false;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Car getCar() {
        return car;
    }

    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException(CAR_INVALID);
        }
        this.car = car;
        this.canParticipate = true;
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return canParticipate;
    }
}
