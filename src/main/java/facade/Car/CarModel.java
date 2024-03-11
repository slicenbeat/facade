package facade.Car;

import facade.TrafficLight.LightValueObject;

public class CarModel {
    private int speed = 1000;

    public int getSpeed() {
        return speed;
    }

    boolean isForbiddenToDrive(LightValueObject light) {
        return light.isRed();
    }

}