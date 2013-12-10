package de.szut.emp.dataLayer.businessObjects;

import de.szut.emp.businessObjects.IEmailContact;

public class EmailContact implements IEmailContact {

	private int id = -1;
	private String vorname = null;
	private String nachname = null;
	private String email = null;

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getVorname() {
		return this.vorname;
	}

	@Override
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	@Override
	public String getNachname() {
		return this.nachname;
	}

	@Override
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

}
