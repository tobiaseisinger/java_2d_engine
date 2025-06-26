package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		Game game = new Game();
		game.setPreferredSize(new Dimension(640, 480));
		game.setMinimumSize(new Dimension(640, 480));
		game.setMaximumSize(new Dimension(640, 480));
		
		JFrame frame = new JFrame("Breakout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(game);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
