import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CutenessTV implements MouseListener {
	//Make a user interface with 3 buttons that will play different videos depending on which button is clicked. Use the methods below to play the cutest videos ever.

	public static void main(String[] args)
	{
		CutenessTV tv = new CutenessTV();
	}
	
	JButton ducks;
	JButton frog;
	JButton unicorn;
	
	
	public CutenessTV()
	{
		JFrame frame = new JFrame();
		ducks = new JButton();
		ducks.setText("Ducks!");
		
		frog = new JButton();
		frog.setText("Frog!");
		
		unicorn = new JButton();
		unicorn.setText("Unicorn!");
		
		ducks.addMouseListener(this);
		frog.addMouseListener(this);
		unicorn.addMouseListener(this);
		
		frame.add(ducks);
		frame.add(frog);
		frame.add(unicorn);
		
		frame.pack();
		frame.setVisible(true);
		frame.addMouseListener(this);
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
			if(e.getSource().equals(unicorn))
			{
				showFluffyUnicorns();
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
}
