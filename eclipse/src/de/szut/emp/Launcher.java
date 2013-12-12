package de.szut.emp;

import de.szut.emp.businessObjects.IEmailContact;
import de.szut.emp.dataLayer.DataLayerManager;
import de.szut.emp.dataLayer.businessObjects.EmailContact;
import de.szut.emp.dataLayer.settings.SettingsManager;

public class Launcher {

	public static void main(String[] args) {
		SettingsManager.getInstance().setPersistenceType(SettingsManager.PersistenceType.XML);
		IEmailContact emailContact = new EmailContact();
		emailContact.setVorname("John");
		emailContact.setNachname("Doe");
		emailContact.setEmail("John.Doe@random.com");
		DataLayerManager.getInstance().getDataLayer().getEmailContactDao().create(emailContact);
//		(new MainWindow()).init();
	}
}