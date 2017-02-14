package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.consultation.ConsultationPage;
import gui.pacient.PatientPage;
import gui.report.Report;
import static start.Constants.*;
import start.StartApp;

public class MainPage extends JFrame {
	private static final long serialVersionUID = -3060188223831053422L;

	private JButton bpat, bdoc, bbill, breport, bCons, bback, bexit;
	private JLabel linfo, linfo1, linfo2, linfo3, linfo4, lCons;

	private static final int width = 1024;
	private static final int height = 768;

	public MainPage() {

		super(APP_TITLE);
		setSize(width, height);
		setVisible(true);
		setLayout(null);

		linfo = new JLabel("SELECT THE APPROPRIATE OPTION");
		linfo.setBounds(30, 137, 210, 20);
		add(linfo);

		linfo1 = new JLabel("1. For Inserting,  Modifying,  Retrieving Patients related Data");
		linfo1.setBounds(50, 205, 335, 20);
		add(linfo1);

		linfo2 = new JLabel("2. For Inserting,  Modifying,  Retrieving Doctors related Data");
		linfo2.setBounds(50, 275, 335, 20);
		add(linfo2);

		linfo3 = new JLabel("3. Billing   Details");
		linfo3.setBounds(50, 345, 150, 20);
		add(linfo3);

		linfo4 = new JLabel("4. Patient and Doctor related Data");
		linfo4.setBounds(50, 413, 250, 20);
		add(linfo4);
		
		lCons = new JLabel("5. Patient and Doctor related Data");
		lCons.setBounds(50, 466, 250, 20);
		add(lCons);
     
		createMenuButtons();
		createActionButtons();

	}

	private void createMenuButtons() {
		bpat = new JButton(PACIENT, new ImageIcon(IMG_ADVANCES));
		bpat.setBounds(430, 200, 180, 30);
		bpat.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new PatientPage();
				setVisible(false);
			}
		});
		add(bpat);

		bdoc = new JButton(DOCTOR, new ImageIcon(IMG_ADVANCES));
		bdoc.setBounds(430, 270, 180, 30);
		bdoc.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new DocStart();
				setVisible(false);
			}
		});
		add(bdoc);

		bbill = new JButton(BILLING, new ImageIcon(IMG_BILLING));
		bbill.setBounds(430, 340, 180, 30);
		bbill.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new Billing();
				setVisible(false);
			}
		});
		add(bbill);

		breport = new JButton(REPORT, new ImageIcon(IMG_REPORT));
		breport.setBounds(430, 408, 180, 30);
		breport.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new Report();
				setVisible(false);
			}
		});
		add(breport);
		
		bCons = new JButton("Consultation", new ImageIcon(IMG_INFO));
		bCons.setBounds(430, 470, 180, 30);
		bCons.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new ConsultationPage();
				setVisible(false);
			}
		});
		add(bCons);
	}

	private void createActionButtons() {
		bback = new JButton(BACK, new ImageIcon(IMG_BACK));
		bback.setBounds(230, 545, 100, 30);
		bback.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new StartApp();
				setVisible(false);	
			}
		});
		add(bback);

		bexit = new JButton(EXIT, new ImageIcon(IMG_EXIT));
		bexit.setBounds(730, 545, 100, 30);
		bexit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(bexit);
	}

}