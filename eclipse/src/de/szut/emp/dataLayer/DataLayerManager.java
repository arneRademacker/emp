package de.szut.emp.dataLayer;

import de.szut.emp.dataLayer.dataAccessObjects.sqlite.DataLayerSqlite;
import de.szut.emp.dataLayer.dataAccessObjects.xml.DataLayerXml;
import de.szut.emp.dataLayer.settings.SettingsManager;
import de.szut.emp.dataLayer.settings.SettingsManager.PersistenceType;

public class DataLayerManager {

	private static final DataLayerManager INSTANCE = new DataLayerManager();

	public static final DataLayerManager getInstance() {
		return INSTANCE;
	}

	private DataLayerManager() {

	}

	private IDataLayer dataLayer = null;
	private PersistenceType usedPersistenceType = null;

	public IDataLayer getDataLayer() {
		PersistenceType persistenceType = SettingsManager.getInstance()
				.getPersistenceType();
		// TODO close opened data layers
//		if (dataLayer != null && usedPersistenceType != persistenceType) {
//		
//		}

		if (dataLayer == null || usedPersistenceType != persistenceType) {
			switch (persistenceType) {
			case SQLITE:
				dataLayer = new DataLayerSqlite();
				break;
			case XML:
				dataLayer = new DataLayerXml();
				break;
			case UNSET:
			default:
				System.err.println("No data layer specified");
				break;
			}
		}
		return dataLayer;
	}
}
