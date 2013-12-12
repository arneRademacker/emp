package de.szut.emp.dataLayer.dataAccessObjects.xml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import de.szut.emp.businessObjects.IEmailContact;
import de.szut.emp.dataLayer.dataAccessObjects.IEmailContactDao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EmailContactDaoXml implements IEmailContactDao {

	public EmailContactDaoXml() {
//		try {
//			XMLReader xmlReader = XMLReaderFactory.createXMLReader();
//			FileReader reader = new FileReader("emp.xml");
			// TODO implement content handler
//			xmlReader.parse(new InputSource(reader));
//		} catch (SAXException e) {
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public void create(IEmailContact emailContact) {
			
	        try {
	            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	            Document doc = docBuilder.newDocument();
	 
	            Element rootElement = doc.createElement("contacts");
	            doc.appendChild(rootElement);
	 
	            // letter
	            Element letter = doc.createElement("contact");
	            rootElement.appendChild(letter);
	 
	            // name
	            Element surname = doc.createElement("surname");
	            surname.appendChild(doc.createTextNode(emailContact.getNachname()));
	            letter.appendChild(surname);
	 
	            // street
	            Element name = doc.createElement("name");
	            name.appendChild(doc.createTextNode(emailContact.getVorname()));
	            letter.appendChild(name);
	            
	            // street
	            Element email = doc.createElement("email");
	            email.appendChild(doc.createTextNode(emailContact.getEmail()));
	            letter.appendChild(email);
	 
	            // als XML schreiben
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource source = new DOMSource(doc);
	            StreamResult result = new StreamResult(new File("../eclipse/assets/test.xml"));
	            transformer.transform(source, result);
	 
	        } catch (ParserConfigurationException pce) {
	            pce.printStackTrace();
	        } catch (TransformerException tfe) {
	            tfe.printStackTrace();
	        }
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
