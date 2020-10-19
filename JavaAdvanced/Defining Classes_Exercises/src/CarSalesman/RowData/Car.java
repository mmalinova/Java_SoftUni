package RowData;

public class Car {
    //model, engine, cargo and a collection of exactly 4 tires
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[][] tires;

    public Car(String model, int speed, int power, int cargoWeight, String cargoType,
               double pressure1, int age1, double pressure2, int age2, double pressure3, int age3,
               double pressure4, int age4) {
        this.model = model;
        this.engine = new Engine(speed, power);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tires = new Tire[4][2];
        this.tires[0][0] = new Tire(pressure1);
        this.tires[0][1] = new Tire(age1);
        this.tires[1][0] = new Tire(pressure2);
        this.tires[1][1] = new Tire(age2);
        this.tires[2][0] = new Tire(pressure3);
        this.tires[2][1] = new Tire(age3);
        this.tires[3][0] = new Tire(pressure4);
        this.tires[3][1] = new Tire(age4);
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Tire[][] getTires() {
        return this.tires;
    }
}
