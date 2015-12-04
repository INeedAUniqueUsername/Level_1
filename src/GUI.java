import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI implements ActionListener {

	private static JFrame window;
	private static JPanel windowPanel;
	private static JOptionPane messages;
	private static GridLayout layout;
	
	JButton button1;
	JButton button2;
	
	public static void main(String[] args) {
		
		GUI screen = new GUI();
		screen.start();
		
	}
	GUI()
	{
		System.out.println("ULTIMATE DOOM HAS BEEN UNLEASHED! TIME IS TICKING! TIME HAS BEEN UNLEASHED AND YOUR ULTIMATE DOOM IS TICKING");
	}
	public void start()
	{
		window = new JFrame();
		windowPanel = new JPanel();
		messages = new JOptionPane();
		layout = new GridLayout(1, 2);
		windowPanel.setLayout(layout);

		button1 = new JButton();
		button1.setText("Give in to absolute despair and submit to the inevitability of YOUR DOOM!");
		//button1.addActionListener(this);
		button1.addActionListener(this);
		
		button2 = new JButton();
		button2.setText("Do NOT click this button because this is NOT YOUR DOOM!");
		//button2.addActionListener(this);
		
		button2.addActionListener(this);
		windowPanel.add(button1, 0);
		windowPanel.add(button2, 1);
		
		window.add(windowPanel);
		window.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button1)
		{
			System.out.println("THE TIME IS NOW! YOUR DOOM IS NOW! THE TIME IS YOUR DOOM!");
			messages.showMessageDialog(window, "THE TIME IS NOW! YOUR DOOM IS NOW! THEREFORE, THE TIME IS YOUR DOOM! YOUR DOOM IS RUNNING OUT! QUICK! DO NOTHING WHILE YOU BECOME ENGULFED IN DOOM");
		}
		else if(e.getSource() == button2)
		{
			System.out.println("YOU CANNOT ESCAPE THE DOOM NO MATTER HOW HARD YOU TRY OR HOW YOU DO NOT TRY AT ALL");
			messages.showMessageDialog(window, "YOU CANNOT ESCAPE THE DOOM NO MATTER HOW HARD YOU TRY OR HOW YOU DO NOT TRY AT ALL");
		}
	}
}
