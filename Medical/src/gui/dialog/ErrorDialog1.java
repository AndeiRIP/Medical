package gui.dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorDialog1 {
	
	public ErrorDialog1() {
		String message = "Invalid Name";
		JOptionPane.showMessageDialog(new JFrame(), message, "ERROR!", JOptionPane.ERROR_MESSAGE);
	}
}
