import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class StartApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 4504258170212439955L;

	static JFrame frame;
	private static JPanel panel1;
	private static JPanel panel2;
	private static JPanel panel3;
	private JButton loginBtn;
	private JButton exitBtn;
	int dialogtype = JOptionPane.PLAIN_MESSAGE;
	String dialogmessage;
	String dialogs;
	private JLabel nameLbl;
	private JLabel userLbl;
	private JLabel passwordLbl;
	private static JTextField userTxt;
	private static JPasswordField passwordTxt;
	public String loginname;
	public String loginpass;

	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

	public void start() {

		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		nameLbl = new JLabel("Hospital Managment ");

		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 2));
		userLbl = new JLabel("Username :");
		userTxt = new JTextField(20);

		passwordLbl = new JLabel("Password :");
		// passwordTxt = new JTextField(20);
		passwordTxt = new JPasswordField(20);
		// passwordTxt.setEchoChar('?');

		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());

		loginBtn = new JButton("Login", new ImageIcon("images/key.gif"));

		loginBtn.addActionListener(this);
		exitBtn = new JButton("Exit", new ImageIcon("images/Keys.gif"));

		exitBtn.addActionListener(this);
		panel1.add(nameLbl);
		panel1.setOpaque(true);
		panel2.add(userLbl);
		panel2.add(userTxt);
		panel2.add(passwordLbl);
		panel2.add(passwordTxt);
		panel2.setOpaque(true);
		panel3.add(loginBtn);
		panel3.add(exitBtn);
		panel3.setOpaque(true);
		frame = new JFrame("Hospital Managment");
		frame.setSize(300, 200);

		Container pane = frame.getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		// pane.setLayout(new GridLayout(3,1));
		pane.add(panel1);
		pane.add(panel2);
		pane.add(panel3);
		frame.setLocation((screen.width - 500) / 2, ((screen.height - 350) / 2));
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source.equals(loginBtn)) {
			String loginname, loginpass;
			loginname = userTxt.getText().trim();
			// TODO fix deprecation
			loginpass = passwordTxt.getText().trim();
				
			if (loginname.equals("s") && loginpass.equals("s")) {
				dialogmessage = "Welcome - " + loginname;
				dialogtype = JOptionPane.INFORMATION_MESSAGE;
				JOptionPane.showMessageDialog((Component) null, dialogmessage, dialogs, dialogtype);
				userTxt.setText("");
				
				// start the application
				new MainPage();
				setVisible(false);
				frame.dispose();

			} else {
				JOptionPane.showMessageDialog(null, "Invaild User name and password", "WARNING!!!",
						JOptionPane.INFORMATION_MESSAGE);
				userTxt.setText("");
				passwordTxt.setText("");
			}

		} else if (source.equals(exitBtn)) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new StartApp().start();
	}
}
