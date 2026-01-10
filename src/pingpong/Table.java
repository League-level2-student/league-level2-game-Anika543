package pingpong;

import java.awt.Color;
import java.awt.Graphics;

public class Table extends GameObject{
	Color color; 

	public Table(int x, int y, int width, int height, int speed, Color color, ObjectManager objectManager) {
		super(x, y, width, height, speed, objectManager); 
		// TODO Auto-generated constructor stub
		this.color = color; 
	}

	void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height); 
		Color c = new Color(255,255,255);
	}
}
