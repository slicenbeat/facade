package facade.TrafficLight;

import java.util.Timer;
import java.util.TimerTask;

public class TrafficLightController {
    private Timer lightTimer;
    private final int SECOND = 1000;
    private final int LIGHT_DURATION = 2 * SECOND;

    private TrafficLightModel model;
    private TrafficLightView view;

    public TrafficLightController(TrafficLightModel model, TrafficLightView view) {
        this.model = model;
        this.view = view;

        initLightTimer();
    }

    private void initLightTimer() {
        lightTimer = new Timer();
        lightTimer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                model.switchLight();
                view.repaint();
            }
        }, LIGHT_DURATION, LIGHT_DURATION);
    }

    public LightValueObject getTrafficLight(){
        return model.getLight();
    }
    public void repaint(){
        view.repaint();
    }

}
