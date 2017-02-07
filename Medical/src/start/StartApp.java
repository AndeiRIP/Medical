package start;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.MainPage;
import static start.Constants.*;

public class StartApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 4504258170212439955L;

	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

	static JFrame frame;

	private static JPanel titlePanel;
	private static JPanel fieldsPanel;
	private static JPanel buttonsPanel;

	private JButton loginBtn;
	private JButton exitBtn;

	private JLabel titleText;
	private JLabel userText;
	private JLabel passwordText;

	private static JTextField userTextField;
	private static JPasswordField passwordTextField;

	private String loginName;
	private String loginPass;
	private String dialogMessage;

	int dialogtype = JOptionPane.PLAIN_MESSAGE;

	public void start() {

		createLoginUI();

		// main frame
		frame = new JFrame(Constants.APP_TITLE);
		frame.setSize(300, 200);
		frame.setResizable(false);

		Container pane = frame.getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		// pane.setLayout(new GridLayout(3,1));
		pane.add(titlePanel);
		pane.add(fieldsPanel);
		pane.add(buttonsPanel);

		frame.setLocation((screen.width - 500) / 2, ((screen.height - 350) / 2));
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();

		if (source.equals(loginBtn)) {
			login();

		} else if (source.equals(exitBtn)) {
			disposeLoginPage();
		}
	}

	private void login() {
		loginName = userTextField.getText().trim();
		// TODO fix deprecation
		loginPass = passwordTextField.getText().trim();

		// TODO implement login
		if (loginName.equals("s") && loginPass.equals("s")) {
			dialogtype = JOptionPane.INFORMATION_MESSAGE;
			dialogMessage = Constants.WELLCOME + loginName + "!";
			JOptionPane.showMessageDialog((Component) null, dialogMessage, Constants.AUTH_SUCCESSFULL, dialogtype);

			// start the application
			new MainPage();
			disposeLoginPage();

		} else {
			JOptionPane.showMessageDialog(null, Constants.AUTH_INVALID, Constants.WARNING,
					JOptionPane.INFORMATION_MESSAGE);
			userTextField.setText("");
			passwordTextField.setText("");
		}
	}

	private void disposeLoginPage() {
		setVisible(false);
		frame.dispose();
	}

	private void createLoginUI() {

		// title
		titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.setOpaque(true);

		titleText = new JLabel(Constants.APP_TITLE);
		titlePanel.add(titleText);

		// login fields
		fieldsPanel = new JPanel();
		fieldsPanel.setLayout(new GridLayout(2, 2));
		fieldsPanel.setOpaque(true);

		userText = new JLabel(USERNAME);
		userTextField = new JTextField(20);

		passwordText = new JLabel(PASSWORD);
		passwordTextField = new JPasswordField(20);

		fieldsPanel.add(userText);
		fieldsPanel.add(userTextField);
		fieldsPanel.add(passwordText);
		fieldsPanel.add(passwordTextField);

		// buttons
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());
		buttonsPanel.setOpaque(true);

		loginBtn = new JButton(LOGIN, new ImageIcon("images/key.gif"));
		loginBtn.addActionListener(this);

		exitBtn = new JButton(EXIT, new ImageIcon("images/Keys.gif"));
		exitBtn.addActionListener(this);

		buttonsPanel.add(loginBtn);
		buttonsPanel.add(exitBtn);
	}

	public static void main(String[] args) {
		new StartApp().start();
	}
}
