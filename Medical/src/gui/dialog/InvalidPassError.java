package gui.dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InvalidPassError {
	
	InvalidPassError() {
		String message = "Invalid Username/Password";
		JOptionPane.showMessageDialog(new JFrame(), message, "ERROR!", JOptionPane.ERROR_MESSAGE);
	}
}
