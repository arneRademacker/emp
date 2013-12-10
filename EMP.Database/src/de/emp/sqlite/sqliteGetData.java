package de.emp.sqlite;

import java.sql.ResultSet;

public class sqliteGetData {

	private ResultSet rs;

	public void sqlgetData() {

		try {
			String query = "SELECT * FROM adressen";

			rs = sqliteConnector.st.executeQuery(query);
			System.out.println("Records from Database");
			while (rs.next()) {
				String id = rs.getString("id");
				String vorname = rs.getString("vorname");
				String nachname = rs.getString("nachname");
				String email = rs.getString("email");
				System.out.println("ID: " + id + " Vorname: " + vorname + " "
						+ "Nachname : " + nachname + " E-Mail: " + email);
			}

		} catch (Exception ex) {

			System.out.println(ex);
		}

	}

}
