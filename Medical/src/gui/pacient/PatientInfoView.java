package gui.pacient;

import static start.Constants.*;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import connection.DBConnection;

public class PatientInfoView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 4931508361348866753L;

	private JLabel lmain, lpi, lname, ladd, ltel, lmi, lbg, ldob, lhis, lcur, labelCNP, lnote, lroom, ldateadd, lgender, lrtype,
			ldtip, ldtip2, ldocname;
	private JTextField tfname, tftel, tfCNP, tfbg, tfroom, tfdateadd, tfmf, tfrtype, tfdocname, tfdob;
	private TextArea taadd, tahis, tacur;
	private JButton bsub, bclr, bback;

	public PatientInfoView() {
		super("View Patient Information");
		setSize(1024, 768);
		setVisible(true);
		setLayout(null);

		// PERSONAL INFORMATION

		lmain = new JLabel("View Patient Information");
		lmain.setBounds(440, 35, 140, 15);
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

		labelCNP = new JLabel("CNP:");
		labelCNP.setBounds(575, 97, 70, 25);
		add(labelCNP);

		tftel = new JTextField(30);
		tftel.setBounds(640, 138, 250, 20);
		add(tftel);

		tfCNP = new JTextField(30);
		tfCNP.setBounds(610, 97, 100, 20);
		add(tfCNP);

		// END

		lmi = new JLabel("Medical Information");
		lmi.setBounds(40, 268, 120, 15);
		add(lmi);

		lbg = new JLabel("Blood Group :");
		lbg.setBounds(104, 306, 79, 15);
		add(lbg);

		tfbg = new JTextField(30);
		tfbg.setBounds(270, 306, 53, 20);
		add(tfbg);

		ldob = new JLabel("Date of Birth :");
		ldob.setBounds(575, 306, 135, 15);
		add(ldob);

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

		lgender = new JLabel("Gender :");
		lgender.setBounds(575, 223, 50, 15);
		add(lgender);

		tfmf = new JTextField(50);
		tfmf.setBounds(698, 223, 80, 20);
		add(tfmf);

		/*
		 * cbmf=new CheckboxGroup(); cbm=new Checkbox("Male",cbmf,true); cbf=new
		 * Checkbox("Female",cbmf,false); cbm.setBounds(698,223,50,15);
		 * add(cbm); cbf.setBounds(760,223,60,15); add(cbf);
		 */

		lrtype = new JLabel("Type Of Room : ");
		lrtype.setBounds(104, 510, 120, 25);
		add(lrtype);

		tfrtype = new JTextField();
		tfrtype.setBounds(270, 510, 80, 20);
		add(tfrtype);

		/*
		 * chrt=new Choice(); chrt.setBounds(270,510,80,15);
		 * chrt.addItem("Deluxe"); chrt.addItem("Private");
		 * chrt.addItem("Semi-Private"); chrt.addItem("General"); add(chrt);
		 */

		bsub = new JButton("SEARCH", new ImageIcon("images/search.png"));
		bsub.setBounds(300, 643, 110, 30);
		add(bsub);

		bclr = new JButton("CLEAR", new ImageIcon("images/LOGGOFF.PNG"));
		bclr.setBounds(470, 643, 100, 30);
		add(bclr);

		bback = new JButton("BACK", new ImageIcon("images/restore.png"));
		bback.setBounds(580, 643, 100, 30);
		add(bback);

		ldtip2 = new JLabel("(yyyy-mm-dd)");
		ldtip2.setBounds(782, 180, 100, 20);
		add(ldtip2);

		tfdocname = new JTextField(100);
		tfdocname.setBounds(720, 510, 250, 20);
		add(tfdocname);

		ldocname = new JLabel("Attending Doctor :");
		ldocname.setBounds(575, 510, 130, 15);
		add(ldocname);

		ldtip = new JLabel("(yyyy-mm-dd)");
		ldtip.setBounds(782, 305, 100, 20);
		add(ldtip);

		ldob = new JLabel("Date of Birth :");
		ldob.setBounds(575, 306, 120, 15);
		add(ldob);

		tfdob = new JTextField(15);
		tfdob.setBounds(696, 305, 80, 20);
		add(tfdob);

		bclr.addActionListener(new clear());
		bsub.addActionListener(new submit());
		bback.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new PatientPage();
				setVisible(false);
			}
		});
	}

	public void actionPerformed(ActionEvent ae) {
	}

	class clear implements ActionListener {
		public void actionPerformed(ActionEvent ae) {

			tfname.setText("");
			tftel.setText("");
			tfdob.setText("");
			taadd.setText("");
			tahis.setText("");
			tacur.setText("");
			tfCNP.setText("");
			tfroom.setText("");
			tfdateadd.setText("");
			tfrtype.setText("");
			tfmf.setText("");
			tfbg.setText("");

		}
	}

	class submit extends Frame implements ActionListener {
		private static final long serialVersionUID = 6179670942954044474L;
		
		private int num;
		private String name, addr, contact, blgr, hist, dob, current, room, dateadd, rtype, mf, docname;

		public void actionPerformed(ActionEvent ae) {

			try {

				num = Integer.parseInt(tfCNP.getText());

				Statement st = DBConnection.connect().createStatement();
				ResultSet rs = st.executeQuery(
						SQL_SELECT + " * " + SQL_FROM + " " + TABLE_PATIENT + " " + SQL_WHERE + " CNP=" + num);
				System.out.println(num);

				if (rs.next()) {

					name = rs.getString("Name");
					addr = rs.getString("Address");
					contact = rs.getString("Contact");
					hist = rs.getString("History");
					dob = rs.getString("DoB");
					current = rs.getString("Diagnostic");
					blgr = rs.getString("BloodGroup");
					room = rs.getString("RoomNo");
					dateadd = rs.getString("DateAdd");
					rtype = rs.getString("rType");
					mf = rs.getString("Gender");
					docname = rs.getString("DocName");

					tfname.setText(name);
					tftel.setText(contact);
					tfdob.setText(dob);
					taadd.setText(addr);
					tahis.setText(hist);
					tacur.setText(current);
					tfbg.setText(blgr);
					tfroom.setText(room);
					tfdateadd.setText(dateadd);
					tfrtype.setText(rtype);
					tfmf.setText(mf);
					tfdocname.setText(docname);
				}

			} catch (SQLException sq) {
				System.out.println(sq);
			}
			
			// Close the connection
			DBConnection.disconnect();
		}
	}

}
