package tp.projetfilrouge.service;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseService {
	private final String DB_URL = "jdbc:mysql://127.0.0.1:3306/pfr?useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASSWORD = "";

	public Statement db;

	public DatabaseService() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection database = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		db = database.createStatement();
	}
}
