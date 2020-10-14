package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private double distance;

    public Car() {
        this.model = "";
        this.fuelAmount = 0.0;
        this.fuelCost = 0.0;
        this.distance = 0;
    }

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
    }

    public boolean canMoveTheDistance(double amountOfKilometers) {
            if (this.fuelAmount >= amountOfKilometers * this.fuelCost) {
                this.fuelAmount -= amountOfKilometers * this.fuelCost;
                this.distance += amountOfKilometers;
                return true;
            }
            return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.model, this.fuelAmount, this.distance);
    }
}
