package de.szut.emp.dataLayer.dataAccessObjects.xml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import de.szut.emp.businessObjects.IEmailContact;
import de.szut.emp.dataLayer.dataAccessObjects.IEmailContactDao;

public class EmailContactDaoXml implements IEmailContactDao {

	public EmailContactDaoXml() {
		try {
			XMLReader xmlReader = XMLReaderFactory.createXMLReader();
			FileReader reader = new FileReader("emp.xml");
			// TODO implement content handler
			xmlReader.parse(new InputSource(reader));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void create(IEmailContact emailContact) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(IEmailContact emailContact) {
		// TODO Auto-generated method stub

	}

	@Override
	public IEmailContact first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEmailContact last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEmailContact next(IEmailContact currentEmailContact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEmailContact previous(IEmailContact currentEmailContact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(IEmailContact emailContact) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<IEmailContact> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEmailContact select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
