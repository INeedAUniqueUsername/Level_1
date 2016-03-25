import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/** We’re going to make a slideshow of cool optical illusions. When the user clicks on an illusion, a new one will be loaded. **/

public class BookOfIllusions extends MouseAdapter {

	/*
	 * Here we are instantiating our BookOfIllusions class and calling it’s createBook() method. This is because we want to get out of the
	 * static main method, so that we can add a click listener to each illusion.
	 */

	public static void main(String[] args) throws Exception {
		BookOfIllusions illusions = new BookOfIllusions();
		illusions.createBook();
	}

	// 1. Make a JFrame variable and initialize it using "new JFrame()"
	JFrame frame = new JFrame();
	JLabel label;
	String[] images;
	String[] messages;
	int imageNumber;
	
	private void createBook() {
		// 2. make the frame visible
		frame.setVisible(true);
		
		// 3. set the size of the frame
		frame.setSize(1600, 900);
		
		// 4. find 2 images and save them to your project’s default package
		// 5. make a variable to hold the location of your image. e.g. "illusion.jpg"
		images = new String[2];
		images[0] = "GOOGLE_IS_NOT_BING.png";
		images[1] = "BING_IS_NOT_GOOGLE.jpg";
		
		messages = new String[2];
		messages[1] = "Extra! Extra! Google bought by Microsoft and transformed into Googlesoft!";
		messages[0] = "Breaking News! The previous message was a lie! THIS IS UNUSUALLY SHOCKING!";
		// 6. create a variable of type "JLabel" but don’t initialize it yet
		label = new JLabel();
		// 7. use the "loadImage..." methods below to initialize your JLabel
		imageNumber = 0;
		label = loadImageFromComputer(images[imageNumber]);
		// 8. add your JLabel to the frame
		frame.add(label);
		// 9. call the pack() method on the frame
		frame.pack();
		// 10. add a mouse listener to your frame (hint: use *this*)
		frame.addMouseListener(this);
	}

	public void mousePressed(MouseEvent e) {
		// 11. Print "clicked!" to the console when the mouse is pressed
		System.out.println("clicked!");
		
		// 12. remove everything from the frame that was added earlier
		frame.remove(label);
		
		// 13. load a new image like before (this is more than one line of code)
		imageNumber++;
		
		
		label = loadImageFromComputer(images[imageNumber%images.length]);
		frame.add(label);
		
		// 14. pack the frame
		frame.pack();
		
		String input = new JOptionPane().showInputDialog("Google Translate");
		char[] letters = new char[input.length()];
		
		for(int i = 0; i < input.length(); i++)
		{
			letters[i] = input.charAt(i);
		}
		
		letters = new char[26];
		letters[0] = 'a';
		letters[1] = 'b';
		letters[2] = 'c';
		letters[3] = 'd';
		letters[4] = 'e';
		letters[5] = 'f';
		letters[6] = 'g';
		letters[7] = 'h';
		letters[8] = 'i';
		letters[9] = 'j';
		letters[10] = 'k';
		letters[11] = 'l';
		letters[12] = 'm';
		letters[13] = 'n';
		letters[14] = 'o';
		letters[15] = 'p';
		letters[16] = 'q';
		letters[17] = 'r';
		letters[18] = 's';
		letters[19] = 't';
		letters[20] = 'u';
		letters[21] = 'v';
		letters[22] = 'w';
		letters[23] = 'x';
		letters[24] = 'y';
		letters[25] = 'z';
		
		int repeats = input.length();
		input = "";
		for(int i = 0; i < repeats; i++)
		{
			int letterNumber = new Random().nextInt(letters.length);
			input = input + letters[letterNumber];
		}
		
		new JOptionPane().showMessageDialog(null, input);
		
		//new JOptionPane().showMessageDialog(null, messages[imageNumber%images.length]);
	}

	// [OPTIONAL] 15. goad your users with some annoying or witty pop-ups

	/*
	 * To use this method, the image must be placed in your Eclipse project under "default package".
	 */
	public JLabel loadImageFromComputer(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

}


