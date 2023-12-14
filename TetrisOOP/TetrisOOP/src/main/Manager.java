package main;

import java.awt.Graphics2D;

public class Manager {
	//MainArea
	final int WIDTH = 360;
	final int HEIGH = 600;
	public static int left_x;
	public static int right_x;
	public static int top_y;
	public static int down_y;
	
	public Manager() {
		//Area Frame
		left_x = (GamePanel.WIDTH/2) - (WIDTH/2);
		right_x = left_x + WIDTH;
		top_y = 50;
		down_y = top_y + HEIGH;
	}
	
	public void update() {
		
	}
	public void draw(Graphics2D g2) {
		
	}
}
