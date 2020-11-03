package TrafficLights;

public class TrafficLights {
    private Light light;

    public TrafficLights(Light light) {
        this.light = light;
    }

    public void update() {
        switch (light) {
            case RED:
                this.light = Light.GREEN;
                break;
            case GREEN:
                this.light = Light.YELLOW;
                break;
            case YELLOW:
                this.light = Light.RED;
                break;
        }
    }

    public Light getLight() {
        return this.light;
    }
}
