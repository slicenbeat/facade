package facade.TrafficLight;

import java.awt.*;
import javax.swing.JPanel;

public class TrafficLightView extends JPanel {
    private final int WIDTH = 100;
    private final int HEIGHT = 400;

    private Point position;
    private TrafficLightModel model;

    public TrafficLightView(TrafficLightModel model, Point position) {
        this.position = position;
        this.model = model;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = WIDTH;
        int height = HEIGHT;

        int circleDiameter = Math.min(width, height) / 5;
        int startX = position.x;
        int startY = position.y;

        g.setColor(Color.BLACK);
        g.fillRect(startX, startY, circleDiameter, 3 * circleDiameter);

        g.setColor(Color.GRAY);
        g.fillOval(startX, startY, circleDiameter, circleDiameter);
        g.fillOval(startX, startY + circleDiameter, circleDiameter, circleDiameter);
        g.fillOval(startX, startY + 2 * circleDiameter, circleDiameter, circleDiameter);

        LightValueObject activeLight = model.getLight();

        if (activeLight.isRed()) {
            g.setColor(Color.RED);
            g.fillOval(startX, startY, circleDiameter, circleDiameter);
        }
        if (activeLight.isYellow()) {
            g.setColor(Color.YELLOW);
            g.fillOval(startX, startY + circleDiameter, circleDiameter, circleDiameter);
        }
        if (activeLight.isGreen()) {
            g.setColor(Color.GREEN);
            g.fillOval(startX, startY + 2 * circleDiameter, circleDiameter, circleDiameter);
        }
    }
}
