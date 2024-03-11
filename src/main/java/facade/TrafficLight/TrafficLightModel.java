package facade.TrafficLight;

public class TrafficLightModel {
    private LightValueObject light = new LightValueObject();

    public LightValueObject getLight() {
        return light;
    }

    public void switchLight() {
        light.switchLight();
    }
}
