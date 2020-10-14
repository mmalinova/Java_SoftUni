package CarSalesman;

public class Enginee {
    //has model, power, displacement and efficiency
    private String model;
    private int power;
    //optional
    private int displacement;
    private String efficiency;

    public Enginee(String engineModel, int power) {
        this.model = engineModel;
        this.power = power;
        this.efficiency = "n/a";
    }

    public Enginee(String engineModel, int power, int displacement, String efficiency) {
        this(engineModel, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Enginee(String engineModel, int power, int displacement) {
        this(engineModel, power);
        this.displacement = displacement;
    }

    public Enginee(String engineModel, int power, String efficiency) {
        this(engineModel, power);
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
