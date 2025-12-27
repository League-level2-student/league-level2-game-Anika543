package pingpong;

import javax.swing.JFrame;

public class PingPong {

	JFrame frame;
	GamePanel gamePanel;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 500;

	public static void main(String[] args) {
		PingPong a = new PingPong();
		a.setup();
	}

	public PingPong() {
		this.frame = new JFrame();
		this.gamePanel = new GamePanel();
	}

	void setup() {
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.add(gamePanel);
		frame.addKeyListener(gamePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
