import java.util.Random;

import org.teachingextensions.logo.MultiTurtlePanel;
import org.teachingextensions.logo.Turtle;

public class LandOfTurtles {
	public static void main(String[] args) {
		MultiTurtlePanel panel = new MultiTurtlePanel();
		String galapagosIslands = "https://farm2.staticflickr.com/1104/752631367_5c5d474ba5_o.jpg";
	
		panel.setName("Too Many Turtles?!");
		
		/* 1. Get the panel to show */
		panel.showPanel();
		/* 2. Set the background image of the panel to the Galapagos Islands */
		panel.setBackgroundImage(galapagosIslands);
		/* 3. Instantiate a Turtle and add it to the panel */
		panel.addTurtle(new Turtle());
		/* 4. Put 50 Turtles on the beach. */
		//Turtle turtle1 = new Turtle();
		for(int i = 1; i < 250; i++)
		{
			Turtle turtle = new Turtle();
			turtle.setX(new Random().nextInt(750));
			turtle.setY(new Random().nextInt(225) + 175);
			panel.addTurtle(turtle);
		}

	}
}
