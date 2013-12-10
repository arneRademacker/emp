package de.szut.emp.dataLayer;

public class DataLayerManager {

	public static final DataLayerManager INSTANCE = new DataLayerManager();

	public static final DataLayerManager getInstance() {
		return INSTANCE;
	}

	private DataLayerManager() {
		
	}

	private IDataLayer dataLayer;

	public IDataLayer getDataLayer() {
		return dataLayer;
	}
}
