package de.emp.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class sqliteConnector {

	public static Statement st;

	public static Connection SqliteConnect() {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager
					.getConnection("jdbc:sqlite:..\\EMP.Database\\src\\de\\emp\\sqlite\\emp.sqlite");

			st = con.createStatement();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;

	}
}
