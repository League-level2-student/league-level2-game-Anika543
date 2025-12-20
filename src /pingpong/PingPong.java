package pingpong;

import javax.swing.JFrame;

public class PingPong {
	
	JFrame frame; 
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800; 
	
	public static void main(String[] args) {
		PingPong a = new PingPong(); 
		
	}
	
	public PingPong() {
		this.frame = new JFrame(); 
	}
	
	void setup() {
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	
}
