package de.szut.emp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


import de.szut.emp.businessObjects.IEmailContact;
import de.szut.emp.dataLayer.DataLayerManager;
import de.szut.emp.dataLayer.businessObjects.EmailContact;
import de.szut.emp.dataLayer.dataAccessObjects.IEmailContactDao;
import de.szut.emp.dataLayer.settings.SettingsManager;
import de.szut.emp.exceptions.NoEmailContactFoundException;
import de.szut.emp.exceptions.NoNextEmailContactFoundException;
import de.szut.emp.exceptions.NoPreviousEmailFoundException;

public class MainWindow {
	private JLabel l2Name;
	private JTextField t2Name;
	private JLabel l2Email;
	private JLabel l1Vorname;
	private JLabel l1Email;
	private JButton bErsterDS;
	private JButton bLetzterDS;
	private JTextField t1ID;
	private JLabel l1ID;
	private JButton bNaechsterDatensatz;
	private JButton bDatensatzDavor;
	private JTextField t1Email;
	private JTextField t1Vorname;
	private JButton bsearchName;
	private JButton bsearchVorname;
	private JButton bloeschen;
	private JTextField t1Name;
	private JLabel l1Name;
	private JButton bSpeichern;
	private JTextField t2Email;
	private JTextField t2Vorname;
	private JLabel l2Vorname;
	private JTabbedPane tabLeiste;

	private IEmailContactDao emailContactDao;
	
	private IEmailContact currentEmailContact;

