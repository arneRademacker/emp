package de.emp.sqlite;


public class Main {

	public static void main(String[] args) {
		sqliteConnector.SqliteConnect();
		
		sqliteGetData getData = new sqliteGetData();
		getData.sqlgetData();

		
	}

}
