package gui.dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EDt {
	
	public EDt() {
		String message = "Enter Valid Date";
		JOptionPane.showMessageDialog(new JFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
