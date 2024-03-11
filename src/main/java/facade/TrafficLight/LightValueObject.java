package facade.TrafficLight;

public class LightValueObject {
    private static enum LIGHTS {
        RED, YELLOW, GREEN
    };

    private LIGHTS light = LIGHTS.RED;

    public void switchLight() {
        if (light == LIGHTS.RED) {
            light = LIGHTS.YELLOW;
            return;
        }
        if (light == LIGHTS.YELLOW) {
            light = LIGHTS.GREEN;
            return;
        }
        if (light == LIGHTS.GREEN) {
            light = LIGHTS.RED;
            return;
        }
        throw new NotFoundLightException();
    }

    public boolean isRed() {
        return light == LIGHTS.RED;
    }

    public boolean isYellow() {
        return light == LIGHTS.YELLOW;
    }

    public boolean isGreen() {
        return light == LIGHTS.GREEN;
    }
}