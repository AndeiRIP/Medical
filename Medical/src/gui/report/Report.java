package gui.report;

import static start.Constants.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.MainPage;
import gui.pacient.TableFromDatabase;

public class Report extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1120201205784321480L;

	private JButton buttonPattient, buttonDoctor, buttonConsultation, bback;
	private JLabel labelPatient, labelDoctor, labelConsultation;

	public Report() {
		super("Reports");
		setSize(1024, 768);
		setVisible(true);
		setLayout(null);

		// labels
		labelPatient = new JLabel("For Patients Reports Click Here :");
		labelPatient.setBounds(100, 200, 400, 30);
		add(labelPatient);

		labelDoctor = new JLabel("For Doctors Reports Click Here :");
		labelDoctor.setBounds(100, 350, 400, 30);
		add(labelDoctor);
		
		labelConsultation = new JLabel("For Consultations Reports Click Here :");
		labelConsultation.setBounds(100, 500, 400, 30);
		add(labelConsultation);

		// buttons
		buttonPattient = new JButton("Display Patient's Report", new ImageIcon("images/emp.png"));
		buttonPattient.setBounds(400, 200, 250, 30);
		add(buttonPattient);

		buttonDoctor = new JButton("Display Doctor's Report", new ImageIcon("images/users.png"));
		buttonDoctor.setBounds(400, 350, 250, 30);
		add(buttonDoctor);
		
		buttonConsultation = new JButton("Display Consultations Report", new ImageIcon("images/info.png"));
		buttonConsultation.setBounds(400, 500, 250, 30);
		add(buttonConsultation);

		bback = new JButton("BACK", new ImageIcon("images/restore.png"));
		bback.setBounds(480, 600, 100, 30);
		add(bback);

		createListeners();
	}
	
	private void createListeners() {
		buttonPattient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TableFromDatabase frame = new TableFromDatabase(TABLE_PATIENT);
				frame.setDefaultCloseOperation(1);
				frame.pack();
				frame.setVisible(true);
			}
		});
		
		buttonDoctor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TableFromDatabase frame = new TableFromDatabase(TABLE_DOCTOR);
				frame.setDefaultCloseOperation(1);
				frame.pack();
				frame.setVisible(true);
			}
		});
		
		buttonConsultation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TableFromDatabase frame = new TableFromDatabase(TABLE_CONSULTATION);
				frame.setDefaultCloseOperation(1);
				frame.pack();
				frame.setVisible(true);
			}
		});
		bback.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == bback) {
			new MainPage();
			setVisible(false);
		}

	}

	public static void main(String[] args) {
		new Report();
	}
}
