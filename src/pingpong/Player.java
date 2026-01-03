package pingpong;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject{

	Color color; 
	public Player(int x, int y, int width, int height, Color color, int speed ) {
		
		super(x, y, width, height, speed); 
		this.color = color; 
	}
	
	void draw(Graphics g) {
		g.setColor(color);
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
		if(y<=475)
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
