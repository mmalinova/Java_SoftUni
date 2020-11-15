package vehicle;

public class Truck extends Vehicle {
    private static final double AIR_CONDITIONER_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_CONSUMPTION);
    }

    @Override
    protected void refuel(double liters) {
        this.fuelQuantity += (liters * 0.95);
    }
}
