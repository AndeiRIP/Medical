package gui.dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SuccessDialog1 {
	
	public SuccessDialog1() {
		String message = "Data Modified successfully!";
		JOptionPane.showMessageDialog(new JFrame(), message, "Done!", JOptionPane.INFORMATION_MESSAGE);
	}

}