import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PaddleMovement extends KeyAdapter {
	
	private boolean singlePlayer;
	
	private Ball ball;
	
	private int player1Y = 450;
	private int player2Y = 450;
	
	private int player2Height = 150;
	private int paddleSpeed = 15;

	private boolean upKeyIsDown = false;
	private boolean downKeyIsDown = false;
	private boolean wKeyIsDown = false;
	private boolean sKeyIsDown = false;

	PaddleMovement(boolean singlePlayer) {
		this.singlePlayer = singlePlayer;
		player1Y = 450;
		player2Y = 450;
	}
	
	public void setBall(Ball ball) {
		this.ball = ball;
	}
	
	public void AI() {
		double distanceFromPaddle = player2Height - ball.getX();
		double targetY = ball.getY() + distanceFromPaddle * Math.tan(-ball.getY() / ball.getX());
        boolean paddleOnTarget = targetY >= player2Y && targetY + ball.getSize() <= player2Y + player2Height;
        if (paddleOnTarget) {
            
        } else if (targetY < player2Y) {
        	System.out.println("Target below than player1Y");
        	player2Y += 10;
        } else if (targetY > player2Y) {
        	System.out.println("Target above than player1Y");
        	player2Y -= 10;
        }
	}

	public int getPlayer1Y() {
		return player1Y;
	}

	public void setPlayer1Y(int player1y) {
		player1Y = player1y;
	}

	public int getPlayer2Y() {
		return player2Y;
	}

	public void setPlayer2Y(int player2y) {
		player2Y = player2y;
	}

	public void paddleMovement() {
//		if (!singlePlayer) {
//			
//		} else {
//			//AI();
//		}
		
		if (upKeyIsDown) {
			if (player2Y <= 0) {
				player2Y = 0;
			} else {
				player2Y -= paddleSpeed;
			}
		}

		if (downKeyIsDown) {
			if (player2Y >= 850) {
				player2Y = 850;
			} else {
				player2Y += paddleSpeed;
			}
		}
		
		
		if (wKeyIsDown) {
			if (player1Y <= 0) {
				player1Y = 0;
			} else {
				player1Y -= paddleSpeed;
			}
		}

		if (sKeyIsDown) {
			if (player1Y >= 850) {
				player1Y = 850;
			} else {
				player1Y += paddleSpeed;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			upKeyIsDown = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			downKeyIsDown = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_W) {
			wKeyIsDown = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_S) {
			sKeyIsDown = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			upKeyIsDown = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			downKeyIsDown = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_W) {
			wKeyIsDown = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_S) {
			sKeyIsDown = false;
		}
	}
}