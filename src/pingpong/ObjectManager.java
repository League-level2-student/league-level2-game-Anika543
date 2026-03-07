package pingpong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class ObjectManager implements KeyListener {

	final int playerWidth = 20;
	final int playerHeight = 50;
	boolean hasBallBeenServed = false;

	Player playerOne = new Player(40, 200, playerWidth, playerHeight, Color.RED, 10, this, true, true);
	Player playerTwo = new Player(PingPong.WIDTH - 40 - playerOne.width, 200, playerWidth, playerHeight, Color.YELLOW,
			10, this, false, false);
	Ball ball = new Ball(playerOne.x, playerOne.y, 25, 25, 10, Color.WHITE, this);
	Table table = new Table(200, 150, 400, 200, 0, Color.BLUE, this);

	public ObjectManager() {
		// TODO Auto-generated constructor stub
	}

	// TODO: add update and draw methods
	public void update() {
		playerOne.update();
		playerTwo.update();
		ball.update();

		checkCollisions();
		
		
	}

	private void checkCollisions() {
		// TODO Auto-generated method stub
		if (hasBallBeenServed && ball.amountOfTimesBounced > 0) {
			if (ball.collisionBox.intersects(playerTwo.collisionBox)) {
				ball.xVel = -10;
				ball.amountOfTimesBounced = 0; 
				//ball.zVel = 10; 
				int bounceAngle = ball.y + ball.height/2 - (playerTwo.y + playerTwo.height/2); 
				ball.yVel = bounceAngle/9; 
				
			}
			if (ball.collisionBox.intersects(playerOne.collisionBox)) {
				ball.xVel = 10;
				ball.amountOfTimesBounced = 0; 
				//ball.zVel = 10; 
				int bounceAngle = ball.y + ball.height/2 - (playerOne.y + playerOne.height/2); 
				ball.yVel = bounceAngle/9; 
			}
			
			
		}

	}

	public void draw(Graphics g) {
		playerOne.draw(g);
		playerTwo.draw(g);
		table.draw(g);
		ball.draw(g);

	}

	// TODO: Object manager could be a keyListener
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// playerOne movement

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (GamePanel.currentState == GamePanel.END) {
				GamePanel.currentState = GamePanel.MENU;
				playerOne.x = 40; 
				playerOne.y = 200;
				playerTwo.x = PingPong.WIDTH - 40 - playerOne.width;
				playerTwo.y = 200; 
			} else {
				GamePanel.currentState++;
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE && GamePanel.currentState == GamePanel.MENU) {
			JOptionPane.showMessageDialog(null, "Use WASD to move the player on the left and arrow keys to move the player on the right");
			JOptionPane.showMessageDialog(null, "Hit the ball before it bounces on the floor");
			JOptionPane.showMessageDialog(null, "First player to 11 points wins");
		}
		
		
		if (GamePanel.currentState == GamePanel.GAME) {
			if (e.getKeyCode() == KeyEvent.VK_W) {
				//("UP");
				playerOne.movingUp = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				//("DOWN");
				playerOne.movingDown = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_A) {
				//("LEFT");
				playerOne.movingLeft = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_D) {
				//("RIGHT");
				playerOne.movingRight = true;
			}

			// playerTwo movement
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				//("UP2");
				playerTwo.movingUp = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				//("DOWN2");
				playerTwo.movingDown = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				//("LEFT2");
				playerTwo.movingLeft = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				//("RIGHT2");
				playerTwo.movingRight = true;
			}

//			if(!hasBallBeenServed) {
//				ball.x = playerOne.x; 
//				ball.y = playerOne.y; 
//
//			}

			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				if (!hasBallBeenServed) {
					hasBallBeenServed = true;
					ball.serve();

				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (GamePanel.currentState == GamePanel.GAME) {
			// playerOne movement
			if (e.getKeyCode() == KeyEvent.VK_T) {
				GamePanel.scoreOne = 10;
			}
			if (e.getKeyCode() == KeyEvent.VK_W) {
				//("UP");
				playerOne.movingUp = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				//("DOWN");
				playerOne.movingDown = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_A) {
				//("LEFT");
				playerOne.movingLeft = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_D) {
				//("RIGHT");
				playerOne.movingRight = false;
			}
			// playerTwo movement
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				//("UP2");
				playerTwo.movingUp = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				//("DOWN2");
				playerTwo.movingDown = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				//("LEFT2");
				playerTwo.movingLeft = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				//("RIGHT2");
				playerTwo.movingRight = false;
			}
		}

	}

	
	// TODO: Make it so that when player approaches ball faster it travels faster
	// TODO: Ball shouldn't bounce if off the table (give the player more time to hit the ball?)
	// TODO: If the player hits the ball at an angle the ball goes at an angle <- complete kind of
	// TODO: Fix player movement boundaries
	// TODO: Add images <-- next step


}
