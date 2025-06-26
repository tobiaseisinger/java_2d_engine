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
		
	}
	
	public Atlas(int width, int height, int spriteSize, int[] pixels) {
		this.width = width;
		this.height = height;
		this.spriteSize = spriteSize;
		this.pixels = pixels;
		
		
	}
}
