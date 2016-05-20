import java.applet.AudioClip;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements MouseListener {

	JFrame frame;
	JPanel panel;
	LayoutManager layout;
	JButton[] buttonz;
	int whacked;
	int missed;
	Date startTime = new Date();
	
	static char[] characterz = new char[26];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WhackAMole run = new WhackAMole();
		characterz[0] = 'a';
		characterz[1] = 'b';
		characterz[2] = 'c';
		characterz[3] = 'd';
		characterz[4] = 'e';
		characterz[5] = 'f';
		characterz[6] = 'g';
		characterz[7] = 'h';
		characterz[8] = 'i';
		characterz[9] = 'j';
		characterz[10] = 'k';
		characterz[11] = 'l';
		characterz[12] = 'm';
		characterz[13] = 'n';
		characterz[14] = 'o';
		characterz[15] = 'p';
		characterz[16] = 'q';
		characterz[17] = 'r';
		characterz[18] = 's';
		characterz[19] = 't';
		characterz[20] = 'u';
		characterz[21] = 'v';
		characterz[22] = 'w';
		characterz[23] = 'x';
		characterz[24] = 'y';
		characterz[25] = 'z';
	}

	public WhackAMole(){
		whacked = 0;
		missed = 0;
		drawButtons(new Random().nextInt(50));
	}
	
	public void drawButtons(int random){
		frame = new JFrame();
		frame.setSize(400, 900);
		frame.setTitle("Mole Hunter X: Hammer Time");
		panel = new JPanel();
		JButton[] buttonz = new JButton[random];
		for(int i = 0; i < random; i++)
		{
			buttonz[i] = new JButton();
			buttonz[i].addMouseListener(this);
			panel.add(buttonz[i]);
		}
		frame.addMouseListener(this);
		panel.addMouseListener(this);
		buttonz[new Random().nextInt(random)].setText("HELLO!");
		
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(((JButton) e.getSource()).getText() == "HELLO!")
		{
			whacked++;
		}
		else
		{
			missed++;
			String message = "";
			for(int i = 0; i < missed*5; i++)
			{
				message = message + characterz[new Random().nextInt(25)];
			}
			speak(message);
		}
		if(whacked >= 10)
		{
			endGame(startTime, whacked);
		}
		else
		{
			drawButtons(new Random().nextInt(50));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

	void speak(String words) {
		try {
		Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	
	private void endGame(Date timeAtStart, int molesWhacked) {
		Date timeAtEnd = new Date();
		JOptionPane.showMessageDialog(null, "Your whack rate is "
		+ ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked) + " moles per second.");
		}
	
}
