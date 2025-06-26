package screen;

import java.awt.Graphics;
import java.awt.event.KeyListener;

import main.Game;

public class ScreenManager {
	private static Screen currentScreen;
	
	public static void setScreen(Screen screen) {
		if(currentScreen instanceof KeyListener oldListencer) {
			Game.instance.removeKeyListener(oldListencer);
		}
		
		currentScreen = screen;
		
		if(screen instanceof KeyListener newListener) {
			Game.instance.addKeyListener(newListener);
		}
	}
	
	public static void tick(int[] pixels) {
		if(currentScreen != null)  {
			currentScreen.tick(pixels);
		}
	}
}
