package de.szut.emp.dataLayer.businessObjects;

import de.szut.emp.businessObjects.IEmailContact;

public class EmailContact implements IEmailContact {

	private int id;
	private String vorname;
	private String nachname;
	private String email;

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getVorname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setVorname(String vorname) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNachname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNachname(String nachname) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub

	}

}
