package data.file.serialization.app;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import data.file.serialization.xml.DataXMLSerialization;

public class DataXMLSerializationApp {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		
		DataXMLSerialization xmlSerialization = new DataXMLSerialization();
		xmlSerialization.write("company", "employee");
		String xmlFilePath="dataxmlserialization.xml";
		xmlSerialization.read(xmlFilePath);
		xmlSerialization.update();
		xmlSerialization.read(xmlFilePath);
	}

}
