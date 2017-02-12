package gui.dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorDialog {
	// TODO get rid of all the other ErrorDialogs
	public ErrorDialog() {
		String message = "Patient Number and Contact Number Must Contain Digits.";
		JOptionPane.showMessageDialog(new JFrame(), message, "ERROR!", JOptionPane.ERROR_MESSAGE);
	}
}
