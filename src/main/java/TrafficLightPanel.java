import javax.swing.*;
import java.awt.*;

public class TrafficLightPanel extends JPanel {
    private Color colorRed = Color.RED;
    private Color colorYellow = Color.YELLOW;
    private Color colorGreen = Color.GREEN;
    private int activeLight = 0; // 0 - Red, 1 - Yellow, 2 - Green

    public TrafficLightPanel() {
        Timer timer = new Timer(2000, e -> {
            activeLight = (activeLight + 1) % 3;
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        int circleDiameter = Math.min(width, height) / 5;
        int startX = (width - circleDiameter) / 2;
        int startY = (height - 3 * circleDiameter) / 2;

        g.setColor(Color.BLACK);
        g.fillRect(startX, startY, circleDiameter, 3 * circleDiameter);

        g.setColor(Color.GRAY);
        g.fillOval(startX, startY, circleDiameter, circleDiameter);
        g.fillOval(startX, startY + circleDiameter, circleDiameter, circleDiameter);
        g.fillOval(startX, startY + 2 * circleDiameter, circleDiameter, circleDiameter);

        if (activeLight == 0) {
            g.setColor(colorRed);
            g.fillOval(startX, startY, circleDiameter, circleDiameter);
        } else if (activeLight == 1) {
            g.setColor(colorYellow);
            g.fillOval(startX, startY + circleDiameter, circleDiameter, circleDiameter);
        } else {
            g.setColor(colorGreen);
            g.fillOval(startX, startY + 2 * circleDiameter, circleDiameter, circleDiameter);
        }
    }

}
