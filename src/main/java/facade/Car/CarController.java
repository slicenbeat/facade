package facade.Car;

import facade.TrafficLight.LightValueObject;

public class CarController {
    private CarModel model;
    private CarView view;

    public CarController(CarModel model, CarView view) {
        this.view = view;
        this.model = model;
    }

    public void move(LightValueObject light) {
        if (isForbiddenToDrive(light)) {
            return;
        }
        view.updateCarPosition();
    }
    public void repaint(){
        view.repaint();
    }

    private boolean isForbiddenToDrive(LightValueObject light) {
        return view.isForbiddenToDrive() && model.isForbiddenToDrive(light);
    }

}
