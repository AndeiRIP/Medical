package gui.consultation;

import static start.Constants.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.MainPage;
import gui.pacient.PatientInfoView;
import gui.pacient.PatientInfomodify;

public class ConsultationView extends JFrame {
	private static final long serialVersionUID = -4553228631590052638L;

	private JButton bAdd, bModify, bview, bback;
	private JLabel linfo, linfo1, linfo2, linfo3;

	public ConsultationView() {
		super("Consultations");
		setSize(1024, 768);
		setVisible(true);
		setLayout(null);

		linfo = new JLabel("Consultations Info Page");
		linfo.setBounds(445, 30, 210, 20);
		add(linfo);

		linfo1 = new JLabel("1.  Create Consultation");
		linfo1.setBounds(200, 150, 210, 20);
		add(linfo1);

		linfo2 = new JLabel("2.  Modify  Consultations");
		linfo2.setBounds(200, 250, 210, 20);
		add(linfo2);

		linfo3 = new JLabel("3. View  Consultations");
		linfo3.setBounds(200, 350, 210, 20);
		add(linfo3);

		createButtons();
	}

	private void createButtons() {
		bAdd = new JButton(ADD_DATA, new ImageIcon(IMG_ADD));
		bAdd.setBounds(340, 180, 180, 30);
		bAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new NewConsultation();
				setVisible(false);
			}
		});
		add(bAdd);

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
