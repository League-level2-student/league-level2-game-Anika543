package pingpong;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class GamePanel {

	final int MENU = 0;
	final int GAME = 1; 
	final int END = 2; 
	Font titleFont; 
	Font font; 
	Timer frameDraw; 
	
	int currentState = MENU; 
	

	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		font = new Font("Arial", Font.PLAIN, 20);

		frameDraw = new Timer(1000 / 60, (ActionListener) this);
		frameDraw.start();
	}
}
