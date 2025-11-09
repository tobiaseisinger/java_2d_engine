package screenStates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import objects.GameObject;
import objects.Player;
import screen.Screen;
import screen.ScreenManager;
import textures.Atlas;
import textures.ImageReader;
import textures.Sprite;

public class GameScreen implements Screen, KeyListener {
	private int tickCount;
	Atlas atlas;
	
	private List<GameObject> o = new LinkedList<GameObject>();
	
	public GameScreen() {
		this.atlas = new Atlas(64,64,8,ImageReader.getPixelsOfImage(Objects.requireNonNull(ImageReader.readImage("resources/Atlas8x8.png"))));
		Sprite[][] sprites = new Sprite[1][3];
        sprites[0][0] = this.atlas.getSprite(0);
        sprites[0][1] = this.atlas.getSprite(1);
        sprites[0][2] = this.atlas.getSprite(2);

		Player test = new Player(20, 20, sprites);
		
		o.add(test);
	}



	@Override
	public void tick(int[] pixels) {
		/**
		for (int i = 0; i < pixels.length; i++) {
	        int x = i % 120;
	        int y = i / 160;

	        int red = (x + tickCount) % 256;
	        int green = (y + tickCount) % 256;
	        int blue = (tickCount * 2) % 256;

	        pixels[i] = (255 << 24) | (red << 16) | (green << 8) | blue;
	    }
		*/


        Arrays.fill(pixels, 0xFF000000);
		
		
		for(GameObject obj : o) {
			obj.tick();
			obj.render(pixels, 160);
		}

		
		tickCount++;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			ScreenManager.setScreen(new TestScreen());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
