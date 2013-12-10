package de.emp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnect {

	private Connection con;
	public static Statement st;

	public DBConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/emp", "root", "test");
			st = con.createStatement();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
