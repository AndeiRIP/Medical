package gui.consultation;

import static start.Constants.*;

import java.awt.Choice;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import connection.DBConnection;
import exceptions.BlankException;

public class NewConsultation extends JFrame {
	private static final long serialVersionUID = -7590070827389604444L;

	private JLabel lpi, labelDrogs, labelDate, labelDiagnostic, labelCNP, lConsNo;
	private TextArea taDrogs, taDiagnostic;
	private JTextField tfDate, tfCNP, tfConsNo;

	private JButton bback, bclr, bsub;

	private JLabel lDateTip;

	private Choice chooseCnp;

	public NewConsultation() {
		super("Create a new Consultation");

		createUI();
		createButtons();
	}

	private void createButtons() {
		bback = new JButton(BACK, new ImageIcon("images/restore.png"));
		bback.setBounds(580, 643, 100, 30);
		bback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ConsultationView();
				setVisible(false);
			}
		});
		add(bback);

		bclr = new JButton("CLEAR", new ImageIcon("images/LOGGOFF.PNG"));
		bclr.setBounds(470, 643, 100, 30);
		bclr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				taDrogs.setText("");
				taDiagnostic.setText("");
				tfDate.setText("");
				tfCNP.setText("");
				tfConsNo.setText("");
			}
		});
		add(bclr);

		bsub = new JButton("ADD", new ImageIcon("images/add.gif"));
		bsub.setBounds(362, 643, 100, 30);
		bsub.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				submitData();
			}

		});
		add(bsub);

	}

	private void createUI() {
		setSize(1024, 768);
		setVisible(true);
		setLayout(null);

		lpi = new JLabel("Add Consultation Infos");
		lpi.setBounds(40, 70, 150, 15);
		add(lpi);

		// drogs fiels
		labelDrogs = new JLabel("Drogs :");
		labelDrogs.setBounds(104, 138, 70, 15);
		add(labelDrogs);

		taDrogs = new TextArea();
		taDrogs.setBounds(270, 138, 250, 100);
		add(taDrogs);

		// diagnostic
		labelDiagnostic = new JLabel("Diagnostic :");
		labelDiagnostic.setBounds(104, 265, 100, 30);
		add(labelDiagnostic);

		taDiagnostic = new TextArea();
		taDiagnostic.setBounds(270, 265, 250, 100);
		add(taDiagnostic);

		// date
		labelDate = new JLabel("Date of Cons.:");
		labelDate.setBounds(104, 97, 120, 15);
		add(labelDate);

		tfDate = new JTextField(15);
		tfDate.setBounds(270, 97, 80, 20);
		add(tfDate);

		lDateTip = new JLabel("(yyyy-mm-dd)");
		lDateTip.setBounds(350, 97, 100, 20);
		add(lDateTip);

		// cnp
		labelCNP = new JLabel("CNP:");
		labelCNP.setBounds(575, 97, 70, 25);
		add(labelCNP);

		chooseCnp = new Choice();
		chooseCnp.setBounds(610, 97, 100, 20);

		for (Integer cnp : getPacientCNP()) {
			chooseCnp.add(cnp.toString());
		}
		add(chooseCnp);

		// cons no
		lConsNo = new JLabel("Cons. No.:");
		lConsNo.setBounds(720, 97, 60, 20);
		add(lConsNo);

		tfConsNo = new JTextField(30);
		tfConsNo.setBounds(788, 97, 60, 20);
		add(tfConsNo);
	}

	private List<Integer> getPacientCNP() {
		List<Integer> lst = new ArrayList<Integer>();
		try {
			String sqlStatement = SQL_SELECT + " CNP " + SQL_FROM + " " + TABLE_PATIENT;

			Statement st = DBConnection.connect().createStatement();
			ResultSet result = st.executeQuery(sqlStatement);
			
			while (result.next()) {
				lst.add(result.getInt("CNP"));
			}
			
			DBConnection.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lst;
	}

	private void submitData() {
		try {
			int cnp = Integer.parseInt(chooseCnp.getSelectedItem());

			String drogs = taDrogs.getText();
			if (drogs.equals(null)) {
				System.out.println("addr");
				throw new BlankException();
			}

			String date = tfDate.getText();
			if (date.equals(null)) {
				System.out.println("dob");
				throw new BlankException();
			} else if (date.length() < 5) {
				date = "01.01.1000";
			}

			String diagnostic = taDiagnostic.getText();
			String consNo = tfConsNo.getText();

			// send data
			String sqlStatement = SQL_INSERT_INTO + " " + TABLE_CONSULTATION
					+ "(CNP_FK, NoCons, Date, Diagnostic, Drogs)" + " VALUES(" + cnp + "," + consNo + ",'"
					+ Date.valueOf(date) + "','" + diagnostic + "','" + drogs + "')";

			Statement st = DBConnection.connect().createStatement();
			st.executeUpdate(sqlStatement);
			DBConnection.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
