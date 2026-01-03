package pingpong;

import java.awt.Color;

public class ObjectManager {

	Player playerOne = new Player(40, 200, 25, 50, Color.RED, 10);
	Player playerTwo = new Player(720, 200, 25, 50, Color.YELLOW, 10);
	Ball ball = new Ball(playerOne.x, playerOne.y, 25, 25, 0, Color.WHITE); 
	Table table = new Table(200, 100, 400, 220, 0, Color.BLUE); 
	
	public ObjectManager() {
		// TODO Auto-generated constructor stub
	}
	//TODO: add update and draw methods
	//TODO: Object manager could be a keyListener
	//TODO: allow player to hold the ball before serving
	//TODO: implement serving functionality 
	//TODO: Make player able to hit the ball
	//TODO: Make it so that when player approaches ball faster it travels faster
	

}
