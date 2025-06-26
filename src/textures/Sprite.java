package textures;

public class Sprite {
	private int size = 0;
	private int[] pixels;
	
	public Sprite(int size, int[] pixels) {
		this.size = size;
		this.pixels = pixels;
	}
	
	public int[] getPixels() {
		return pixels;
	}
}
