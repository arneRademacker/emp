package de.emp.sqlite;

import java.sql.*;

import javax.swing.*;

public class sqliteConnector {

	 private Connection con;
	 public static Statement st;

	
	 public static Connection SqliteConnect(){
	        try{
	            Class.forName("org.sqlite.JDBC");
	            Connection con = DriverManager.getConnection("jdbc:sqlite:..\\EMP.Database\\src\\de\\emp\\sqlite\\emp.sqlite");
	            
	            
	            st = con.createStatement();
	            
	            return null;
	            
	        }catch(Exception ex) {
	            JOptionPane.showMessageDialog(null, ex);
	            return null;
	        }
	            		
}
}
