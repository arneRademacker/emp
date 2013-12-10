package de.emp.xmlParsing;

public class Letter {
	private String name;
	private String email;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the street
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param name
	 * @param email
	 */
	public Letter(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String toString() {
		return "User: " + this.name.trim() + "; besitzt die Mailadresse: "
				+ this.email.trim();
	}
}