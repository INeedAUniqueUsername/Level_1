import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.teachingextensions.logo.Paintable;
import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.Tortoise;

public class TurtlePond implements KeyEventDispatcher {

	// 1. Set a location for the cookie
	int cookieX = (int) (Math.random()*750);
	int cookieY = (int) (Math.random()*750);

	// 2. Choose the speed you want the Tortoise to go at
	int speed = 5;
	
	
	
	void setup() {
		// 3. Edit this intro message to your own style
		JOptionPane.showMessageDialog(null, "TURTLE NEEDS FOOD! FIND SECRET COOKIE!");
		
		// 4. For debugging purposes, show the cookie. The user won’t see this.
		showCookie();
	}

	private void goUp() {
		Tortoise.setAngle(0);
		Tortoise.move(speed);
	}

	private void goDown() {
		Tortoise.setAngle(180);
		Tortoise.move(speed);
	}

	private void goLeft() {
		// 5. make the tortoise move left at the specified speed (3 lines of code)
		Tortoise.setAngle(270);
		Tortoise.move(speed);
	}

	private void goRight() {
		// 6. use the speed variable to make the tortoise move right
		Tortoise.setAngle(90);
		Tortoise.move(speed);
	}

	private void checkForFood() throws Exception {
		int tortoiseLocationX = Tortoise.getX();
		int tortoiseLocationY = Tortoise.getY();

		double dist = Math.sqrt(Math.pow(tortoiseLocationX - cookieX, 2) + Math.pow(tortoiseLocationY - cookieY, 2));
		
		// 10. If the Tortoise is within 5 pixels of the cookie, make a pop-up to tell them they found it
		if(dist <= 5)
		{
			JOptionPane.showMessageDialog(null, "YOU SMELL FOOD!");
			System.exit(0);
		}
		
		// 9. If the Tortoise is within 20 pixels of the food, set the background color to red
		else if(dist <= 20)
		{
			setBackgroundColor(Color.RED);
			//startTime.setTime(new Date().getTime());
		}
		
		// 8. If the Tortoise is within 50 pixels of the food, set the background color to orange
		else if(dist <= 50)
		{
			setBackgroundColor(Color.ORANGE);
		}
		
		// 7. If the Tortoise is within 100 pixels of the food, set the background color to yellow

		else if(dist <= 100)
		{
			setBackgroundColor(Color.YELLOW);
		}
		
		// 11. If more than 20 seconds have elapsed, tell them the turtle died of hunger!
		if(getTimeElapsed() >= 20)
		{
			JOptionPane.showMessageDialog(null, "YOU TOO HUNGRY! YOU DEAD!");
			System.exit(0);
		}
		// 12. If the Tortoise crosses it's own path, tell them they failed and move them back to the beginning
		if(wasHereBefore(Tortoise.getX(), Tortoise.getY()))
		{
			//Tortoise.moveTo(getFirstLocation().x, getFirstLocation().y);
			
			Tortoise.setX(getFirstLocation().x);
			Tortoise.setY(getFirstLocation().y);
			previousLocations = new ArrayList<Point>();
			JOptionPane.showMessageDialog(null, "YOU GOING IN CIRCLES!");
		}
		
	}
	
	private long getTimeElapsed() {
		 Date currentTime = new Date();
		 return (currentTime.getTime() - startTime.getTime())/1000;
	}

	private void setBackgroundColor(Color color) {
		Tortoise.getBackgroundWindow().setBackground(color);
	}

	private void showCookie() {
		Tortoise.getBackgroundWindow().addPaintable(new Paintable() {
			public void paint(Graphics2D g, JPanel caller) {
				g.drawOval(cookieX, cookieY, 10, 10);
			}
		});
	}

	private boolean wasHereBefore(int xPosition, int yPosition) {
		if (previousLocations.contains(new Point(xPosition, yPosition)))
			return true;
		else
			return false;
	}

	private Point getFirstLocation() {
		return previousLocations.get(0);
	}

	/*********************** don't worry about the stuff under here ******************/

	Date startTime = new Date();

	public static void main(String[] args) {
		TurtlePond feeder = new TurtlePond();
		feeder.controlTheTortoise();
		feeder.setup();
	}

	private void controlTheTortoise() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
		Tortoise.show();
		Tortoise.setPenColor(PenColors.Purples.DarkMagenta);
		Tortoise.getBackgroundWindow().setBackground(PenColors.Grays.SlateGray);
		Tortoise.setSpeed(10);
	}

	public boolean dispatchKeyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_PRESSED) {

			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				goRight();
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
				goLeft();
			if (e.getKeyCode() == KeyEvent.VK_UP)
				goUp();
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
				goDown();

			try {
				checkForFood();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			savePosition(Tortoise.getX(), Tortoise.getY());
		}
		return false;
	}

	ArrayList<Point> previousLocations = new ArrayList<Point>();

	private void savePosition(int xPosition, int yPosition) {
		previousLocations.add(new Point(xPosition, yPosition));
	}
}



