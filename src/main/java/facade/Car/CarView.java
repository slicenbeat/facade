package facade.Car;

import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class CarView extends JPanel {
    private final static String IMAGE_PATH = "UFO.png";
    private final static int WIDTH = 150;
    private final static int HEIGHT = 100;

    private CarModel model;
    private Image image;
    private Point position;

    public CarView(CarModel model, Point position) {
        this.model = model;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(IMAGE_PATH));
            System.out.println("Width: " + image.getWidth(null));
            System.out.println("Height: " + image.getHeight(null));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.position = position;
    }

    public boolean isForbiddenToDrive() {
        return position.x < 450 && position.x > 400;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("CarView: paintComponent called");
        if (image != null) {
            int width = image.getWidth(this);
            int height = image.getHeight(this);
            System.out.println("Width: " + width);
            System.out.println("Height: " + height);
        } else {
            System.out.println("Image is not loaded yet.");
        }
        g.drawImage(this.image, position.x, position.y, WIDTH, HEIGHT, null);
    }

    public void updateCarPosition() {
        position.x += model.getSpeed();
        if (position.x > 500) {
            position.x = -WIDTH;
        }
    }

}
