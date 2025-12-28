package Project;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MemeGenerator {
    public static BufferedImage generateMeme(String imagePath, String caption) throws IOException {
        BufferedImage image = ImageIO.read(new File(imagePath));

        // Create a graphics object to draw text on the image
        Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 36));

        // Calculate the position for the text
        int x = 50;
        int y = 100;

        // Draw the caption text on the image
        g.drawString(caption, x, y);

        // Dispose of the graphics object
        g.dispose();

        return image;
    }
}
