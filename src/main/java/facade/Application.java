package facade;

import javax.swing.*;

import facade.Car.CarController;
import facade.Car.CarModel;
import facade.Car.CarView;

import facade.TrafficLight.TrafficLightController;
import facade.TrafficLight.TrafficLightModel;
import facade.TrafficLight.TrafficLightView;

import java.awt.*;
import java.awt.event.*;

public class Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;
    private static final int SECOND = 1000;
    private static final int TIMER_DELAY = SECOND / 100;

    private JFrame frame;
    private Facade facade;

    public Application() {
        initFrame();
        initTimer();
    }

    private void initFrame() {
        frame = new JFrame("Car");

        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.RED);
        initChildsFrames();

        frame.setVisible(true);
    }

    private void initChildsFrames() {
        CarController car = initCar();
        TrafficLightController trafficLight = initTrafficLight();
        facade = new Facade(trafficLight, car);
    }

    private CarController initCar() {
        CarModel model = new CarModel();
        CarView view = new CarView(model, new Point(100, 200));
        frame.getContentPane().add(view);
        return new CarController(model, view);
    }

    private TrafficLightController initTrafficLight() {
        TrafficLightModel model = new TrafficLightModel();
        TrafficLightView view = new TrafficLightView(model, new Point(500, 100));
        frame.getContentPane().add(view);
        return new TrafficLightController(model, view);
    }

    private void initTimer() {
        Timer timer = new Timer(TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facade.moveCar();
                facade.repaint();
            }
        });
        timer.start();
    }
}
