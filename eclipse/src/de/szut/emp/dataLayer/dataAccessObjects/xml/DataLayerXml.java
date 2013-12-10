package de.szut.emp.dataLayer.dataAccessObjects.xml;

import de.szut.emp.dataLayer.IDataLayer;
import de.szut.emp.dataLayer.dataAccessObjects.IEmailContactDao;

public class DataLayerXml implements IDataLayer {

	private EmailContactDaoXml emailContactDao = null;

	@Override
	public IEmailContactDao getEmailContactDao() {
		if (emailContactDao == null) {
			emailContactDao = new EmailContactDaoXml();
		}
		return emailContactDao;
	}

	@Override
	public void close() {
		emailContactDao = null;
	}

}
