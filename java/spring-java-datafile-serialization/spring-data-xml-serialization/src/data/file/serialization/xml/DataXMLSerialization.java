package data.file.serialization.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@EqualsAndHashCode
@ToString
public class DataXMLSerialization {
	
	public static final String xmlFilePath="dataxmlserialization.xml";
	private Node company;
	private Document document;
	
	public void write(String croot, String celement) {
		try {
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			docFactory.setValidating(true);
			docFactory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();	
			Document doc = docBuilder.newDocument();
			
			
			
			
			// Root + Child element
			Element root = doc.createElement(croot);
			Element element = doc.createElement(celement);
			Element firstname = doc.createElement("firstname");
			Element lastname = doc.createElement("lastname");
			
			doc.appendChild(root);
			root.appendChild(element);
			
			Attr attr = doc.createAttribute("id");
			attr.setValue("10");
			element.setAttributeNode(attr);
				
			firstname.appendChild(doc.createTextNode("Rodney"));
			element.appendChild(firstname);
			
			lastname.appendChild(doc.createTextNode("Azevedo"));
			element.appendChild(lastname);
			
			Element employee2 = doc.createElement("employee");
			root.appendChild(employee2);

			attr = doc.createAttribute("id");
			attr.setValue("20");
			employee2.setAttributeNode(attr); 
			
			
			firstname = doc.createElement("firstname");
			firstname.appendChild(doc.createTextNode("Paula"));
			employee2.appendChild(firstname);
			
			lastname = doc.createElement("lastname");
			lastname.appendChild(doc.createTextNode("Azevedo"));
			employee2.appendChild(lastname);
			doc.getDocumentElement().normalize();
			
			
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource("indenter.xsl"));
			
			DOMSource domSource = new DOMSource(doc);
			
			StreamResult streamResult = new StreamResult(new File(xmlFilePath));
			
			
			transformer.transform(domSource, streamResult);
			System.out.println("File created.");
			
		} catch (ParserConfigurationException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void read(String filepath) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = documentBuilder.parse(xmlFilePath);
		document.getDocumentElement().normalize();
		
		System.out.println("Root element: " + document.getDocumentElement().getNodeName());
		
		if(document.hasChildNodes()) {
			System.out.println(document.getChildNodes());
		}
		
		NodeList nodeList = document.getElementsByTagName("employee");
		for(int count=0; count < nodeList.getLength(); count++) {
			Node elementNode = nodeList.item(count);
			if(elementNode.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println("Node name: " + elementNode.getNodeName());
				System.out.println("Node content: " + elementNode.getTextContent());
			}
			if(elementNode.hasAttributes()) {
				NamedNodeMap nodeMap = elementNode.getAttributes();
				for (int i=0; i< nodeMap.getLength(); i++) {
					Node node = nodeMap.item(i);
					System.out.println("Attribute name: " + node.getNodeName());
					System.out.println("Attribute value: " + node.getNodeValue());
				}
			}
			if(elementNode.hasChildNodes()) {
				System.out.println(elementNode.getChildNodes());
				System.out.println("Node name: " + elementNode.getNodeName());
				System.out.println("Node child name: " + elementNode.getParentNode().getNodeName());
				System.out.println("NodeList child name: " + elementNode.getFirstChild().getNodeName());
			}
		}
		
	}
	
	public void update() {
		
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder;
			documentBuilder = documentFactory.newDocumentBuilder();
			Document document;
			document = documentBuilder.parse(xmlFilePath);
			
			
			company = document.getFirstChild();
			
			// get element
			Node employee = document.getElementsByTagName("employee").item(0);
			
			System.out.println("AA" + employee.getNodeName());
			
			// update employee attribute
			NamedNodeMap attr = employee.getAttributes();
			Node nodeAttr = attr.getNamedItem("id");
			nodeAttr.setTextContent("10");
			
			// append a new node to employee
			Element age = document.createElement("Idade");
			age.appendChild(document.createTextNode("xx"));
			employee.appendChild(age);
			
			// loo�employee child
			NodeList list = employee.getChildNodes();
			
			int i=0;
			for(i=0; i<list.getLength(); i++) {
				Node node = list.item(i);
				// get lastname element and update the value
				if("lastname".equals(node.getNodeName())) {
					node.setTextContent("Nascimento");
				}
				
				// remove firstname element
				if("firstname".equals(node.getNodeName())) {
					employee.removeChild(node);
					employee.removeChild(employee.getFirstChild());
				}
			}
			list = document.getElementsByTagName("employee");
			System.out.println("N�mero de elementos no documento: " + list.getLength());
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource("indenter.xsl"));

			DOMSource domSource = new DOMSource(document);
			
			StreamResult streamResult = new StreamResult(new File(xmlFilePath));
			
			
			transformer.transform(domSource, streamResult);
			System.out.println("File created.");
			
			
			transformer.transform(domSource, streamResult);
			System.out.println("File created.");
		} catch ( ParserConfigurationException | SAXException | TransformerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

	public void delete() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
		document = documentBuilder.parse(xmlFilePath);
	}

	public void drop() {
		// TODO Auto-generated method stub
		
	}

}
