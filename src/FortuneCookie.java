import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FortuneCookie implements ActionListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FortuneCookie fortune = new FortuneCookie();
		fortune.showButton();
	}
	void showButton()
	{
		JFrame frame = new JFrame();
		frame.setVisible(true);
		JButton fortuneButton = new JButton();
		frame.add(fortuneButton);
		fortuneButton.addActionListener(this);
		fortuneButton.setText("Give in to fate!");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String[] possibleFortunes = new String[8];
		possibleFortunes[0] = "In a few seconds you will disappear for no apparent reason because I feel like it!";
		possibleFortunes[1] = "In a few seconds you shall finish reading this pointless message and you WILL feel like I just wasted your time!";
		possibleFortunes[2] = "Soon you will feel confused because I say THIS MESSAGE IS FALSE AND EVERYTHING YOU JUST HEARD IS A LIE!";
		possibleFortunes[3] = "Right now you must be reading this message! In the next second you shall be done reading this message!";
		possibleFortunes[4] = "Try again later (OR DON'T TRY AT ALL!)";
		possibleFortunes[5] = "This message is contaminated with large amounts of 'WAIT A MINUTE! WHAT IS THAT SUPPOSED TO MEAN?!'";
		possibleFortunes[6] = "Maybe you should ask Google.";
		possibleFortunes[7] = "...";
		String[] fortunes = new String[5];
		fortunes[0] = possibleFortunes[new Random().nextInt(possibleFortunes.length)];
		fortunes[1] = possibleFortunes[new Random().nextInt(possibleFortunes.length)];
		fortunes[2] = possibleFortunes[new Random().nextInt(possibleFortunes.length)];
		fortunes[3] = possibleFortunes[new Random().nextInt(possibleFortunes.length)];
		fortunes[4] = possibleFortunes[new Random().nextInt(possibleFortunes.length)];
		new JOptionPane().showMessageDialog(null, possibleFortunes[new Random().nextInt(possibleFortunes.length)]);
	}
}
