package pingpong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject {
	Color color; 

	public Ball(int x, int y, int width, int height, int speed, Color color) {
		// TODO Auto-generated constructor stub
		super(x, y, width, height, speed); 
		this.color = color; 
	}
	
	void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height); 
	}
	
	

	
}
