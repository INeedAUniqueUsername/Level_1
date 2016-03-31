import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import java.net.URL;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CutenessTV implements MouseListener {
	//Make a user interface with 3 buttons that will play different videos depending on which button is clicked. Use the methods below to play the cutest videos ever.

	public static void main(String[] args)
	{
		CutenessTV tv = new CutenessTV();
	}
	
	JFrame frame;
	JPanel panel;
	JButton ducks;
	JButton frog;
	JButton unicorn;
	
	
	public CutenessTV()
	{
		frame = new JFrame();
		panel = new JPanel();
		ducks = new JButton();
		frog = new JButton();
		unicorn = new JButton();
		ducks.setText("Ducks!");
		frog.setText("Frog!");
		unicorn.setText("Unicorn!");
		
		ducks.addMouseListener(this);
		frog.addMouseListener(this);
		unicorn.addMouseListener(this);
		panel.addMouseListener(this);
		frame.addMouseListener(this);
		
		panel.add(ducks);
		panel.add(frog);
		panel.add(unicorn);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		ducks.setVisible(true);
		frog.setVisible(true);
		unicorn.setVisible(true);
	}
	
	void showDucks() {
			playVideo("Drirjl5K9Yk");
		}

		void showFrog() {
			playVideo("aSjCb-FfxhI");
		}
		
		void showFluffyUnicorns() {
			playVideo("qRC4Vk6kisY");
		}

		void playVideo(String videoID) {
			try {
		URI uri = new URI("https://www.youtube.com/v/" + videoID + "?autoplay=1");
				java.awt.Desktop.getDesktop().browse(uri);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(ducks))
			{
				showDucks();
			}
			if(e.getSource().equals(frog))
			{
				showFrog();
			}
			if(e.getSource().equals(unicorn))
			{
				showFluffyUnicorns();
			}
			System.exit(new Random().nextInt(100));
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
}
