package de.szut.emp;

import de.szut.emp.dataLayer.DataLayerManager;
import de.szut.emp.dataLayer.dataAccessObjects.IEmailContactDao;

public class Launcher {

	public static void main(String[] args) {
		IEmailContactDao emailContactDao = DataLayerManager.getInstance().getDataLayer().getEmailContactDao();
		System.out.println(emailContactDao.first().getVorname());
	}
}
