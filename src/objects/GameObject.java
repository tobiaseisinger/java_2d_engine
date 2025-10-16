package objects;

import textures.Sprite;

public class GameObject {
	private int x,y;
	private Sprite[][] sprites;
	
	public GameObject(int x, int y, Sprite[][] sprites) {
		this.x = x;
		this.y = y;
		this.sprites = sprites;
	}
	
	public void tick() {

	}
	
	
	public void render(int[] pixels, int screenWidth) {
        for (int sy = 0; sy < sprites.length; sy++) {
            for (int sx = 0; sx < sprites[sy].length; sx++) {
                Sprite sprite = sprites[sy][sx];
                if (sprite != null) {
                    drawSprite(pixels, screenWidth, sprite, x + sx * 8, y + sy * 8);
                }
            }
        }
    }
	
	private void drawSprite(int[] screenPixels, int screenWidth, Sprite sprite, int posX, int posY) {
        int[] spritePixels = sprite.getPixels();
        int spriteSize = sprite.getSize();

        for (int y = 0; y < spriteSize; y++) {
            for (int x = 0; x < spriteSize; x++) {
                int screenX = posX + x; // mal 8 nehmen ist ein cooler Effekt
                int screenY = posY + y; // mal 8 nehmen ist ein cooler Effekt
                if (screenX < 0 || screenY < 0 || screenX >= screenWidth || screenY >= screenPixels.length / screenWidth)
                    continue;

                int screenIndex = screenX + screenY * screenWidth;
                int spriteIndex = x + y * spriteSize;
                screenPixels[screenIndex] = spritePixels[spriteIndex];
            }
        }
    }
}
