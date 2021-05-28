package src;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JRadioButton;

public class FloorRadioButton  extends JRadioButton {

    private BufferedImage onIcon;
    private BufferedImage offIcon;

    public FloorRadioButton(int floor) {
        /*
        * floor should be 1, 2, or 3
        */

        try {
            switch (floor) {
                case 1:
                    offIcon = ImageIO.read(new File("src/resources/1-light.png"));
                    onIcon = ImageIO.read(new File("src/resources/1-dark.png"));
                    break;
                
                case 2:
                    offIcon = ImageIO.read(new File("src/resources/2-light.png"));
                    onIcon = ImageIO.read(new File("src/resources/2-dark.png"));
                    break;
                
                case 3:
                    offIcon = ImageIO.read(new File("src/resources/3-light.png"));
                    onIcon = ImageIO.read(new File("src/resources/3-dark.png"));
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        int size = Math.min(getWidth(), getHeight());

        if (isSelected()) {
            g.drawImage(onIcon, 0, 0, size, size, this);
        } else {
            g.drawImage(offIcon, 0, 0, size, size, this);
        }
    }
}
