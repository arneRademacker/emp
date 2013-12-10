package de.szut.emp.dataLayer.dataAccessObjects.sqlite;

import de.szut.emp.dataLayer.IDataLayer;
import de.szut.emp.dataLayer.dataAccessObjects.IEmailContactDao;

public class DataLayerSqlite implements IDataLayer {

	private EmailContactDaoSqlite emailContactDao = null;

	@Override
	public IEmailContactDao getEmailContactDao() {
		if (emailContactDao == null) {
			emailContactDao = new EmailContactDaoSqlite();
		}
		return emailContactDao;
	}

	@Override
	public void close() {
		emailContactDao.close();
		emailContactDao = null;
	}

}
