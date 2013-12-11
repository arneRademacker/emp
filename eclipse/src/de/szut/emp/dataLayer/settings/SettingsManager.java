package de.szut.emp.dataLayer.settings;

public class SettingsManager {

	private static final SettingsManager INSTANCE = new SettingsManager();

	public static final SettingsManager getInstance() {
		return INSTANCE;
	}

	private SettingsManager() {

	}

	public enum PersistenceType {
		UNSET, SQLITE, XML
	}

	private PersistenceType persitenceType = PersistenceType.SQLITE;

	public PersistenceType getPersistenceType() {
		return persitenceType;
	}

	public void setPersistenceType(PersistenceType persitenceType) {
		this.persitenceType = persitenceType;
	}
}
