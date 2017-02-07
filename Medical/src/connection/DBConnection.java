package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static Connection conn;

	public static Connection connect() {
		try {
			// connect - network client driver
			String dbURL = "jdbc:derby://localhost/ORACLE";
			Properties properties = new Properties();
			properties.put("create", "true");
			properties.put("user", "STUDENT");
			properties.put("password", "STUDENT");

			conn = DriverManager.getConnection(dbURL, properties);
			if (conn != null) {
				System.out.println("Connected to database!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	public static void disconnect() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
