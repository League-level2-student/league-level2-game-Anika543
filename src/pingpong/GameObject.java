package pingpong;

import java.awt.Rectangle;

public class GameObject {

	int x;
	int y;
	int width;
	int height;
	int speed; 
	
	Rectangle collisionBox; 

	public GameObject(int x, int y, int width, int height, int speed) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed; 
		
		collisionBox = new Rectangle(x, y, width, height); 
	}

	void update() {
//TODO: update collision boxes
		collisionBox.setBounds(x, y, width, height); 
	}
}
