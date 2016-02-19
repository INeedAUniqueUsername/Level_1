package Notflix;
import java.util.Random;

//Paste the code below into 2 classes called Movie and NetflixQueue.
//Create your own class with a main() method that will use Movie and NetflixQueue to complete the following challenges:
	//1. Instantiate some Movie objects (at least 5).
	//2. Use the Movie class to get the ticket price of one of your movies.

	//3. Instantiate a NetflixQueue.
	//4. Add your movies to the Netflix queue.
	//5. Print all the movies in your queue.
	
	//6. Use your NetflixQueue object to finish the sentence "the best movie is...."
	//7. Use your NetflixQueue to finish the sentence "the second best movie is...." 


public class Notflix {
	public static void main(String[] args)
	{
		System.out.println("Welcome to Notflix!");
		speak("Welcome to Notflix!");
		
		Movie[] moviez = new Movie[5];
		moviez[0] = new Movie("The Wizard", 0);
		moviez[1] = new Movie("Jaws 12", 0);
		moviez[2] = new Movie("Star Wars: The Force Awakens", 5);
		moviez[3] = new Movie("Super Mario Brothers", 0);
		moviez[4] = new Movie("Star Wars 8", 2);
		
		System.out.println(moviez[0].getTicketPrice());
		
		NotflixQueue queue = new NotflixQueue();
		for(int i = 0; i < 5; i++)
		{
			queue.addMovie(moviez[i]);
		}
		queue.printMovies();
		
		for(int i = 1; i < 5; i++)
		{
			System.out.println("Movie number " + i + " is... " + queue.getMovie(i));
			System.out.println(queue.getMovie(i).getTicketPrice());
			speak("Movie number " + i + " is... " + queue.getMovie(i));
			speak(queue.getMovie(i).getTicketPrice());

		}
		
		System.out.println("The best movie is... " + queue.getBestMovie());
		speak("The best movie is... " + queue.getBestMovie());
		System.out.println("The second best movie is... " + queue.getMovie(new Random().nextInt(5)));
		speak("The second best movie is... " + queue.getMovie(new Random().nextInt(5)));
		
		String[] argumentz = new String[9];
		argumentz[0] = "It's clearly better.";
		argumentz[1] = "The other one was so bad.";
		argumentz[2] = "It's the only one that's actually good!";
		argumentz[3] = "Trust me, I'm a certified movie critic.";
		argumentz[4] = "Enough said.";
		argumentz[5] = "I watched all the other movies and they were all terrible!";
		argumentz[6] = "This one is actually good.";
		argumentz[7] = "Why won't you understand?!";
		argumentz[8] = "It's the REAL best movie!";
		
		for(int i = 1; i < 100; i++)
		{
			String argumentMessage = "";
			argumentMessage = argumentMessage + "NO";
			for(int noz = 1; noz < i; noz++)
			{
				argumentMessage = argumentMessage + " NO";
			}
			argumentMessage = argumentMessage + "! The second best movie is clearly " + queue.getMovie(new Random().nextInt(moviez.length-1)) + "! ";
			argumentMessage = argumentMessage + argumentz[new Random().nextInt(argumentz.length)];
			System.out.println(argumentMessage);
			speak(argumentMessage);
		}
	}
	static void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
