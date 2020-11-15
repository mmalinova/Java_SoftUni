package vehicleExtension;

public class Bus extends Vehicle{
    private static final double AIR_CONDITIONER_CONSUMPTION = 1.4;

    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public String driveWithPassengers(double distance) {
        return super.doWithIncreasedConsumption(AIR_CONDITIONER_CONSUMPTION,
                () -> super.drive(distance));
    }
}
