import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import exceptions.BlankException;
import exceptions.NameException;

class PatientInfomodify extends JFrame implements ActionListener {
	private static final long serialVersionUID = 2626190289676587612L;
	
	static Connection cn = null;
	Statement st = null;
	ResultSet rs = null;

	JLabel lmain, lpi, lname, ladd, ltel, lmi, lbg, ldob, lhis, lcur, lpno, lnote, lroom, ldateadd, lgender, lrtype,
			ldtip, ldtip2, ldocname;
	JTextField tfname, tftel, tfdob, tfpno, tfroom, tfdateadd, tfdocname;
	TextArea taadd, tahis, tacur;
	JButton bsub, bclr, bback, bmod;
	Choice chbg, chrt;
	CheckboxGroup cbmf;
	Checkbox cbm, cbf;

	clsSettings settings = new clsSettings();

	PatientInfomodify() {
		super("Modify Patient Information");
		setSize(1024, 768);
		setVisible(true);
		setLayout(null);

		// PERSONAL INFORMATION

		lmain = new JLabel("Modify Patient Information");
		lmain.setBounds(440, 35, 200, 15);
		add(lmain);

		lnote = new JLabel("Insert Patient Number");
		lnote.setBounds(641, 75, 127, 15);
		add(lnote);

		lpi = new JLabel("Personal Information");
		lpi.setBounds(40, 70, 120, 15);
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

		ltel = new JLabel("Contact :");
		ltel.setBounds(575, 138, 50, 25);
		add(ltel);

		lpno = new JLabel("Patient No.:");
		lpno.setBounds(570, 97, 70, 25);
		add(lpno);

		tftel = new JTextField(30);
		tftel.setBounds(640, 138, 250, 20);
		add(tftel);
		settings.Numvalidator(tftel);

		tfpno = new JTextField(30);
		tfpno.setBounds(643, 97, 50, 20);
		add(tfpno);

		// END

		lmi = new JLabel("Medical Information");
		lmi.setBounds(40, 268, 120, 15);
		add(lmi);

		lbg = new JLabel("Blood Group :");
		lbg.setBounds(104, 306, 79, 15);
		add(lbg);

		/*
		 * tfbg=new JTextField(30); tfbg.setBounds(270,306,53,20); add(tfbg);
		 */

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
		ldob.setBounds(575, 306, 135, 15);
		add(ldob);

		tfdob = new JTextField(15);
		tfdob.setBounds(720, 305, 80, 20);
		add(tfdob);
		// settings.Numvalidator(tfdob);

		lhis = new JLabel("History :");
		lhis.setBounds(104, 365, 50, 15);
		add(lhis);

		tahis = new TextArea();
		tahis.setBounds(270, 365, 250, 100);
		add(tahis);

		lcur = new JLabel("Current Problem :");
		lcur.setBounds(575, 365, 100, 15);
		add(lcur);

		tacur = new TextArea();
		tacur.setBounds(720, 365, 250, 100);
		add(tacur);

		lroom = new JLabel("Room No.:");
		lroom.setBounds(720, 97, 60, 20);
		add(lroom);

		tfroom = new JTextField(30);
		tfroom.setBounds(788, 97, 60, 20);
		add(tfroom);

		ldateadd = new JLabel("Date Of Admission :");
		ldateadd.setBounds(575, 180, 120, 25);
		add(ldateadd);

		tfdateadd = new JTextField(40);
		tfdateadd.setBounds(696, 180, 80, 20);
		add(tfdateadd);
		// settings.Numvalidator(tfdateadd);

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

		ldtip = new JLabel("(dd-mm-yyyy)");
		ldtip.setBounds(810, 305, 100, 20);
		add(ldtip);

		ldocname = new JLabel("Attending Doctor :");
		ldocname.setBounds(575, 510, 130, 15);
		add(ldocname);

		tfdocname = new JTextField(100);
		tfdocname.setBounds(720, 510, 250, 20);
		add(tfdocname);

		ldtip2 = new JLabel("(dd-mm-yyyy)");
		ldtip2.setBounds(782, 180, 100, 20);
		add(ldtip2);

		bsub = new JButton("SEARCH", new ImageIcon("images/search.png"));
		bsub.setBounds(152, 643, 120, 30);
		add(bsub);

		bclr = new JButton("CLEAR", new ImageIcon("images/LOGGOFF.PNG"));
		bclr.setBounds(340, 643, 100, 30);
		add(bclr);

		bmod = new JButton("MODIFY", new ImageIcon("images/modify.png"));
		bmod.setBounds(480, 643, 100, 30);
		add(bmod);

		bback = new JButton("BACK", new ImageIcon("images/restore.png"));
		bback.setBounds(680, 643, 90, 30);
		add(bback);

		try {

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn = DriverManager.getConnection("Jdbc:Odbc:pat");
		}

		catch (Exception e) {
			System.out.println(e);
		}

		bclr.addActionListener(new clear());
		bsub.addActionListener(new submit());
		bmod.addActionListener(new modify());
		bback.addActionListener(new back());
	}

