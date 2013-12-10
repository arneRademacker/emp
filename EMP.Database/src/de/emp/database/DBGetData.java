package de.emp.database;

import java.sql.ResultSet;
import java.sql.*;

public class DBGetData {

	private Statement st;
	private ResultSet rs;

	public void getData() {

		try {
			String query = "SELECT * FROM adressen";
			rs = DBConnect.st.executeQuery(query);
			System.out.println("Records from Database");
			while (rs.next()) {
				String vorname = rs.getString("vorname");
				String name = rs.getString("name");
				String email = rs.getString("e-mail");
				System.out.println("Vorname: " + vorname + " " + "Nachname : "
						+ name + " E-Mail: " + email);
			}

		} catch (Exception ex) {

			System.out.println(ex);
		}

	}

}
