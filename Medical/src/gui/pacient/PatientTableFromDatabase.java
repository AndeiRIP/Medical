package gui.pacient;

import static start.Constants.*;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import connection.DBConnection;

public class PatientTableFromDatabase extends JFrame {
	private static final long serialVersionUID = -6006325187802706852L;
	
	static Connection cn = null;
	Statement st = null;
	ResultSet rs = null;

	public PatientTableFromDatabase() {
		Vector<String> columnNames = new Vector<String>();
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		try {
			// Connect to the Database

			Statement st = DBConnection.connect().createStatement();

			// Read data from a table
			String sql = SQL_SELECT + " * " + SQL_FROM + " " + TABLE_PATIENT;
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();

			// Get column names
			for (int i = 1; i <= columns; i++) {
				columnNames.addElement(md.getColumnName(i));
			}

			// Get row data
			while (rs.next()) {
				Vector<Object> row = new Vector<Object>(columns);

				for (int i = 1; i <= columns; i++) {
					row.addElement(rs.getObject(i));
				}
				
				data.addElement(row);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		// Close the connection
		DBConnection.disconnect();
		
		// Create table with database data
		JTable table = new JTable(data, columnNames);

		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);

		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		PatientTableFromDatabase frame = new PatientTableFromDatabase();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
