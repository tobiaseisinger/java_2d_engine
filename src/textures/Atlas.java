package textures;

import java.util.ArrayList;
import java.util.List;

public class Atlas {
	private int width;
	private int height;
	private int spriteSize;
	private int[] pixels;
	
	private ArrayList<Sprite> liste = new ArrayList<Sprite>();
	
	private void fillList() {
		for(int sy = 0; sy < height/spriteSize; sy++) {
			for(int sx = 0; sx < width/spriteSize; sx++) {
				int[] spritePixels = new int[spriteSize * spriteSize];

	            for (int y = 0; y < spriteSize; y++) {
	                for (int x = 0; x < spriteSize; x++) {
	                    int atlasX = sx * spriteSize + x;
	                    int atlasY = sy * spriteSize + y;
	                    int atlasIndex = atlasX + atlasY * width;

	                    int spriteIndex = x + y * spriteSize;
	                    spritePixels[spriteIndex] = pixels[atlasIndex];
	                }
	            }

	            liste.add(new Sprite(spriteSize, spritePixels));
			}
		}
	}
	
	public Atlas(int width, int height, int spriteSize, int[] pixels) {
		this.width = width;
		this.height = height;
		this.spriteSize = spriteSize;
		this.pixels = pixels;
		
		fillList();
	}
	
	public int[] getPixels() {
		return pixels;
	}
	
	public Sprite getSprite(int number) {
		return liste.get(number);
	}
}
