package gui.dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SuccessDialog {
	
	public SuccessDialog() {
		String message = "Data added successfully!";
		JOptionPane.showMessageDialog(new JFrame(), message, "Done!", JOptionPane.INFORMATION_MESSAGE);
	}
}
