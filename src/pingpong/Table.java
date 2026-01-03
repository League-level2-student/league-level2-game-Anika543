package pingpong;

import java.awt.Color;
import java.awt.Graphics;

public class Table extends GameObject{
	Color color; 

	public Table(int x, int y, int width, int height, int speed, Color color) {
		super(x, y, width, height, speed); 
		// TODO Auto-generated constructor stub
		this.color = color; 
	}

	void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height); 
	}
}
