package objects;

import textures.Sprite;

public class GameObject {
	private int x,y;
	private int width,height; // in Sprites
	private Sprite[][] sprites;
	
	public GameObject(int x, int y, int width, int height, Sprite[][] sprites) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprites = sprites;
	}
	
	public void tick() {
		
	}
	
	
	public void render(int[] pixels, int screenWidth) {
		for(int sy = 0; sy < height; sy++) {
			for(int sx = 0; sx < width; sx++) {
				Sprite sprite = sprites[sy][sx];
                if (sprite != null) {
                    drawSprite(pixels, screenWidth, sprite, x + sx * 8, y + sy * 8);
                }
			}
		}
	}
	
	private void drawSprite(int[] screenPixels, int screenWidth, Sprite sprite, int posX, int posY) {
        int[] spritePixels = sprite.getPixels();
        int spriteSize = 8;

        for (int y = 0; y < spriteSize; y++) {
            for (int x = 0; x < spriteSize; x++) {
                int screenX = posX + x;
                int screenY = posY + y;
                if (screenX < 0 || screenY < 0 || screenX >= screenWidth || screenY >= screenPixels.length / screenWidth)
                    continue;

                int screenIndex = screenX + screenY * screenWidth;
                int spriteIndex = x + y * spriteSize;
                screenPixels[screenIndex] = spritePixels[spriteIndex];
            }
        }
    }
}
