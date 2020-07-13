import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener{

	private boolean play;
	private final int WINSCORE = 2;
	private Timer timer;
	private int delay = 8;
	private PaddleMovement paddles;
	private Ball ball;
	private Font font = new Font("Calibri", Font.PLAIN, 100);
	
	private Menu menu;
	
	//Game States
	public static enum STATE{
		MENU,
		GAME,
		QUIT
	}
	
	public static STATE State = STATE.MENU;
	
	public Game() {
		play = true;
		paddles = new PaddleMovement(false);
		ball = new Ball(25, 475, 475, 3.2, -1, 0, WINSCORE, paddles);
		
//		if (true) {
//			paddles.setBall(ball);
//		}
		
		menu = new Menu();
		
		addMouseListener(new MouseInput());
		addKeyListener(paddles);
		setFocusable(true);
		
		timer = new Timer(delay, this);
		timer.start();
	}
	
	//Game window
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Main.screenSize, Main.screenSize);
		g.setColor(Color.white);
		g.setFont(font);
		
		if (State == STATE.GAME) {
			if (ball.getPlayer1Score() >= WINSCORE) {
				g.drawString("Player 1 WON!", 200, 500);
				return;
			}
			
			if (ball.getPlayer2Score() >= WINSCORE) {
				g.drawString("Player 2 WON!", 200, 500);
				return;
			}
			
			g.fillRect(2, paddles.getPlayer1Y(), 20, 150);
			g.fillRect(Main.screenSize - 20, paddles.getPlayer2Y(), 20, 150);
			g.fillOval(ball.getX(), ball.getY(), ball.getSize(), ball.getSize());
			
			g.drawString(Integer.toString(ball.getPlayer1Score()), Main.screenSize / 2 - 100, 200);
			g.drawString(Integer.toString(ball.getPlayer2Score()), Main.screenSize / 2 + 100, 200);

		} else if (State == STATE.MENU) {
			menu.paint(g);
		}
				
		g.dispose();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		timer.start();
		
		if (State == STATE.GAME) {
			ball.ballBounce();
			paddles.paddleMovement();
		} else {
			resetGame();
		}
		
		repaint();
	}
	
	//Resets game to default values
	public void resetGame() {
		timer.stop();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ball.setPlayer1Score(0);
		ball.setPlayer2Score(0);
		ball.setVelocity(3.2);
		ball.setX(Main.screenSize / 2 - ball.getSize());
		ball.setY(Main.screenSize / 2 - ball.getSize());
		paddles.setPlayer1Y(Main.screenSize / 2 - 50);
		paddles.setPlayer2Y(Main.screenSize / 2 - 50);
		timer.start();
	}
}
