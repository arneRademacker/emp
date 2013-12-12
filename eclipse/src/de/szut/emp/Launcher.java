package de.szut.emp;

import de.szut.emp.dataLayer.settings.SettingsManager;
import de.szut.emp.gui.MainWindow;

public class Launcher {

	public static void main(String[] args) {
		SettingsManager.getInstance().setPersistenceType(SettingsManager.PersistenceType.XML);
		(new MainWindow()).init();
	}
}