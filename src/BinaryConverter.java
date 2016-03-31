import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BinaryConverter implements MouseListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryConverter converter = new BinaryConverter();
	}
	
	JFrame frame;
	JPanel panel;
	JButton enter;
	JTextField input;
	JTextField output;
	
	public BinaryConverter()
	{
		frame = new JFrame();
		frame.addMouseListener(this);
		panel = new JPanel();
		panel.addMouseListener(this);
		enter = new JButton();
		enter.setText("Convert!");
		enter.addMouseListener(this);
		
		input = new JTextField(8);
		output = new JTextField(8);
		
		frame.add(panel);
		
		panel.add(input);
		panel.add(enter);
		panel.add(output);
		frame.pack();
		frame.setVisible(true);
	}
/*
	We’re going to make an application that converts binary codes (8-bits) into letters.

	You’ll need a JFrame and a JPanel.

	On the panel, put two text fields and a button. A text field is made like this:
	JTextField answer = new JTextField(20);

	It may look like this or you might have a better layout in mind.


	Here is a method that will do the conversion for you.
*/
	int convert(String binary) {
			if(binary.length() != 8){
				JOptionPane.showMessageDialog(null, "Enter 8 bits, silly!!!");
				return 0;
			}
			 if(!Pattern.matches("\2", binary)) {
				 JOptionPane.showMessageDialog(null, "Binary can only contain 1s or 0s, silly!!!");
					return 0;
			 }
			try {
				int asciiValue = Integer.parseInt(binary, 2);
				return asciiValue;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Enter a binary, silly!!!");
				//question.setText("");
				return 0;
			}
		}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(enter))
		{
			output.setText("" + convert(input.getText()));
			if(!output.getText().equals("0"))
			{
				JOptionPane.showMessageDialog(null, input.getText() + " converted to " + output.getText());
			}
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
