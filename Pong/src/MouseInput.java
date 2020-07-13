import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		/*
		  	public Rectangle playButton = new Rectangle(Main.screenSize / 2 - 75, 300, 200, 100);
			public Rectangle quitButton = new Rectangle(Main.screenSize / 2 - 75, 500, 200, 100);
		 */
		
		if (mx >= Main.screenSize / 2 - 75 && mx <= Main.screenSize / 2 + 275) {
			if (my >= 300 && my <= 400) {
				//Pressed playbutton
				Game.State = Game.State.GAME;
			}
		}
		
		if (mx >= Main.screenSize / 2 - 75 && mx <= Main.screenSize / 2 + 275) {
			if (my >= 500 && my <= 600) {
				//Pressed quit
				System.exit(1);
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