	// End of constructor

	public void actionPerformed(ActionEvent ae) {
	}

	public static void main(String[] args) {
		new PatientInfomodify();

	}

	class clear implements ActionListener {
		public void actionPerformed(ActionEvent ae) {

			tfname.setText("");
			tftel.setText("");
			tfdob.setText("");
			taadd.setText("");
			tahis.setText("");
			tacur.setText("");
			tfpno.setText("");
			tfroom.setText("");
			tfdateadd.setText("");
			tfdocname.setText("");
		}
	}

	class back implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			new PatientPage();
			setVisible(false);
		}
	}

	class modify implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			try {

				Integer num1 = Integer.parseInt(tfpno.getText());
				if (num1.equals(null)) {
					throw new BlankException();
				}

				String name1 = tfname.getText();
				int a = name1.charAt(0);
				if (name1.equals("") || a == 32) {
					throw new BlankException();
				}
				for (int i = 0; i < name1.length(); i++) {
					boolean check = Character.isLetter(name1.charAt(i));
					a = name1.charAt(i);
					System.out.print(a);
					if (!((a >= 65 && a <= 90) || (a >= 97 && a <= 122) || (a == 32))) {
						throw new NameException();
					}

				}

				String addr1 = taadd.getText();
				if (addr1.equals(null)) {
					throw new BlankException();
				}

				String contact1 = tftel.getText();

				String blgr1 = chbg.getSelectedItem();

				String hist1 = tahis.getText();

				String dob1 = tfdob.getText();
				if (dob1.equals(null)) {
					throw new BlankException();
				}

				String current1 = tacur.getText();
				if (current1.equals(null)) {
					throw new BlankException();
				}

				String roomno1 = tfroom.getText();

				String dateadd1 = tfdateadd.getText();
				if (dateadd1.equals(null)) {
					throw new BlankException();
				}

				String rtype1 = chrt.getSelectedItem();

				String gender1 = "";

				String docname = tfdocname.getText();

				if (cbm.getState() == true) {
					gender1 = "male";
				}
				if (cbf.getState() == true) {
					gender1 = "female";
				}

				// Statement st1=cn.createStatement();

				String str = "UPDATE PAT SET name=?,address=?,contact=?,history=?,bloodgroup=?,dob=?,current=?,roomno=?,dateadd=?,rtype=?,gender=?,docname=? WHERE patientno=?";

				Statement st1 = cn.createStatement();

				PreparedStatement psmt = cn.prepareStatement(str);
				psmt.setString(1, name1);
				psmt.setString(2, addr1);
				psmt.setString(3, contact1);
				psmt.setString(4, hist1);
				psmt.setString(5, blgr1);
				psmt.setString(6, dob1);
				psmt.setString(7, current1);
				psmt.setString(8, roomno1);
				psmt.setString(9, dateadd1);
				psmt.setString(10, rtype1);
				psmt.setString(11, gender1);
				psmt.setString(12, docname);
				psmt.setInt(13, num1);

				psmt.executeUpdate();
				new SuccessDialog1();

				// st.executeUpdate("UPDATE PAT SET
				// patientno="+num1+",name='"+name1+"',address='"+addr1+"',contact='"+contact1+"',history='"+hist1+"',dd='"+dd1+"',mm='"+mm1+"',yy='"+yy1+"',current='"+current1+"'
				// WHERE patientno='"+num1+"';");
			} catch (BlankException be) {
				new ErrorDialog2();
			} catch (SQLException sq) {
				System.out.println(sq);
			} catch (NameException ne) {
				new ErrorDialog1();
			}

		}
	}

	class submit implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			try {

				Integer num = Integer.parseInt(tfpno.getText());
				String name;
				String addr;
				String contact;
				String blgr;
				String hist;
				String dob;
				String current;
				String roomno;
				String dateadd;
				String rtype;
				String gender;
				String docname;

				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM PAT WHERE patientno=" + num);

				if (rs.next()) {
					num = rs.getInt("patientno");
					name = rs.getString("name");
					addr = rs.getString("address");
					contact = rs.getString("contact");
					hist = rs.getString("history");
					dob = rs.getString("dob");
					current = rs.getString("current");
					blgr = rs.getString("bloodgroup");
					roomno = rs.getString("roomno");
					dateadd = rs.getString("dateadd");
					rtype = rs.getString("rtype");
					gender = rs.getString("gender");
					docname = rs.getString("docname");

					tfname.setText(name);
					tftel.setText(contact);
					tfdob.setText(dob);
					taadd.setText(addr);
					tahis.setText(hist);
					tacur.setText(current);
					chbg.select(blgr);
					tfroom.setText(roomno);
					tfdateadd.setText(dateadd);
					tfdocname.setText(docname);
					chrt.select(rtype);
					if (gender.equals("male")) {
						System.out.println(gender);
						cbm.setState(true);
					}
					if (gender.equals("female")) {
						System.out.println(gender);
						cbf.setState(true);
					}

				}

			} catch (SQLException sq) {
				System.out.println(sq);
			}

		}
	}

}
