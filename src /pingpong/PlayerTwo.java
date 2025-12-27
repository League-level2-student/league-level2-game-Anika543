package pingpong;

import java.awt.Color;
import java.awt.Graphics;

public class PlayerTwo extends GameObject{

	public PlayerTwo(int x, int y, int width, int height) {
		// TODO Auto-generated constructor stub
		super(x, y, width, height); 
	}
	
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height); 
	}

}
