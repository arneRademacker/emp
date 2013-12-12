package de.szut.emp.dataLayer.dataAccessObjects.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import de.szut.emp.businessObjects.IEmailContact;
import de.szut.emp.dataLayer.businessObjects.EmailContact;
import de.szut.emp.dataLayer.dataAccessObjects.IEmailContactDao;

public class EmailContactDaoXml implements IEmailContactDao, ContentHandler {

	private XMLReader xmlReader;
	private InputSource inputSource;

	private List<IEmailContact> emailContacts = new ArrayList<>();
	private EmailContact currentContact;
	private String currentElementValue;

	public EmailContactDaoXml() {
		try {
			xmlReader = XMLReaderFactory.createXMLReader();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		loadFile();
	}

	public void loadFile() {
		try {
			inputSource = new InputSource(new FileReader(
					"assets/emp.xml"));
			xmlReader.setContentHandler(this);
			xmlReader.parse(inputSource);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			Element rootElement = doc.createElement("contacts");
			doc.appendChild(rootElement);

			for (IEmailContact contact : emailContacts) {
				Element contactElement = doc.createElement("contact");
				rootElement.appendChild(contactElement);

				Element id = doc.createElement("id");
				id.appendChild(doc.createTextNode(String.valueOf(contact
						.getId())));
				contactElement.appendChild(id);

				Element name = doc.createElement("name");
				name.appendChild(doc.createTextNode(contact.getVorname()));
				contactElement.appendChild(name);

				Element surname = doc.createElement("surname");
				surname.appendChild(doc.createTextNode(contact.getNachname()));
				contactElement.appendChild(surname);

				Element email = doc.createElement("email");
				email.appendChild(doc.createTextNode(contact.getEmail()));
				contactElement.appendChild(email);
			}

			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(
					"../eclipse/assets/test.xml"));
			transformer.transform(source, result);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void create(IEmailContact emailContact) {
		if (emailContact instanceof EmailContact) {
			((EmailContact) emailContact).setId(emailContacts.size());
		}
		emailContacts.add(emailContact);
		write();
	}

	@Override
	public void delete(IEmailContact emailContact) {
		emailContacts.remove(emailContact);
		write();
	}

	@Override
	public IEmailContact first() {
		return emailContacts.get(0);
	}

	@Override
	public IEmailContact last() {
		return emailContacts.get(emailContacts.size() - 1);
	}

	@Override
	public IEmailContact next(IEmailContact currentEmailContact) {
		int currentIndex = emailContacts.indexOf(currentEmailContact);
		currentIndex = ++currentIndex % emailContacts.size();
		return emailContacts.get(currentIndex);
	}

	@Override
	public IEmailContact previous(IEmailContact currentEmailContact) {
		int currentIndex = emailContacts.indexOf(currentEmailContact);
		currentIndex = (currentIndex + (emailContacts.size() - 1))
				% emailContacts.size();
		return emailContacts.get(currentIndex);
	}

	@Override
	public void save(IEmailContact emailContact) {
		int index = emailContacts.indexOf(emailContact);
		emailContacts.remove(index);
		emailContacts.add(index, emailContact);
		write();
	}

	@Override
	public List<IEmailContact> select() {
		return emailContacts;
	}

	@Override
	public IEmailContact select(int id) {
		return emailContacts.get(id);
	}

	// ------------------------------------------------------------
	// SAX Parser
	// ------------------------------------------------------------

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		currentElementValue = new String(ch, start, length);
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (localName.equals("id")) {
			currentContact.setId(Integer.parseInt(currentElementValue));
		}

		if (localName.equals("name")) {
			currentContact.setVorname(currentElementValue);
		}

		if (localName.equals("surname")) {
			currentContact.setNachname(currentElementValue);
		}

		if (localName.equals("email")) {
			currentContact.setEmail(currentElementValue);
		}

		if (localName.equals("contact")) {
			emailContacts.add(currentContact);
		}
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void processingInstruction(String target, String data)
			throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		if (localName.equals("contact")) {
			currentContact = new EmailContact();
		}
	}

	@Override
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		// TODO Auto-generated method stub

	}

}