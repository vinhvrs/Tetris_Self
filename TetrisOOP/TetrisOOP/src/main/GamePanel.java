package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	public static final int WIDTH = 1280;
	public static final int HEIGH = 720;
	final int FPS = 60;
	Thread gameThread;
	Manager pm;
	
	public GamePanel() {
		//Settings
		this.setPreferredSize(new Dimension(WIDTH,HEIGH));
		this.setBackground(new Color(0 ,0 ,0));
		this.setLayout(null);
		
		pm = new Manager();
	}
	
	public void launchGame() {
		 gameThread = new Thread(this);
		 gameThread.start();
	}

	@Override
	public void run() {
		//GameLoop
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			
			if (delta >= 1) {
				update();
				repaint();
				delta--;
			}
		}
	}
	
	private void update() {
		pm.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		pm.draw(g2);
	}
}
