package vehicleExtension;

public class Truck extends Vehicle {
    private static final double AIR_CONDITIONER_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_CONSUMPTION, tankCapacity);
    }

    @Override
    protected void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
