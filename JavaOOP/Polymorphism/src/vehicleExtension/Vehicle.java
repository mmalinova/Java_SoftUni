package vehicleExtension;

import java.text.DecimalFormat;
import java.util.function.Supplier;

public abstract class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumption; // in liters per km and
    protected double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.tankCapacity = tankCapacity;
        setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
    }

    protected <T> T doWithIncreasedConsumption(double additionalConsumption, Supplier<T> supplier) {
        this.fuelConsumption += additionalConsumption;
        try {
            return supplier.get();
        } catch (Throwable ex) {
            throw new IllegalStateException(ex);
        } finally {
            this.fuelConsumption -= additionalConsumption;
        }
    }

    private void setFuelQuantity(double fuelQuantity) {
        validateNonNegativeFuel(fuelQuantity);
        validateHasEnoughFreeTankCapacity(fuelQuantity);
        this.fuelQuantity = fuelQuantity;
    }

    private void validateNonNegativeFuel(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
    }

    private void validateHasEnoughFreeTankCapacity(double additionalFuel) {
        if (additionalFuel > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }

    protected String drive(double distance) {
        double fuelNeeded = distance * this.fuelConsumption;
        return driveWithFuelNeeded(distance, fuelNeeded);
    }

    public String drive(double distance, double consumption) {
        double fuelNeeded = distance * consumption;
        return driveWithFuelNeeded(distance, fuelNeeded);
    }

    private String driveWithFuelNeeded(double distance, double fuelNeeded) {
        if (fuelNeeded > this.fuelQuantity) {
            return this
                    .getClass().getSimpleName()
                    + " needs refueling";
        }
        this.setFuelQuantity(this.fuelQuantity - fuelNeeded);
        DecimalFormat formatter =
                new DecimalFormat("##.##");
        return String.format("%s travelled %s km",
                this.getClass().getSimpleName(),
                formatter.format(distance));
    }

    protected void refuel(double liters) {
        validateNonNegativeFuel(liters);
        validateHasEnoughFreeTankCapacity(liters);
        this.setFuelQuantity(this.fuelQuantity + liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
