package gui;

import javax.swing.JOptionPane;

public class GuiException {

	public static void letzterDS(){
		JOptionPane.showMessageDialog(null,
			    "Kein weiterer Datensatz vorhanden!",
			    "Logischer Fehler",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	public static void loeschen(){
		if (JOptionPane.showConfirmDialog(null, "Wollen Sie den Datensatz wirklich löschen?", "Achtung!",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		    // TODO yes option
			
		} else {
		    // TODO no option
			
		}
	
	}
	public static void suchVorname(){
		String suchVorname = JOptionPane.showInputDialog(null," Bitte geben Sie den Vornamen ein: ",
				"Vornamensuche",
				JOptionPane.PLAIN_MESSAGE);
		System.out.println(suchVorname);
	}
	public static void suchNachname(){
		String suchNachname = JOptionPane.showInputDialog(null,"Bitte geben Sie den Nachnamen ein: ",
				"Nachnamensuche",
				JOptionPane.PLAIN_MESSAGE);
		System.out.println(suchNachname);
	}

}
