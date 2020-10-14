package CarSalesman;

public class Carr {
    //a model, engine, weight and color
    private String model;
    private Enginee enginee;
    //optional
    private int weight;
    private String color;

    public Carr(String carModel, Enginee enginee, int weight, String color) {
        this.model = carModel;
        this.enginee = enginee;
        this.weight = weight;
        this.color = color;
    }

    public Carr(String carModel, Enginee engineeModel) {
        this.model = carModel;
        this.enginee = engineeModel;
        this.color = "n/a";
    }

    public Carr(String carModel, Enginee enginee, String color) {
        this(carModel, enginee);
        this.color = color;
    }

    public Carr(String carModel, Enginee enginee, int weight) {
        this(carModel, enginee);
        this.weight = weight;
    }

    @Override
    public String toString() {
        //<CarModel>:
        //<EngineModel>:
        //Power: <EnginePower>
        //Displacement: <EngineDisplacement>
        //Efficiency: <EngineEfficiency>
        //Weight: <CarWeight>
        //Color: <CarColor>
        return String.format("%s:%n%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s"
                , model, enginee.getModel(), enginee.getPower()
                , (enginee.getDisplacement() > 0) ? String.valueOf(enginee.getDisplacement()) : "n/a"
                , enginee.getEfficiency()
                , (weight > 0) ? String.valueOf(weight) : "n/a", color);
    }
}
