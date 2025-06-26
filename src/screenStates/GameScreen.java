package screenStates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import screen.Screen;
import screen.ScreenManager;

public class GameScreen implements Screen, KeyListener {
	private int tickCount;

	@Override
	public void tick(int[] pixels) {
		for (int i = 0; i < pixels.length; i++) {
	        int x = i % 120;
	        int y = i / 160;

	        int red = (x + tickCount) % 256;
	        int green = (y + tickCount) % 256;
	        int blue = (tickCount * 2) % 256;

	        pixels[i] = (255 << 24) | (red << 16) | (green << 8) | blue;
	    }
		
		/**
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = i + tickCount | 0xFF000000;
		}
		*/
		
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
