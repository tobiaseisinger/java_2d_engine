package textures;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageReader {
	public static BufferedImage readImage(String path) {
		try {
			BufferedImage image = ImageIO.read(new File(path));
			System.out.println("Bild bei " + path + " konnte geladen werden!");
			return image;
		} catch(IOException e) {
			System.err.println("Couldn't read from File at " + path);
			return null;
		}
	}
}
