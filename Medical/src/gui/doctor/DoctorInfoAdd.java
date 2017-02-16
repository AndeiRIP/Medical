package gui.doctor;
import static start.Constants.SQL_INSERT_INTO;
import static start.Constants.TABLE_DOCTOR;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import connection.DBConnection;
import exceptions.BlankException;
import exceptions.NameException;
import gui.ClsSettings;
import gui.DocStart;
import gui.dialog.EDt;
import gui.dialog.ErrorDialog;
import gui.dialog.ErrorDialog1;
import gui.dialog.ErrorDialog2;
import gui.dialog.SuccessDialog;

public class DoctorInfoAdd extends JFrame implements ActionListener {
	private static final long serialVersionUID = -6737883779709651407L;

	private JLabel lmain, ldi, lname, ladd, ltel,  ldid, ldspec, lwork, lworkfrom, lworkto;
	private JTextField tfname, tftel, tfdid, tfworkf, tfworkt;
	private TextArea taadd, taspecial;
	private JButton bsub, bclr, bback;
	
	private ClsSettings settings = new ClsSettings();

	public DoctorInfoAdd() {
		super("Doctor Information");
		setSize(1024, 768);
		setVisible(true);
		setLayout(null);

		lmain = new JLabel("Doctor Information");
		lmain.setBounds(440, 35, 107, 15);
		add(lmain);

		ldi = new JLabel("Doctor Information");
		ldi.setBounds(40, 70, 120, 15);
		add(ldi);

		lname = new JLabel("Name :");
		lname.setBounds(104, 97, 70, 25);
		add(lname);

		tfname = new JTextField(30);
		tfname.setBounds(270, 97, 250, 20);
		add(tfname);

		ladd = new JLabel("Address :");
		ladd.setBounds(104, 138, 70, 15);
		add(ladd);

		taadd = new TextArea();
		taadd.setBounds(270, 138, 250, 100);
		add(taadd);

		ltel = new JLabel("Contact :");
		ltel.setBounds(575, 138, 50, 25);
		add(ltel);

		ldid = new JLabel("Doctor ID:");
		ldid.setBounds(570, 97, 70, 25);
		add(ldid);

		tfdid = new JTextField(30);
		tfdid.setBounds(643, 97, 50, 20);
		tfdid.setEditable(false);
		add(tfdid);

		tftel = new JTextField(30);
		tftel.setBounds(640, 138, 200, 20);
		add(tftel);

		settings.Numvalidator(tftel);

		ldspec = new JLabel("Specialization :");
		ldspec.setBounds(104, 310, 100, 25);
		add(ldspec);

		taspecial = new TextArea();
		taspecial.setBounds(270, 310, 250, 100);
		add(taspecial);

		lwork = new JLabel("Working hours :");
		lwork.setBounds(570, 310, 100, 15);
		add(lwork);

		lworkfrom = new JLabel("From :");
		lworkfrom.setBounds(670, 305, 37, 25);
		add(lworkfrom);

		tfworkf = new JTextField(30);
		tfworkf.setBounds(710, 310, 30, 20);
		add(tfworkf);
		settings.Numvalidator(tfworkf);

		lworkto = new JLabel("to :");
		lworkto.setBounds(747, 305, 20, 25);
		add(lworkto);

		tfworkt = new JTextField(30);
		tfworkt.setBounds(775, 310, 30, 20);
		add(tfworkt);
		settings.Numvalidator(tfworkt);

		bsub = new JButton("ADD", new ImageIcon("images/add.gif"));
		bsub.setBounds(362, 643, 100, 30);
		add(bsub);

		bclr = new JButton("CLEAR", new ImageIcon("images/LOGGOFF.PNG"));
		bclr.setBounds(470, 643, 100, 30);
		add(bclr);

		bback = new JButton("BACK", new ImageIcon("images/restore.png"));
		bback.setBounds(580, 643, 100, 30);
		add(bback);

		bclr.addActionListener(new clear());
		bsub.addActionListener(new submit());
		bback.addActionListener(new back());
	}

	class clear implements ActionListener {
		public void actionPerformed(ActionEvent ae) {

			tfname.setText("");
			tftel.setText("");
			tfdid.setText("");
			tfworkf.setText("");
			tfworkt.setText("");
			taadd.setText("");
			taspecial.setText("");

		}
	}

	class back implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			new DocStart();
			setVisible(false);
		}
	}

	class submit implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			try {

				String name = tfname.getText();

				int a;
				a = name.charAt(0);
				if (name.equals("") || a == 32) {
					throw new BlankException();
				} else {
					for (int i = 0; i < name.length(); i++) {
						// boolean check = Character.isLetter(name.charAt(i));
						a = name.charAt(i);
						System.out.print("  " + a);
						if (!((a >= 65 && a <= 90) || (a >= 97 && a <= 122) || (a == 32) || (a == 46))) {
							throw new NameException();
						}

					}
				}

				String addr = taadd.getText();
				if (addr.equals(null)) {
					System.out.println("addr");
					throw new BlankException();
				}

				String contact = tftel.getText();
				String spec = taspecial.getText();
				String workf = tfworkf.getText();
				String workt = tfworkt.getText();

				Statement st = DBConnection.connect().createStatement();

				String sqlStatement = SQL_INSERT_INTO + " " + 
				TABLE_DOCTOR + "(Name, Address, Contact, Specialization, WorkFrom, WorkTo)" +
						" VALUES('" + name + "','" + addr + "'," + contact + ",'" + spec + "'," + workf + "," + workt + ")";
				st.executeUpdate(sqlStatement);

				new SuccessDialog();
				DBConnection.disconnect();
				
			} catch (SQLException sq) {
				String message = "Enter Valid Doctor ID and Contact.";
				JOptionPane.showMessageDialog(new JFrame(), message, "ERROR!", JOptionPane.ERROR_MESSAGE);
				System.out.println(sq);
			} catch (BlankException be) {
				new ErrorDialog2();
			} catch (NumberFormatException nfe) {
				new ErrorDialog();
			} catch (NameException ne) {
				new ErrorDialog1();
			} catch (Exception e) {
				System.out.println(e);
				new EDt();
			}

		}

	}

	public void actionPerformed(ActionEvent ae) {
	}

	public static void main(String[] args) {
		new DoctorInfoAdd();
	}
}
