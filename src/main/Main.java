package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import textures.ImageReader;

public class Main {
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 960;

	public static void main(String[] args) {
		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		game.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		game.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		
		JFrame frame = new JFrame("Breakout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(game);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.requestFocus();
		
		game.start();
		
	}
}
