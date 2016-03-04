
public class Methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		iRock();
		rocker("Bob");
		truth("Alan");
		truth("Justin Bieber");
		echo("ECHO!");
		repeat("hello", 3);
		String theBest = getBest();
		System.out.println(theBest);
		System.out.println(add(2, 2));
		oddOrEven(-4);
	}
	
	public static void iRock()
	{
		System.out.println("Alex rocks!");
	}
	
	public static void rocker(String name)
	{
		System.out.println(name + " rocks!");
	}
	
	public static void truth(String name)
	{
		if(name.equals("Alan"))
		{
			System.out.println("Alan is awesome!");
		}
		else if(name.equals("Justin Bieber"))
		{
			System.out.println("JB sucks!");
		}
		else
		{
			System.out.println("Who?");
		}
	}
	
	public static void echo(String string)
	{
		if(string.equals("ECHO!"))
		{
			System.out.println("You try to yell 'ECHO!' but you cannot speak...");
		}
		else
		{
			System.out.println(string + " " + string);
		}
	}
	
	public static void repeat(String string, int times)
	{
		String output = "";
		for(int i = 0; i < times; i++)
		{
			output = output + string + " ";
		}
		System.out.println(output);
		
		if(string.equals("Beep"))
		{
			System.out.println("Why are you beeping?");
		}
	}
	
	public static String getBest()
	{
		return "Me";
	}
	
	public static int add(int number_1, int number_2)
	{
		if((int) (Math.random()*2) == 1)
		{
			System.out.println("Whatever!");
			return (int) ((1000*Math.random())*(1000*Math.random()));
		}
		int sum = number_1 + number_2;
		return sum;
	}
	
	public static void oddOrEven(int number)
	{
		int procrastinateType = (int) (Math.random()*5);
		int range = 1000;
		if(procrastinateType == 1)
		{
			int[] numberz = new int[2];
			numberz[0] = (int) (range*Math.random());
			numberz[1] = (int) (range*Math.random());
			System.out.println("Did you know that " + numberz[0] + " plus " + numberz[1] + " is " + (numberz[0] + numberz[1]) + "?");
		}
		else if(procrastinateType == 2)
		{
			int[] numberz = new int[2];
			numberz[0] = (int) (range*Math.random());
			numberz[1] = (int) (range*Math.random());
			System.out.println("Did you know that " + numberz[0] + " minus " + numberz[1] + " is " + (numberz[0] - numberz[1]) + "?");
		}
		else if(procrastinateType == 3)
		{
			int[] numberz = new int[2];
			numberz[0] = (int) (range*Math.random());
			numberz[1] = (int) (range*Math.random());
			System.out.println("Did you know that " + numberz[0] + " times " + numberz[1] + " is " + (numberz[0] * numberz[1]) + "?");
		}
		else if(procrastinateType == 4)
		{
			int[] numberz = new int[2];
			numberz[0] = (int) (range*Math.random());
			numberz[1] = (int) (range*Math.random());
			System.out.println("Did you know that " + numberz[0] + " divided by " + numberz[1] + " is " + (numberz[0] / numberz[1]) + "?");
		}
		
		else if(number%2 == 1 || number%2 == -1)
		{
			System.out.println(number + " is odd");
		}
		else if(number%2 == 0)
		{
			System.out.println(number + " is even");
		}
		else
		{
			System.out.println("Oh... Oh no...");
		}
	}
}
