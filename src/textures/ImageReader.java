package textures;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageReader {
	public static BufferedImage readImage(String path) {
		try {
			BufferedImage image = ImageIO.read(new File(path));
			System.out.println("Bild bei " + path + " konnte geladen werden!");
			BufferedImage converted = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
			converted.getGraphics().drawImage(image, 0, 0, null);
			return converted;
		} catch(IOException e) {
			System.err.println("Couldn't read from File at " + path);
			return null;
		}
	}
	
	public static int[] getPixelsOfImage(BufferedImage img) {
		return ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
	}
}
