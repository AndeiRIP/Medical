package gui.pacient;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import connection.DBConnection;
import exceptions.BlankException;
import exceptions.NameException;
import gui.ClsSettings;
import gui.dialog.EDt;
import gui.dialog.ErrorDialog;
import gui.dialog.ErrorDialog1;
import gui.dialog.ErrorDialog2;
import gui.dialog.SuccessDialog;
import static start.Constants.*;

public class PatientInfo extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1525675329129602584L;

	private JLabel lmain, lpi, lname, ladd, lPhone, lmi, lbg, ldob, lhis, lcur, labelCNP, lroom, ldateadd, lgender, lrtype,
			ldtip, ldtip2, ldocname;
	private JTextField tfname, tfPhone, tfdob, tfCNP, tfroom, tfdateadd, tfdocname;
	private TextArea taadd, tahis, tacur;
	private Choice chbg, chrt;
	private CheckboxGroup cbmf;
	private Checkbox cbm, cbf;
	private JButton bsub, bclr, bback;

	private ClsSettings settings = new ClsSettings();

	public PatientInfo() {
		super("Add Patient Information");
		setSize(1024, 768);
		setVisible(true);
		setLayout(null);

		// PERSONAL INFORMATION

		lmain = new JLabel("Add Patient Information");
		lmain.setBounds(440, 35, 160, 15);
		add(lmain);

		lpi = new JLabel("Add Personal Information");
		lpi.setBounds(40, 70, 150, 15);
		add(lpi);

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

		lPhone = new JLabel("Contact :");
		lPhone.setBounds(575, 138, 50, 25);
		add(lPhone);

		labelCNP = new JLabel("CNP:");
		labelCNP.setBounds(575, 97, 70, 25);
		add(labelCNP);

		tfPhone = new JTextField(30);
		tfPhone.setBounds(640, 138, 250, 20);
		add(tfPhone);
		settings.Numvalidator(tfPhone);

		tfCNP = new JTextField(30);
		tfCNP.setBounds(610, 97, 100, 20);
		add(tfCNP);

		// END

		lroom = new JLabel("Room No.:");
		lroom.setBounds(720, 97, 60, 20);
		add(lroom);

		tfroom = new JTextField(30);
		tfroom.setBounds(788, 97, 60, 20);
		add(tfroom);

		lmi = new JLabel("Medical Information");
		lmi.setBounds(40, 268, 120, 15);
		add(lmi);

		lbg = new JLabel("Blood Group :");
		lbg.setBounds(104, 306, 79, 15);
		add(lbg);

		chbg = new Choice();
		chbg.setBounds(270, 306, 53, 15);
		chbg.addItem("A -ve");
		chbg.addItem("A +ve");
		chbg.addItem("B -ve");
		chbg.addItem("B +ve");
		chbg.addItem("AB -ve");
		chbg.addItem("AB +ve");
		chbg.addItem("O +ve");
		chbg.addItem("O -ve");
		add(chbg);

		ldob = new JLabel("Date of Birth :");
		ldob.setBounds(575, 306, 120, 15);
		add(ldob);

		tfdob = new JTextField(15);
		tfdob.setBounds(696, 305, 80, 20);
		add(tfdob);
		// settings.Numvalidator(tfdob);

		ldtip = new JLabel("(yyyy-mm-dd)");
		ldtip.setBounds(782, 305, 100, 20);
		add(ldtip);

		lhis = new JLabel("History :");
		lhis.setBounds(104, 365, 50, 15);
		add(lhis);

		tahis = new TextArea();
		tahis.setBounds(270, 365, 250, 100);
		add(tahis);

		lcur = new JLabel("Current Problem :");
		lcur.setBounds(575, 365, 100, 15);
		add(lcur);

		ldocname = new JLabel("Attending Doctor :");
		ldocname.setBounds(575, 510, 130, 15);
		add(ldocname);

		tacur = new TextArea();
		tacur.setBounds(720, 365, 250, 100);
		add(tacur);

		ldateadd = new JLabel("Date Of Admission :");
		ldateadd.setBounds(575, 180, 120, 25);
		add(ldateadd);

		tfdateadd = new JTextField(40);
		tfdateadd.setBounds(696, 180, 80, 20);
		add(tfdateadd);
		// settings.Numvalidator(tfdateadd);

		tfdocname = new JTextField(100);
		tfdocname.setBounds(720, 510, 250, 20);
		add(tfdocname);

		ldtip2 = new JLabel("(yyyy-mm-dd)");
		ldtip2.setBounds(782, 180, 100, 20);
		add(ldtip2);

		bsub = new JButton("ADD", new ImageIcon("images/add.gif"));
		bsub.setBounds(362, 643, 100, 30);
		add(bsub);

		bclr = new JButton("CLEAR", new ImageIcon("images/LOGGOFF.PNG"));
		bclr.setBounds(470, 643, 100, 30);
		add(bclr);

		bback = new JButton("BACK", new ImageIcon("images/restore.png"));
		bback.setBounds(580, 643, 100, 30);
		add(bback);

		lgender = new JLabel("Gender :");
		lgender.setBounds(596, 223, 50, 15);
		add(lgender);

		cbmf = new CheckboxGroup();
		cbm = new Checkbox("Male", cbmf, true);
		cbf = new Checkbox("Female", cbmf, false);
		cbm.setBounds(698, 223, 50, 15);
		add(cbm);
		cbf.setBounds(760, 223, 60, 15);
		add(cbf);

		lrtype = new JLabel("Type Of Room : ");
		lrtype.setBounds(104, 510, 120, 25);
		add(lrtype);

		chrt = new Choice();
		chrt.setBounds(270, 510, 80, 15);
		chrt.addItem("Deluxe");
		chrt.addItem("Private");
		chrt.addItem("Semi-Private");
		chrt.addItem("General");
		add(chrt);

		bclr.addActionListener(new clear());
		bsub.addActionListener(new SubmitPacientInfo());
		bback.addActionListener(new back());

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.format(cal.getTime()));

	}

	// End of constructor

	public void actionPerformed(ActionEvent ae) {
	}

	class clear implements ActionListener {
		public void actionPerformed(ActionEvent ae) {

			tfname.setText("");
			tfPhone.setText("");
			tfdob.setText("");
			taadd.setText("");
			tahis.setText("");
			tacur.setText("");
			tfCNP.setText("");
			tfroom.setText("");
			tfdateadd.setText("");
		}
	}

	class back implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			new PatientPage();
			setVisible(false);
		}
	}

	class SubmitPacientInfo implements ActionListener, ItemListener {
		public void itemStateChanged(ItemEvent ie) {
		}

		public void actionPerformed(ActionEvent ae) {
			try {
				int cnp = Integer.parseInt(tfCNP.getText());
				String name = tfname.getText();
				int a;
				a = name.charAt(0);
				if (name.equals("") || a == 32) {
					System.out.println("name==" + name);
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

				String address = taadd.getText();
				if (address.equals(null)) {
					System.out.println("addr");
					throw new BlankException();
				}

				long contact = Long.parseLong(tfPhone.getText());
				String bloodGroup = chbg.getSelectedItem();
				String history = tahis.getText();

				String dateOfBirth = tfdob.getText();
				if (dateOfBirth.equals(null)) {
					System.out.println("dob");
					throw new BlankException();
				} else if (dateOfBirth.length() < 5) {
					dateOfBirth = "01.01.1000";
				}

				String diagnostic = tacur.getText();
				if (diagnostic.equals(null)) {
					System.out.println("current");
					throw new BlankException();
				}

				String roomNo = tfroom.getText();

				String dateAdded = tfdateadd.getText();
				if (dateAdded.equals(null)) {
					System.out.println("dateadd");
					throw new BlankException();
				}

				String doctorName = tfdocname.getText();
				if (doctorName.equals(null)) {
					System.out.println("docname");
					throw new BlankException();
				}

				System.out.println(dateAdded);

				String roomType = chrt.getSelectedItem();
				String gender = "";

				if (cbm.getState() == true) {
					gender = "male";
				}
				if (cbf.getState() == true) {
					gender = "female";
				}

				Statement st = DBConnection.connect().createStatement();

				String sqlStatement = SQL_INSERT_INTO + " " + TABLE_PATIENT + " VALUES(" + cnp + ",'" + name + "','"
						+ address + "'," + contact + ",'" + bloodGroup + "','" + history + "','" + transofrmDate(dateOfBirth) + "','"
						+ diagnostic + "'," + roomNo + ",'" + transofrmDate(dateAdded) + "','" + roomType
						+ "','" + gender + "','" + doctorName + "')";
				st.executeUpdate(sqlStatement);

				new SuccessDialog();
				DBConnection.disconnect();

			} catch (BlankException be) {
				new ErrorDialog2();
			} catch (NumberFormatException nfe) {
				new ErrorDialog();
			} catch (SQLException sq) {
				System.out.println(sq);
			} catch (NameException ne) {
				new ErrorDialog1();
			} catch (Exception e) {
				System.out.println(e);
				new EDt();
			}

		}
	}

	private Date transofrmDate(String date) {
		Date myDate = Date.valueOf(date);
		return myDate;

	}

}