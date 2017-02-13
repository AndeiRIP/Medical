package gui.pacient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.MainPage;
import static start.Constants.*;

public class PatientPage extends JFrame {
	private static final long serialVersionUID = -4553228631590052638L;

	private JButton badd, bModify, bview, bback;
	private JLabel linfo, linfo1, linfo2, linfo3;

	public PatientPage() {
		super("Patient's Information");
		setSize(1024, 768);
		setVisible(true);
		setLayout(null);

		linfo = new JLabel("Patient's   Information");
		linfo.setBounds(445, 30, 210, 20);
		add(linfo);

		linfo1 = new JLabel("1.  Add  Patients  Information");
		linfo1.setBounds(200, 150, 210, 20);
		add(linfo1);

		linfo2 = new JLabel("2.  Modify  Patients  Information");
		linfo2.setBounds(200, 250, 210, 20);
		add(linfo2);

		linfo3 = new JLabel("3. View  Patients  Information");
		linfo3.setBounds(200, 350, 210, 20);
		add(linfo3);

		createButtons();
	}

	private void createButtons() {
		badd = new JButton(ADD_DATA, new ImageIcon(IMG_ADD));
		badd.setBounds(340, 180, 180, 30);
		badd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new PatientInfo();
				setVisible(false);
			}
		});
		add(badd);

		bModify = new JButton(MODIFY_DATA, new ImageIcon(IMG_MODIFY));
		bModify.setBounds(340, 280, 180, 30);
		bModify.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new PatientInfomodify();
				setVisible(false);
			}
		});
		add(bModify);

		bview = new JButton(VIEW_DATA, new ImageIcon(IMG_SEARCH));
		bview.setBounds(340, 380, 180, 30);
		bview.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new PatientInfoView();
				setVisible(false);
			}
		});
		add(bview);

		bback = new JButton(BACK, new ImageIcon(IMG_RESTORE));
		bback.setBounds(503, 545, 100, 30);
		bback.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new MainPage();
				setVisible(false);
			}
		});
		add(bback);
	}

}
