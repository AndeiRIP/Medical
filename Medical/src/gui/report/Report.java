package gui.report;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.MainPage;
import gui.doctor.DoctorTableFromDatabase;
import gui.pacient.PatientTableFromDatabase;

public class Report extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1120201205784321480L;

	private JButton bpat, bdoc, bback;
	private JLabel lpat, ldoc;

	public Report() {
		super("Reports");
		setSize(1024, 768);
		setVisible(true);
		setLayout(null);

		lpat = new JLabel("For Patients Reports Click Here :");
		lpat.setBounds(100, 200, 400, 30);
		add(lpat);

		ldoc = new JLabel("For Patients Reports Click Here :");
		ldoc.setBounds(100, 350, 400, 30);
		add(ldoc);

		bpat = new JButton("Display Patient's Report", new ImageIcon("images/emp.png"));
		bpat.setBounds(400, 200, 250, 30);
		add(bpat);

		bdoc = new JButton("Display Doctor's Report", new ImageIcon("images/users.png"));
		bdoc.setBounds(400, 350, 250, 30);
		add(bdoc);

		bback = new JButton("BACK", new ImageIcon("images/restore.png"));
		bback.setBounds(480, 600, 100, 30);
		add(bback);

		bpat.addActionListener(new patreport());
		bdoc.addActionListener(new docreport());
		bback.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == bback) {
			new MainPage();
			setVisible(false);
		}

	}

	class patreport implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			PatientTableFromDatabase frame = new PatientTableFromDatabase();
			frame.setDefaultCloseOperation(1);
			frame.pack();
			frame.setVisible(true);
		}

	}

	class docreport implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			new DoctorTableFromDatabase();
			DoctorTableFromDatabase frame = new DoctorTableFromDatabase();
			frame.setDefaultCloseOperation(1);
			frame.pack();
			frame.setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Report();
	}
}
