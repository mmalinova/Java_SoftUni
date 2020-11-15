package vehicle;

import java.text.DecimalFormat;

public abstract class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumption; // in liters per km and

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    protected String drive(double distance) {
        if (fuelConsumption * distance <= fuelQuantity) {
            fuelQuantity -= fuelConsumption * distance;
            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            return this.getClass().getSimpleName() + " travelled " + decimalFormat.format(distance) + " km";
        }
        return this.getClass().getSimpleName() + " needs refueling";
    }

    protected abstract void refuel(double liters);

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
