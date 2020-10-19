package RowData;

public class Tire {
    private double pressure;
    private int age;

    public Tire(double pressure) {
        this.pressure = pressure;
    }

    public Tire(int age) {
        this.age = age;
    }

    public double getPressure() {
        return this.pressure;
    }
}
