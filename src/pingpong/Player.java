package pingpong;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {

	boolean left;
	Color color;
	boolean isServing; 

	public Player(int x, int y, int width, int height, Color color, int speed, ObjectManager objectManager,
			boolean left, boolean isServing) {

		super(x, y, width, height, speed, objectManager);
		this.color = color;
		this.left = left;
		this.isServing = isServing; 

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
			if (x <= objectManager.table.x - width - speed) {
				x += speed;
			}
		} else {
			if (x <= PingPong.WIDTH - width) {
				x += speed;
			}
		}

	}

	public void left() {

		if (!left) {
			if (x >= objectManager.table.x + objectManager.table.width + speed) {
				x -= speed;
			}
		} else {
			if (x >= 0) {
				x -= speed;
			}
		}
	}

	public void up() {
		if (y >= 0)
			y -= speed;
	}

	public void down() {
		if (y <= PingPong.HEIGHT - height)
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
