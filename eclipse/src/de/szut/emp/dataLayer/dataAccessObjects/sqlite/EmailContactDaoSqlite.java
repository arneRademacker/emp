package de.szut.emp.dataLayer.dataAccessObjects.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import de.szut.emp.businessObjects.IEmailContact;
import de.szut.emp.dataLayer.businessObjects.EmailContact;
import de.szut.emp.dataLayer.dataAccessObjects.IEmailContactDao;

public class EmailContactDaoSqlite implements IEmailContactDao {

	private static final String CLASSNAME = "org.sqlite.JDBC";
	private static final String CONNECTION_STRING = "jdbc:sqlite:assets/emp.sqlite";

	private Connection con;
	private Statement statement;

	public EmailContactDaoSqlite() {
		try {
			Class.forName(CLASSNAME);
			con = DriverManager.getConnection(CONNECTION_STRING);
			statement = con.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private IEmailContact emailContactFromSqlResult(ResultSet resultSet)
			throws SQLException {
		EmailContact emailContact = new EmailContact();
		emailContact.setId(resultSet.getInt("id"));
		emailContact.setVorname(resultSet.getString("vorname"));
		emailContact.setNachname(resultSet.getString("nachname"));
		emailContact.setEmail(resultSet.getString("email"));
		return emailContact;
	}

	@Override
	public void create(IEmailContact emailContact) {
		String query = "INSERT INTO adressen (vorname, nachname, email) VALUES ('"
				+ emailContact.getVorname()
				+ "','"
				+ emailContact.getNachname()
				+ "','"
				+ emailContact.getEmail()
				+ "')";
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(IEmailContact emailContact) {
		int contactId = emailContact.getId();
		String query = "DELETE FROM adressen WHERE id=" + contactId + ";";
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public IEmailContact first() {
		String query = "SELECT * FROM adressen ORDER BY id ASC";
		ResultSet queryResults = null;
		IEmailContact emailContact = null;
		try {
			queryResults = statement.executeQuery(query);
			queryResults.next();
			emailContact = emailContactFromSqlResult(queryResults);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emailContact;
	}
	
	
	@Override
	public IEmailContact last() {
		String query = "SELECT * FROM adressen ORDER BY id ASC";
		ResultSet queryResults = null;
		IEmailContact emailContact = null;
		try {
			queryResults = statement.executeQuery(query);
			while (queryResults.next()) {
				emailContact = emailContactFromSqlResult(queryResults);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emailContact;
	}

	@Override
	public IEmailContact next(IEmailContact currentEmailContact) {
		List<IEmailContact> emailContacts = select();
		int currentIndex = emailContacts.indexOf(currentEmailContact);
		currentIndex = ++currentIndex % emailContacts.size();
		return emailContacts.get(currentIndex);
	}

	@Override
	public IEmailContact previous(IEmailContact currentEmailContact) {
		List<IEmailContact> emailContacts = select();
		int currentIndex = emailContacts.indexOf(currentEmailContact);
		currentIndex = (currentIndex + (emailContacts.size() - 1)) % emailContacts.size();
		return emailContacts.get(currentIndex);
	}

	@Override
	public void save(IEmailContact emailContact) {
		String query = "UPDATE adressen SET " + "vorname='"
				+ emailContact.getVorname() + "', " + "nachname='"
				+ emailContact.getNachname() + "', " + "email='"
				+ emailContact.getEmail() + "' " + "WHERE id="
				+ emailContact.getId() + ";";
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<IEmailContact> select() {
		String query = "SELECT * FROM adressen ORDER BY id ASC";
		ResultSet queryResults = null;
		List<IEmailContact> emailContacts = new LinkedList<>();
		try {
			queryResults = statement.executeQuery(query);
			while (queryResults.next()) {
				emailContacts.add(emailContactFromSqlResult(queryResults));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emailContacts;
	}

	@Override
	public IEmailContact select(int id) {
		String query = "SELECT FROM adressen WHERE id=" + id + ";";
		ResultSet queryResults = null;
		IEmailContact emailContact = null;
		try {
			queryResults = statement.executeQuery(query);
			queryResults.next();
			emailContactFromSqlResult(queryResults);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emailContact;
	}

	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
