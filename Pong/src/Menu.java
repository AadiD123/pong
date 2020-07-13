import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	
	Font fnt = new Font("Arial", Font.BOLD, 150);
	
	public Rectangle playButton = new Rectangle(Main.screenSize / 2 - 75, 300, 200, 100);
	public Rectangle quitButton = new Rectangle(Main.screenSize / 2 - 75, 500, 200, 100);
	
	public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt = new Font("Arial", Font.BOLD, 150);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("PONG", Main.screenSize / 2 - 200, 150);
		
		Font fnt2 = new Font("Arial", Font.PLAIN, 50);
		g.setFont(fnt2);
		g.drawString("Play", playButton.x + 40, playButton.y + 55);
		g.drawString("Quit", quitButton.x + 40, quitButton.y + 55);
		g2d.draw(playButton);
		g2d.draw(quitButton);
	}

}
