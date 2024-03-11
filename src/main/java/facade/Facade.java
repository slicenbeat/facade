package facade;

import facade.TrafficLight.TrafficLightController;
import facade.Car.CarController;

public class Facade {
    private TrafficLightController trafficLight;
    private CarController car;

    public Facade(TrafficLightController trafficLight, CarController car) {
        this.car = car;
        this.trafficLight = trafficLight;
    }
    public void moveCar(){
        car.move(trafficLight.getTrafficLight());
    }
    public void repaint(){
        car.repaint();
        trafficLight.repaint();
    }
}
