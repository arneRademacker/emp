package de.szut.emp.dataLayer;

import de.szut.emp.dataLayer.dataAccessObjects.IEmailContactDao;

public interface IDataLayer {

	public IEmailContactDao getEmailContactDao();

	public void close();

}
