package de.emp.xmlParsing;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
 
public class SAX {
  public static void main(String[] args) {
    try {
      XMLReader xmlReader = XMLReaderFactory.createXMLReader();
       
      FileReader reader = new FileReader("test.xml");
      InputSource inputSource = new InputSource(reader);
       
      xmlReader.setContentHandler(new LetterHandler());
      xmlReader.parse(inputSource);
       
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    }
  }
}