	public void init() {
		JFrame fenster = new JFrame("Email-Verwaltung");
		fenster.setSize(800, 600);
		fenster.setLocationRelativeTo(null);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		if (SettingsManager.getInstance().getPersistenceType() == SettingsManager.PersistenceType.UNSET) {
			SettingsManager.getInstance().setPersistenceType(SettingsManager.PersistenceType.SQLITE);
		}
		emailContactDao = DataLayerManager.getInstance().getDataLayer().getEmailContactDao();

		tabLeiste = new JTabbedPane();

		{
			JPanel panel1 = new JPanel();
			tabLeiste.addTab("Adressbuch", null, panel1, null);
			{
				l1Name = new JLabel();
				panel1.add(l1Name);
				l1Name.setText("Name:");
				l1Name.setBounds(19, 31, 81, 17);
			}
			{
				t1Name = new JTextField();
				panel1.add(t1Name);
				t1Name.setBounds(100, 28, 232, 23);
				t1Name.setEditable(false);
			}
			{
				l1Vorname = new JLabel();
				panel1.add(l1Vorname);
				l1Vorname.setText("Vorname:");
				l1Vorname.setBounds(19, 82, 81, 16);
			}
			{
				t1Vorname = new JTextField();
				panel1.add(t1Vorname);
				t1Vorname.setBounds(100, 82, 232, 24);
				t1Vorname.setEditable(false);
			}
			{
				l1Email = new JLabel();
				panel1.add(l1Email);
				l1Email.setText("E-Mail:");
				l1Email.setBounds(19, 144, 81, 16);
			}
			{
				t1Email = new JTextField();
				panel1.add(t1Email);
				t1Email.setBounds(100, 141, 232, 24);
				t1Email.setEditable(false);
			}
			{
				bDatensatzDavor = new JButton();
				panel1.add(bDatensatzDavor);
				bDatensatzDavor.setText("<<< Vorheriger");
				bDatensatzDavor.setBounds(12, 235, 189, 23);
				bDatensatzDavor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						bDatensatzDavorActionPerformed(evt);
					}
				});
			}
			{
				bNaechsterDatensatz = new JButton();
				panel1.add(bNaechsterDatensatz);
				bNaechsterDatensatz.setText("Nächster >>>");
				bNaechsterDatensatz.setBounds(228, 235, 213, 23);
				bNaechsterDatensatz.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						bNaechsterDatensatzActionPerformed(evt);
					}
				});
			}
			{
				l1ID = new JLabel();
				panel1.add(l1ID);
				l1ID.setText("Kontakt ID");
				l1ID.setBounds(650, 12, 80, 16);
			}
			{
				t1ID = new JTextField();
				panel1.add(t1ID);
				t1ID.setBounds(650, 34, 58, 23);
				t1ID.setEditable(false);
			}
			{
				bLetzterDS = new JButton();
				panel1.add(bLetzterDS);
				bLetzterDS.setText("Letzter Datensatz |>>");
				bLetzterDS.setBounds(228, 277, 213, 23);
				bLetzterDS.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						bLetzterDSActionPerformed(evt);
					}
				});
			}
			{
				bErsterDS = new JButton();
				panel1.add(bErsterDS);
				bErsterDS.setText("<<| Erster Datensatz");
				bErsterDS.setBounds(12, 277, 189, 23);
				bErsterDS.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						bErsterDSActionPerformed(evt);
					}
				});
			}
			{
				bloeschen = new JButton();
				panel1.add(bloeschen);
				bloeschen.setText("Datensatz löschen");
				bloeschen.setBounds(12, 491, 189, 23);
				bloeschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						bloeschenActionPerformed(evt);
					}
				});
			}
			{
				bsearchVorname = new JButton();
				panel1.add(bsearchVorname);
				bsearchVorname.setText("Suchen...");
				bsearchVorname.setBounds(368, 82, 141, 21);
				bsearchVorname.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						bsearchVornameActionPerformed(evt);
					}
				});
			}
			{
				bsearchName = new JButton();
				panel1.add(bsearchName);
				bsearchName.setText("Suchen...");
				bsearchName.setBounds(368, 28, 141, 23);
				bsearchName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						bsearchNameActionPerformed(evt);
					}
				});
			}

			panel1.setLayout(null);
		}
		{
			JPanel panel2 = new JPanel();
			tabLeiste.addTab("Kontakt hinzufügen", null, panel2, null);
			panel2.setLayout(null);
			{
				l2Name = new JLabel();
				panel2.add(l2Name);
				l2Name.setText("Name:");
				l2Name.setBounds(38, 36, 64, 16);
			}
			{
				t2Name = new JTextField();
				panel2.add(t2Name);
				t2Name.setBounds(114, 36, 289, 26);
			}
			{
				l2Vorname = new JLabel();
				panel2.add(l2Vorname);
				l2Vorname.setText("Vorname:");
				l2Vorname.setBounds(38, 86, 71, 16);
			}
			{
				t2Vorname = new JTextField();
				panel2.add(t2Vorname);
				t2Vorname.setBounds(114, 86, 289, 26);
			}
			{
				l2Email = new JLabel();
				panel2.add(l2Email);
				l2Email.setText("E-Mail:");
				l2Email.setBounds(38, 144, 64, 16);
			}
			{
				t2Email = new JTextField();
				panel2.add(t2Email);
				t2Email.setBounds(114, 141, 289, 23);
			}
			{
				bSpeichern = new JButton();
				panel2.add(bSpeichern);
				bSpeichern.setText("Kontakt speichern");
				bSpeichern.setBounds(232, 212, 169, 28);
				bSpeichern.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						baddContactActionPerformed(evt);
					}
				});
			}
		}

		fenster.add(tabLeiste);
		fenster.setVisible(true);

		try {
			updateUiWithContact(emailContactDao.first());
		} catch (NoEmailContactFoundException e) {
			e.printStackTrace();
		}
	}

	private void baddContactActionPerformed(ActionEvent evt) {
		IEmailContact emailContact = new EmailContact();
		emailContact.setVorname(t2Vorname.getText());
		t2Vorname.setText("");
		emailContact.setNachname(t2Name.getText());
		t2Name.setText("");
		emailContact.setEmail(t2Email.getText());
		t2Email.setText("");

		emailContactDao.create(emailContact);
		updateUiWithContact(emailContact);
		tabLeiste.setSelectedIndex(0);
	}

	private void bDatensatzDavorActionPerformed(ActionEvent evt) {
		IEmailContact previousEmailContact;
		try {
			previousEmailContact = emailContactDao.previous(currentEmailContact);
			if (previousEmailContact != null) {
				updateUiWithContact(previousEmailContact);
			} else {
				letzterDS();
			}
		} catch (NoPreviousEmailFoundException e) {
			e.printStackTrace();
		}
	}

	private void bNaechsterDatensatzActionPerformed(ActionEvent evt) {
		IEmailContact nextEmailContact;
		try {
			nextEmailContact = emailContactDao.next(currentEmailContact);
			if (nextEmailContact != null) {
				updateUiWithContact(nextEmailContact);
			} else {
				letzterDS();
			}
		} catch (NoNextEmailContactFoundException e) {
			e.printStackTrace();
		}
	}

	private void bErsterDSActionPerformed(ActionEvent evt) {
		IEmailContact firstEmailContact;
		try {
			firstEmailContact = emailContactDao.first();
			if (firstEmailContact != null) {
				updateUiWithContact(firstEmailContact);
			} else {
				letzterDS();
			}
		} catch (NoEmailContactFoundException e) {
			e.printStackTrace();
		}
	}

	private void bLetzterDSActionPerformed(ActionEvent evt) {
		IEmailContact lastEmailContact;
		try {
			lastEmailContact = emailContactDao.last();
			if (lastEmailContact != null) {
				updateUiWithContact(lastEmailContact);
			} else {
				letzterDS();
			}
		} catch (NoEmailContactFoundException e) {
			e.printStackTrace();
		}
	}

	private void bloeschenActionPerformed(ActionEvent evt) {
		loeschen(currentEmailContact);
	}

	private void bsearchVornameActionPerformed(ActionEvent evt) {
		suchVorname();
	}

	private void bsearchNameActionPerformed(ActionEvent evt) {
		suchNachname();
	}

	private void updateUiWithContact(IEmailContact emailContact) {
		if (emailContact != null) {
			this.currentEmailContact = emailContact;
			t1Name.setText(this.currentEmailContact.getNachname());
			t1Vorname.setText(this.currentEmailContact.getVorname());
			t1Email.setText(this.currentEmailContact.getEmail());
			t1ID.setText(String.valueOf(this.currentEmailContact.getId()));
		}
	}

	private void letzterDS() {
		JOptionPane.showMessageDialog(null,
				"Kein weiterer Datensatz vorhanden!", "Logischer Fehler",
				JOptionPane.ERROR_MESSAGE);
	}

	private void loeschen(IEmailContact emailContact) {
		if (JOptionPane.showConfirmDialog(null,
				"Wollen Sie den Datensatz wirklich löschen?", "Achtung!",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			IEmailContact contactToDelete = currentEmailContact;
			IEmailContact contactToSelect = null;
			try {
				contactToSelect = emailContactDao.previous(contactToDelete);
			} catch (NoPreviousEmailFoundException e) {
				e.printStackTrace();
			}
			emailContactDao.delete(contactToDelete);
			updateUiWithContact(contactToSelect);
		}
	}

	private void suchVorname() {
		String suchVorname = JOptionPane.showInputDialog(null,
				" Bitte geben Sie den Vornamen ein: ", "Vornamensuche",
				JOptionPane.PLAIN_MESSAGE);
		System.out.println(suchVorname);
		// TODO actually perform search
	}

	private void suchNachname() {
		String suchNachname = JOptionPane.showInputDialog(null,
				"Bitte geben Sie den Nachnamen ein: ", "Nachnamensuche",
				JOptionPane.PLAIN_MESSAGE);
		System.out.println(suchNachname);
		// TODO actually perform search
	}

}
