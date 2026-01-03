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
	
	boolean movingUp = false;
	boolean movingDown = false;
	boolean movingLeft = false; 
	boolean movingRight = false;
	
	public void right() {
		
		if(x<=800)
        x+=speed;
    }
	
	public void left() {
		if(x>=0)
		x-=speed;
	}
	
	public void up() {
		if(y>=0)
		y-=speed;
	}
	
	public void down() {
		if(y<=410)
		y+=speed; 
	}

 
	public void update() {
		if (movingUp) {
			up();
		}
		if (movingDown) {
			down();
		}
		if (movingLeft) {
			left();
		}
		if (movingRight) {
			right();
		}
		super.update(); 
	}
	

}
	


