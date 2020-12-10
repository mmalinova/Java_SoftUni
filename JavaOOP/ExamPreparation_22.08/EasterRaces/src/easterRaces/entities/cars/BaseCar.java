package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.*;

public abstract class BaseCar implements Car{
    private	String model;
    //o	All models are unique
    private	int horsePower;
    private	double cubicCentimeters;

    protected BaseCar(String model, int horsePower, double cubicCentimeters) {
        setModel(model);
        setHorsePower(horsePower);
        this.cubicCentimeters = cubicCentimeters;
    }

    private void setModel(String model) {
        if (model == null || model.trim().isEmpty() || model.length() < 4) {
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, 4));
        }
        this.model = model;
    }

    private void setHorsePower(int horsePower) {
        switch (this.getClass().getSimpleName()) {
            case "MuscleCar":
                if (horsePower < 400 || horsePower > 600) {
                    throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
                }
                break;
            case "SportsCar":
                if (horsePower < 250 || horsePower > 450) {
                    throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
                }
                break;
        }
        this.horsePower = horsePower;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return cubicCentimeters / (horsePower * laps);
    }
}
