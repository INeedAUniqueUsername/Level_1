import java.applet.AudioClip;
import java.io.IOException;
import java.util.Random;

import javax.swing.JApplet;

public class CowTimer {
	/*
	 * This is an advanced recipe. There may be more than one line of code for
	 * each instruction.
	 */

	public static void main(String[] args) throws InterruptedException {
		/* 1. Make a CowTimer, set the time and start it. */
		CowTimer milk = new CowTimer();
		milk.setTime(5);
		milk.start();
	}

	private int minutes;
	
	private int speed = 1;
	
	

	public void setTime(int minutes) {
		this.minutes = minutes;
		System.out.println("Cow set to " + minutes + " minutes.");
	}

	public void start() throws InterruptedException {
		/*
		 * 2. Count down the minutes, print the current minute then sleep for 60
		 * seconds using Thread.sleep(int milliseconds).
		 */
		
		System.out.println(minutes + " minutes left");
		for(int i = 0; i < minutes*60; i++)
		{
			playSound("quack.wav");
			System.out.println((60 - i) + " seconds left");
			//double disruption = new Random().nextFloat() - .5;
			//Thread.sleep((int) (1000+2000*disruption));
			Thread.sleep(1000);
		}
		
		/*
		 * 3. When the timer is finished, use the playSound method to play a moo
		 * sound. You can download one from freesound.org, then drag it into
		 * your default package. Tell the students (by speaking) it's time to walk.
		 */
		playSound("moo.wav");
		speak("i t ' s t i m e t o w a l k");
		
		System.exit(0);
	}

	private void playSound(String fileName) {
		AudioClip sound = JApplet
				.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

private void speak(String stuffToSay) {
		try {
			Runtime.getRuntime().exec("say " + stuffToSay).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}

