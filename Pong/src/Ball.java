import java.awt.Rectangle;

public class Ball {

	private static final double MAXBOUNCEANGLE = 60 * Math.PI / 180;

	private PaddleMovement paddles;

	private int size;
	private int x;
	private int y;
	private double velocity;
	private double xDir;
	private double yDir;

	private int player1Score = 0;
	private int player2Score = 0;

	public Ball(int ballSize, int bx, int by, double ballVelocity, double ballXDir, double ballYDir, int winScore,
			PaddleMovement paddles) {
		super();
		this.size = ballSize;
		this.x = bx;
		this.y = by;
		this.velocity = ballVelocity;
		this.xDir = ballXDir;
		this.yDir = ballYDir;
		this.paddles = paddles;
	}


	public void ballBounce() {

		//Multiplies the direction of the ball by ball velocity
		x += xDir * velocity;	
		y += yDir * velocity;

		Rectangle ball = new Rectangle(x, y, size, size);
		Rectangle p1 = new Rectangle(2, paddles.getPlayer1Y(), 20, 150);
		Rectangle p2 = new Rectangle(965, paddles.getPlayer2Y(), 20, 150);

		//Bounces the paddle according to its position and angle from the center of the paddle
		if (ball.intersects(p1)) {

			double relativeIntersectY =  (p1.getCenterY() - ball.getCenterY()) / (p1.getHeight()/2);
			double bounceAngle = relativeIntersectY * MAXBOUNCEANGLE;
			xDir = velocity * Math.cos(bounceAngle);
			yDir = velocity *-Math.sin(bounceAngle);

			velocity *= 1.005;

			System.out.println("Ball velocity " + velocity);
//			System.out.println("X dir " + xDir);
//			System.out.println("Y dir " + yDir);

		} else if (ball.intersects(p2)) {

			double relativeIntersectY =  (p2.getCenterY() - ball.getCenterY()) / (p2.getHeight()/2);
			double bounceAngle = relativeIntersectY * MAXBOUNCEANGLE;
			xDir = velocity * -Math.cos(bounceAngle);
			yDir = velocity * -Math.sin(bounceAngle);

			velocity *= 1.005;

			System.out.println("Ball velocity " + velocity);
//			System.out.println("X dir " + xDir);
//			System.out.println("Y dir " + yDir);
		}

		if (y < 0) {
			yDir = -yDir;
		} 

		if (y > 950) {
			yDir = -yDir;
		}

		if (x < -25) {
			player2Score++;
			System.out.println(player2Score);
			xDir = -1;
			yDir = 0;
			reset();
		}

		if (x > 1000) {
			player1Score++;
			System.out.println(player1Score);
			xDir = 1;
			yDir = 0;
			reset();
		}
	}

	public void reset() {
		x = 475;
		y = 475;
		velocity = 3;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public double getxDir() {
		return xDir;
	}

	public void setxDir(double xDir) {
		this.xDir = xDir;
	}

	public double getyDir() {
		return yDir;
	}

	public void setyDir(double yDir) {
		this.yDir = yDir;
	}

	public int getPlayer1Score() {
		return player1Score;
	}

	public void setPlayer1Score(int player1Score) {
		this.player1Score = player1Score;
	}

	public int getPlayer2Score() {
		return player2Score;
	}

	public void setPlayer2Score(int player2Score) {
		this.player2Score = player2Score;
	}

	public int getSize() {
		return size;
	}
	
	public double getBounceAngle() {
		return MAXBOUNCEANGLE;
	}

}