
// Copyright The League of Amazing Programmers, 2015
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

/* 1. Download the JavaZoom jar from here: http://bit.ly/javazoom
 * 2. Right click your project and add it as an External JAR (Under Java Build Path > Libraries).*/

public class Jukebox implements Runnable, ActionListener {

	JFrame frame;
	JPanel panel;
	JButton[] buttons;
	Song[] songs;

	public static void main(String[] args) throws IOException, JavaLayerException {
		SwingUtilities.invokeLater(new Jukebox());
	}

	public void run() {

		// 3. Find an mp3 on your computer or on the Internet.
		// 4. Create a Song
		System.out.println("You hear a creepy noise...");
		Song creepyNoise = new Song("creepy-noise.wav");
		// 5. Play the Song
		creepyNoise.setDuration(1);
		creepyNoise.play();
		System.out.println("The creepy noise fades away...");
		/*
		 * 6. Create a user interface for your Jukebox so that the user can to
		 * choose which song to play. You can use can use a different button for
		 * each song, or a picture of the album cover. When the button or album
		 * cover is clicked, stop the currently playing song, and play the one
		 * that was selected.
		 */
		System.out.println("A Jukebox starts to materialize");
		frame = new JFrame("Laugh Tracks!");
		panel = new JPanel();
		buttons = new JButton[3];
		songs = new Song[3];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
		}
		buttons[0].setText("Spongebob");
		buttons[1].setText("Patrick");
		buttons[2].setText("Squidward");
		
		songs[0] = new Song("spongebob.wav");
		songs[1] = new Song("patrick.wav");
		songs[2] = new Song("squidward.wav");
		
		songs[0].setDuration(2);
		songs[1].setDuration(2);
		songs[2].setDuration(2);
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(this);
			panel.add(buttons[i]);
		}
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		System.out.println("A Jukebox has appeared for no apparent reason!");
	}

	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("You press one of the mysterious buttons...");
		for(int i = 0; i < songs.length; i++)
		{
			songs[i].stop();
		}
		System.out.println("The Jukebox goes silent...");
		if (e.getSource().equals(buttons[0])) {
			songs[0].play();
			System.out.println("The Jukebox laughs like Spongebob...");
		}
		
		else if (e.getSource().equals(buttons[1])) {
			songs[1].play();
			System.out.println("The Jukebox laughs like Patrick...");
		}
		
		if (e.getSource().equals(buttons[2])) {
			songs[2].play();
			System.out.println("The Jukebox laughs like Squidward...");
		}
	}
}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet
	 * addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}
