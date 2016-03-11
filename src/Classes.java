
public class Classes {

	int procrastinate;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Class().iLike("Pi", calculateRandom(3));
		new Jumper().jump((int) (calculateRandom(250)));
	}
	
	public static int calculateRandom(int max)
	{
		int returnThis = (int) (max*Math.random());
		System.out.println(returnThis);
		return returnThis;
	}

}

class Class
{
	public void iLike(String what, int procrastinate)
	{
		if(procrastinate == 0)
		{
			System.out.println("I Like " + what);
		}
		if(procrastinate == 1)
		{
			System.out.println("Sometimes I don't like " + what);
		}
		if(procrastinate == 2)
		{
			System.out.println("You know what I really hate? " + what + "!");
		}
	}
}



class Jumper
{
	public void jump(int height)
	{
		String object = "whatever";
		if(height > 125)
		{
			object = "moon and became the first rodent to die in space...";
		}
		else if(height > 4)
		{
			object = "broom, which then fell and crushed it...";
		}
		else if(height > 2)
		{
			object = "candlestick and got burned...";
		}
		else if(height > 1)
		{
			object = "The mouse jumped over the ";
			//jump(2);
		}
		else if(height == 0)
		{
			object = "thing...";
		}
		System.out.println("The mouse jumped over the " + object);
	}
}