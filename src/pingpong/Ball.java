package pingpong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject {

	Color color;
	int xVel;
	int yVel;
	int z;
	int zVel;
	int gravity = 1;
	int drag = 1;
	int frameCounter = 0;
	int amountOfTimesBounced = 0;
	int pointsPlayed = 0; 

	public Ball(int x, int y, int width, int height, int speed, Color color, ObjectManager objectManager) {
		// TODO Auto-generated constructor stub
		super(x, y, width, height, speed, objectManager);
		this.color = color;

	}

	void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width + z, height + z);
		g.setColor(Color.green);
		g.fillRect(x, y, 5, 5);
	}

	void update() {
		if (objectManager.hasBallBeenServed) {
			x += xVel;
			y += yVel;
			z += zVel;

			if (z > 0 && frameCounter % 3 == 0) {
				zVel -= gravity;

			}

			if (z <= 0) {
				z = 0;
				amountOfTimesBounced++;
				zVel = 5 - amountOfTimesBounced;

				if (amountOfTimesBounced > 15) {
					zVel = 0;
				}

				if (zVel <= 0) {
					zVel = 0;
				}
			}

			if (Math.abs(xVel) > 0 && frameCounter % 25 == 0) {
				if (xVel > 0) {
					xVel -= drag;
				}
				if (xVel < 0) {
					xVel += drag;
				}

			}

			if (Math.abs(yVel) > 0 && frameCounter % 25 == 0) {
				if (yVel > 0) {
					yVel -= drag;
				}
				if (yVel < 0) {
					yVel += drag;
				}

			}

			if (z < 1) {
				if (objectManager.hasBallBeenServed && ((x > 600)  || (x > 200 && (y > 350 || y < 150))))
				{
					GamePanel.scoreOne += 1;
					amountOfTimesBounced = 0; 
					objectManager.hasBallBeenServed = false;
				}
			}

			if (z < 1 && amountOfTimesBounced >1 ) {
				if (objectManager.hasBallBeenServed && ((x < 200-width) || (x < 400 && (y > 350 || y < 150))))
				{
					GamePanel.scoreTwo += 1;
					amountOfTimesBounced = 0; 
					objectManager.hasBallBeenServed = false;
				}
			}

			frameCounter++;
		} else {
			zVel = 5;
			z = 1;

		}
		width = 25 + z;
		height = 25 + z; 
		super.update();
	}

	public void serve() {

		// TODO Auto-generated method stub
		xVel = 10;
		zVel = 5;
		yVel = -(10 * (y - 250)) / (500 - x);
		pointsPlayed++; 
	}

}
