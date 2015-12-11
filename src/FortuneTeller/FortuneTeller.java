package FortuneTeller;
// Copyright Wintriss Technical Schools 2013
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class FortuneTeller extends JPanel implements Runnable, MouseListener {

    String[] fortuneTellerImageStrings = new String[2];
    BufferedImage fortuneTellerImage;

    int frameWidth = 500;
    int frameHeight = 400;

    int imageNumber;
    FortuneTeller() throws Exception {
   	 // 1. Choose an image for your fortune teller and put it in your default package
   	 fortuneTellerImageStrings[0] = "Google Chrome The Fortune Teller.png";
   	 fortuneTellerImageStrings[1] = "Internet Explorer The Very Slow 2.png";
   	 imageNumber = new Random().nextInt(fortuneTellerImageStrings.length);
   	 String imageString = fortuneTellerImageStrings[imageNumber];
  	 fortuneTellerImage = ImageIO.read(getClass().getResource(imageString));
   	 
   	 // 2. Adjust the framexeWidth and frameHeight variables to fit your image nicely (doesn’t need a new line of code)
   	 frameWidth = fortuneTellerImage.getWidth();
   	 frameHeight = fortuneTellerImage.getHeight();
   	 // 4. add a mouse listener
   	 addMouseListener(this);
   	 

    }

    static void begin() {
   	 // 3. Welcome the user. Give them a hint for the secret location.
    	JOptionPane messageBox = new JOptionPane();
    	messageBox.showMessageDialog(null, "WELCOME TO YOUR BROWSING SESSION! TODAY, YOU MUST FIND THE SEARCH BAR YOURSELF! IT IS HIDING SOMEWHERE IN THIS IMAGE!");
    }

    @Override
    public void mousePressed(MouseEvent e) {
   	 int mouseX = e.getX();
   	 int mouseY = e.getY();
   	 // 5. Print the mouseX variable
   	 System.out.println(mouseX + " " + mouseY);
   	 // 6. Add the mouseY variable to the previous line so that it prints out too (no new line)
   	 // 7. Adjust your secret location co-ordinates here:
   	 int secretLocationX = new Random().nextInt(frameWidth); //frameWidth/2
   	 int secretLocationY = new Random().nextInt(frameHeight); //frameHeight/2
   	 /** If the mouse co-ordinates and secret location are close, we'll let them ask a question. */
   	 if (areClose(mouseX, secretLocationX) && areClose(mouseY, secretLocationY)) {
   		 // 8. Get the user to enter a question for the fortune teller
   		 JOptionPane.showInputDialog("WHAT WOULD YOU LIKE TO SEARCH FOR TODAY?!");
   		 // 9. Find a spooky sound and put it in your default package (freesound.org)
   		 AudioClip sound = JApplet.newAudioClip(getClass().getResource("batman.wav"));
   		 // 10. Play the sound
   		 sound.play();
   		 // 11. Use the pause() method below to wait until your music has finished
   		 if(imageNumber == 0)
   		 {
   			 pause(10);
   		 }
   		 if(imageNumber == 1)
   		 {
   			 pause(60);
   		 }
   		 // 12. Insert your completed Magic 8 ball recipe (http://bit.ly/Zdrf6d) here
   		 sound.stop();
   		 
 		JOptionPane messageBox = new JOptionPane();
   		 if(imageNumber == 1)
   		 {
   			 showError(true, 1);
   		}

 		int randomNumber = new Random().nextInt(4);
 		System.out.println(randomNumber);
 		messageBox.showInputDialog("Do you really want to know?");
 		if(randomNumber == 0)
 		{
 			messageBox.showMessageDialog(null, "Yes");
 		}
 		if(randomNumber == 1)
 		{
 			messageBox.showMessageDialog(null,  "No");
 		}
 		if(randomNumber == 2)
 		{
 			messageBox.showMessageDialog(null, "Maybe you should ask Google");
 		}
 		if(randomNumber == 3)
 		{
 			messageBox.showMessageDialog(null, "I honestly do not care");
 		}
 		System.exit(0);
   	 }

    }
    
    public void showError(boolean repeat, int reps)
    {
		new JOptionPane().showMessageDialog(null, "ERROR! Total number of errors: " + reps);
		if(new Random().nextInt(reps) == reps)
    	if(repeat)
    	{
    		showError(repeat, reps + 1);
    	}
    }

    private boolean areClose(int mouseX, int secretLocationX) {
    	int maxDistance = 150; //150 //15 
    	
   	 return mouseX < secretLocationX + maxDistance && mouseX > secretLocationX - maxDistance;
    }

    private void pause(int seconds) {
   	 try {
   		 Thread.sleep(1000 * seconds);
   	 } catch (InterruptedException e) {
   		 e.printStackTrace();
   	 }
    }
    
    /**************** don't worry about the stuff under here *******************/

    public static void main(String[] args) throws Exception {
   	 SwingUtilities.invokeLater(new FortuneTeller());
   	 begin();
    }

    @Override
    public void run() {
   	 JFrame frame = new JFrame();
   	 frame.add(this);
   	 setPreferredSize(new Dimension(frameWidth, frameHeight));
   	 frame.pack();
   	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	 frame.setResizable(false);
   	 frame.setVisible(true);
    }

private void showAnotherImage(String imageName) {
   	 try {
   		 fortuneTellerImage = ImageIO.read(getClass().getResource(imageName));
   	 } catch (Exception e) {
   		 System.err.println("Couldn't find this image: " + imageName);
   	 }
   	 repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
   	 g.drawImage(fortuneTellerImage, 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}


