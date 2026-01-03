package pingpong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	Font titleFont;
	Font font;
	Timer frameDraw;
	PlayerOne playerOne = new PlayerOne(40, 200, 25, 50);
	PlayerTwo playerTwo = new PlayerTwo(720, 200, 25, 50);
	int currentState = MENU;

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}

	}

	void updateMenuState() {

	}

	void updateGameState() {
		playerOne.update();
		playerTwo.update(); 
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, PingPong.WIDTH, PingPong.HEIGHT);

		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("PingPong", 220, 100);

		g.setFont(font);
		g.setColor(Color.YELLOW);
		g.drawString("Press SPACE for instructions", 300, 250);
		;
		g.drawString("Press ENTER to start", 300, 300);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, PingPong.WIDTH, PingPong.HEIGHT);
		
		playerOne.draw(g); 
		playerTwo.draw(g); 

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, PingPong.WIDTH, PingPong.HEIGHT);

		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Game Over", 220, 100);

		g.setFont(font);
		g.setColor(Color.YELLOW);
		g.drawString("Your Score was " + "", 300, 250);
		;
		g.drawString("Press ENTER to restart", 300, 300);

	}

	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 70);
		font = new Font("Arial", Font.PLAIN, 20);

		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}

		//ystem.out.println("action");
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}   
		
		if (currentState == GAME) {
		//playerOne movement
			if (e.getKeyCode() == KeyEvent.VK_W) {
				System.out.println("UP");
				playerOne.movingUp = true; 
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				System.out.println("DOWN");
				playerOne.movingDown = true; 
			}
			if (e.getKeyCode() == KeyEvent.VK_A) {
				System.out.println("LEFT");
				playerOne.movingLeft = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_D) {
				System.out.println("RIGHT");
				playerOne.movingRight = true; 
			}
		//playerTwo movement 	
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				System.out.println("UP2");
				playerTwo.movingUp = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				System.out.println("DOWN2");
				playerTwo.movingDown = true; 
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.println("LEFT2");
				playerTwo.movingLeft = true; 
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println("RIGHT2");
				playerTwo.movingRight = true; 
			}
		
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (currentState == GAME) {
			//playerOne movement
				if (e.getKeyCode() == KeyEvent.VK_W) {
					System.out.println("UP");
					playerOne.movingUp = false; 
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					System.out.println("DOWN");
					playerOne.movingDown = false; 
				}
				if (e.getKeyCode() == KeyEvent.VK_A) {
					System.out.println("LEFT");
					playerOne.movingLeft = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_D) {
					System.out.println("RIGHT");
					playerOne.movingRight = false; 
				}
			//playerTwo movement 	
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					System.out.println("UP2");
					playerTwo.movingUp = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					System.out.println("DOWN2");
					playerTwo.movingDown = false; 
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					System.out.println("LEFT2");
					playerTwo.movingLeft = false; 
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					System.out.println("RIGHT2");
					playerTwo.movingRight = false; 
				}
			
			}
	}
}















