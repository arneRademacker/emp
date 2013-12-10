package de.emp.database;

import java.sql.ResultSet;

public class DBGetData {

	private ResultSet rs;
	private String query= "SELECT * FROM adressen";

	public void getData() {

		try {
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
			ex.printStackTrace();
		}

	}

}
