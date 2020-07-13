import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Main {
	
	public static final int screenSize = 1000;
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Pong");
		Game game = new Game();
		window.add(game);
		window.setSize(screenSize, screenSize);
		window.setResizable(false);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
