package de.emp.xmlParsing;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class LetterHandler implements ContentHandler {

	private ArrayList<Letter> alleLetter = new ArrayList<Letter>();
	private String currentValue;
	private Letter letter;

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		currentValue = new String(ch, start, length);
	}

	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		if (localName.equals("letter")) {
			letter = new Letter(null, null);
		}
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		// Name setzen
		if (localName.equals("name")) {
			letter.setName(currentValue);
		}

		// Street setzen
		if (localName.equals("email")) {
			letter.setEmail(currentValue);
		}

		// Person in Personenliste abspeichern falls Person End-Tag erreicht
		// wurde.
		if (localName.equals("letter")) {
			alleLetter.add(letter);
			System.out.println(letter);
		}
	}

	public void endDocument() throws SAXException {
	}

	public void endPrefixMapping(String prefix) throws SAXException {
	}

	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
	}

	public void processingInstruction(String target, String data)
			throws SAXException {
	}

	public void setDocumentLocator(Locator locator) {
	}

	public void skippedEntity(String name) throws SAXException {
	}

	public void startDocument() throws SAXException {
	}

	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
	}
}