package MagicBox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MagicBox extends JPanel implements Runnable, MouseListener {

	/*
	 * Work together as a TEAM of 2 or 3 to make this project. We are going to hide secrets within the magic box. 
	 * When the user clicks on a secret place, stuff will happen.
	 * 
	 * 1. Make the frame respond to mouse clicks.
	 * 
	 * 2. When the mouse is clicked, use the Media Palace (bit.ly/media-palace) to play sounds, show images or speak.
	 * 
	 * 3. backgroundImage.getRGB(keyEvent.getX(), keyEvent.getY()) will give you the color of the current pixel.
	 */

	JFrame frame;
	BufferedImage backgroundImage;
	boolean start = true;
	JLabel image;

	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(new MagicBox());
	}

	@Override
	public void run() {
		try {
			loadBackgroundImage();
			createUI();
		} catch (Exception w) {
			System.err.println(w.getMessage());
		}
	}

	private void createUI() {
		frame = new JFrame("The Magic Box contains many secrets...");
		frame.add(this);
		frame.addMouseListener(this);
		setPreferredSize(new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight()));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void loadBackgroundImage() throws Exception {
		String imageFile = "/Users/league/Google Drive/league-images/magic-box.jpg";
		try {
			backgroundImage = ImageIO.read(new File(imageFile));
		} catch (IOException e) {
			throw new Exception("Could not load image: " + imageFile);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		if(start)
		{
			g.setColor(Color.BLACK);
			g.drawRect(1000, 855, 100, 100); //Click on this rektangle and you will be drawRekt!
			g.drawImage(backgroundImage, 0, 0, null);
			start = false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println(backgroundImage.getRGB(e.getX(), e.getY()));
		System.out.println(e.getX() + ", " + e.getY());
		if(e.getX() < 50 || e.getY() < 50)
		{
			System.out.println("HEY!");
			JLabel newImage = new JLabel();
			newImage = new MediaPalace().loadImageFromWithinProject("MagicBoxCeption3.png");
			setPreferredSize(new Dimension(newImage.getWidth(), newImage.getHeight()));
			frame.add(newImage);
			frame.pack();
		}
		else if((e.getX() > 50 && e.getX() < 100) || (e.getY() > 50 && e.getY() < 100))
		{
			System.out.println("HEY! GOOGLE!");
			JLabel newImage = new JLabel();
			newImage = new MediaPalace().loadImageFromWithinProject("YOUR_COMPUTER_IS_STUCK.png");
			setPreferredSize(new Dimension(newImage.getWidth(), newImage.getHeight()));
			frame.add(newImage);
			frame.pack();
		}
		else if(e.getX() < 200)
		{
			System.out.println("HEY! IT'S ACTUALLY DECEPTION ISLAND! NOW THAT IS TRUE DECEPTION!");
			JLabel newImage = new JLabel();
			newImage = new MediaPalace().loadImageFromWithinProject("2016_Dec.jpg");
			setPreferredSize(new Dimension(newImage.getWidth(), newImage.getHeight()));
			frame.add(newImage);
			frame.pack();
		}
		//1000, 855 - 1100, 955
		//else if(e.getX() > 1000 && e.getY() > 855 && e.getX() < 1100 && e.getY() < 955)
		else
		{
			System.out.println("HEY! THAT EYE, THOUGH! REALLY CREEPY! DON'T STARE AT IT!");
			JLabel newImage = new JLabel();
			newImage = new MediaPalace().loadImageFromWithinProject("2016_Decreepy.jpg");
			setPreferredSize(new Dimension(newImage.getWidth(), newImage.getHeight()));
			frame.add(newImage);
			frame.pack();
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}


