import org.teachingextensions.logo.PenColors;
import org.teachingextensions.logo.Tortoise;

public class ChristmasTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tortoise.setSpeed(10);
		
		Tortoise.setAngle(0);
		
		Tortoise.penUp();
		Tortoise.move(200);
		Tortoise.penDown();
		//Tortoise.setPenColor(PenColors.Yellows.Gold);
		
		
		//Star
		/*Tortoise.setAngle(90);
		for(int i = 1; i < 6; i ++)
		{
			Tortoise.turn(144);
			Tortoise.move(25);
		}*/
		
		Tortoise.setPenColor(PenColors.Grays.Black);
		Tortoise.turn(120);
		Tortoise.move(25);
		
		for(int i = 1; i < 3; i++)
		{
			/*int extension = i*5;
			Tortoise.move(50+extension);
			Tortoise.turn(135);
			Tortoise.move(25);
			Tortoise.turn(-135);
			*/
			Tortoise.turn(135);
			Tortoise.move(25+i*10);
		}
		
		//15+20+25+30+35+40+45
		
		
	}

}
