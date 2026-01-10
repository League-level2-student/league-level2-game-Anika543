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

public class GamePanel extends JPanel implements ActionListener{

	static final int MENU = 0;
	static final int GAME = 1;
	static final int END = 2;
	Font titleFont;
	Font font;
	Timer frameDraw;
//	Player playerOne = new Player(40, 200, 25, 50, Color.RED, 10);
//	Player playerTwo = new Player(720, 200, 25, 50, Color.YELLOW, 10);
//	Ball ball = new Ball(playerOne.x, playerOne.y, 25, 25, 0, Color.WHITE); 
//	Table table = new Table(200, 100, 400, 220, 0, Color.BLUE); 
	static int currentState = MENU;
	ObjectManager objectManager = new ObjectManager(); 

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
		objectManager.update(); 
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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, PingPong.WIDTH, PingPong.HEIGHT);
		
		objectManager.draw(g); 

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


	}
















