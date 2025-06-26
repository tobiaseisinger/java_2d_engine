package main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import screen.ScreenManager;
import screenStates.GameScreen;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 160;
	private static final int HEIGHT = 120;
	
	public static Game instance;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	private boolean running = false;
	
	int tickCount;
	
	public Game() {
		instance = this;
	}
	
	public void start() {
		running = true;
		GameScreen gameScreen = new GameScreen();
		ScreenManager.setScreen(gameScreen);
		
		new Thread(this).start();
	}
	
	public void stop() {
		running = false;
	}
	

	public void tick() {
		tickCount++;
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
	

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		long lastTimer1 = System.currentTimeMillis();
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				ScreenManager.tick(pixels);
				delta--;
			}
			frames++;
			render();
			
			if(System.currentTimeMillis() - lastTimer1 > 1000) {
				lastTimer1 += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
	}
}
