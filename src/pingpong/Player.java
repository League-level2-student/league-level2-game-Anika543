package pingpong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

	boolean left;
	Color color;
	boolean isServing; 
	ObjectManager objectManager;  
	Rectangle next;

	public Player(int x, int y, int width, int height, Color color, int speed, ObjectManager objectManager,
			boolean left, boolean isServing) {

		super(x, y, width, height, speed, objectManager);
		this.color = color;
		this.left = left;
		this.isServing = isServing; 
		this.objectManager = objectManager; 
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
		if (left) {
			//if (x <= objectManager.table.x - width - speed || objectManager.table.y > y + height 
			//		|| objectManager.table.y+objectManager.table.height < y  ) {
			next = new Rectangle(x+speed, y, width, height); 
				if(!next.intersects(objectManager.table.collisionBox)) {
					
				x += speed;
				
			}
		} else {
			next = new Rectangle(x-speed, y, width, height); 
			if (x+width+speed <= 800 ) {
				x += speed;
			}
		}

	}

	public void left() {

		if (left) {
			//if (x >= objectManager.table.x + objectManager.table.width + speed|| objectManager.table.y > y + height 
			//		|| objectManager.table.y+objectManager.table.height < y  ) {
			if(x-speed >= 0) {
			
				x -= speed;
			}
			
		} else {
			next = new Rectangle(x-speed, y, width, height); 
			if (!next.intersects(objectManager.table.collisionBox)) {
				x -= speed;
			}
		}
	}
	
	

	public void up() {
		next = new Rectangle(x, y-speed, width, height); 
		if (!next.intersects(objectManager.table.collisionBox) && y-speed>= 0)
			y -= speed;
	}

	public void down() {
		next = new Rectangle(x, y+speed, width, height); 
		if (!next.intersects(objectManager.table.collisionBox) && y+speed+height<=500 )
			y += speed;
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
		
		if (!objectManager.hasBallBeenServed && isServing) {
			objectManager.ball.x = this.x;
			objectManager.ball.y = this.y; 

		}

		super.update();
	}

}
