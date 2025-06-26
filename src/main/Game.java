package main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 320;
	private static final int HEIGHT = 240;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
	private boolean running = false;
	
	public void start() {
		new Thread(this).start();
	}
	
	public void stop() {
		running = false;
	}
	
	private void runStep() {
		tick();
		render();
	}
	
	public void tick() {
		
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
		while(running) {
			runStep();
		}
	}
}
