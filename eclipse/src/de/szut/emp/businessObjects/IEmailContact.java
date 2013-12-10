package de.szut.emp.businessObjects;

public interface IEmailContact {

	public int getId();

	public String getVorname();

	public void setVorname(String vorname);

	public String getNachname();

	public void setNachname(String nachname);

	public String getEmail();

	public void setEmail(String email);
}
