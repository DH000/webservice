package com.lin.webservice.test.xml;

import java.io.IOException;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.EventFilter;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.xml.internal.fastinfoset.stax.events.AttributeBase;
import com.sun.xml.internal.stream.events.CharacterEvent;
import com.sun.xml.internal.stream.events.EndDocumentEvent;
import com.sun.xml.internal.stream.events.EndElementEvent;
import com.sun.xml.internal.stream.events.StartDocumentEvent;
import com.sun.xml.internal.stream.events.StartElementEvent;

public class InputFactoryTest {

	@Test
	public void streamTest(){
		XMLInputFactory factory = XMLInputFactory.newFactory();
		try {
			XMLStreamReader reader = factory.createXMLStreamReader(this.getClass().getClassLoader().getResourceAsStream("books.xml"));
			
			while(reader.hasNext()){
				int type = reader.next();
				if(type == XMLStreamConstants.START_ELEMENT){
					String tagName = reader.getName().toString();
					System.out.print("<" + tagName + ">");
				}else if(type == XMLStreamConstants.CHARACTERS){
					System.out.print(reader.getText());
				}else if(type == XMLStreamConstants.END_ELEMENT){
					String tagName = reader.getName().toString();
					System.out.println("</" + tagName + ">");
				}
			}
			
			reader.close();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void streamTypeTest(){
		XMLInputFactory factory = XMLInputFactory.newFactory();
		try {
			XMLStreamReader reader = factory.createXMLStreamReader(this.getClass().getClassLoader().getResourceAsStream("books.xml"));
			
			while(reader.hasNext()){
				reader.next();
				if(reader.isStartElement()){
					String tagName = reader.getName().toString();
					System.out.print("<" + tagName + ">");
				}else if(reader.isCharacters()){
					System.out.print(reader.getText());
				}else if(reader.isEndElement()){
					String tagName = reader.getName().toString();
					System.out.println("</" + tagName + ">");
				}
			}
			
			reader.close();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void eventTest(){
		XMLInputFactory factory = XMLInputFactory.newFactory();
		try {
			XMLEventReader reader = factory.createXMLEventReader(this.getClass().getClassLoader().getResourceAsStream("books.xml"));
			
			while(reader.hasNext()){
				XMLEvent event = reader.nextEvent();
				int type = event.getEventType();
				if(type == XMLStreamConstants.START_ELEMENT){
//					for(Iterator iter = event.asStartElement().getAttributes(); iter.hasNext();){
//						System.out.println(iter.next());
//					}
					String tagName = event.asStartElement().getName().toString();
					System.out.print("<" + tagName + ">");
				}else if(type == XMLStreamConstants.CHARACTERS){
					System.out.print(event.asCharacters().getData());
				}else if(type == XMLStreamConstants.END_ELEMENT){
					String tagName = event.asEndElement().getName().toString();
					System.out.println("</" + tagName + ">");
				}
			}
			
			reader.close();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void filterTest(){
		XMLInputFactory factory = XMLInputFactory.newFactory();
		XMLEventReader reader;
		try {
			reader = factory.createXMLEventReader(this.getClass().getClassLoader().getResourceAsStream("books.xml"));
			reader = factory.createFilteredReader(reader, new EventFilter() {
				public boolean accept(XMLEvent event) {
					if(event.isStartElement()){
						return event.asStartElement().getName().toString().equals("price");
					}else if(event.isEndElement()){
						return event.asEndElement().getName().toString().equals("price");
					}
					return false;
				}
			});
			
			while(reader.hasNext()){
				XMLEvent event = reader.nextEvent();
				if(event.isStartElement()){
					String tagName = event.asStartElement().getName().toString();
					System.out.print("<" + tagName + ">");
				}else if(event.isCharacters()){
					System.out.print(event.asCharacters().getData());
				}else if(event.isEndElement()){
					String tagName = event.asEndElement().getName().toString();
					System.out.println("</" + tagName + ">");
				}
			}
			reader.close();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void xpathTest(){
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = db.parse(this.getClass().getClassLoader().getResourceAsStream("books.xml"));
			XPath xPath = XPathFactory.newInstance().newXPath();
			
			NodeList list = (NodeList) xPath.evaluate("//book[@category='WEB']", doc, XPathConstants.NODESET);
			for(int i=0, len=list.getLength(); i<len; i++){
				Element ele = (Element) list.item(i);
				System.out.println(ele.getElementsByTagName("title").item(0).getTextContent());
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void writeStreamTest(){
		try {
			String ns = "http://test";
			XMLStreamWriter writer = XMLOutputFactory.newFactory().createXMLStreamWriter(System.out);
			writer.writeStartDocument("UTF-8", "1.0");
			writer.writeStartElement("ns", "person", ns);
			writer.writeAttribute("id", "1");
			writer.writeStartElement("ns", "name", ns);
			writer.writeCharacters("hello");
			writer.writeEndElement();
			writer.writeEndElement();
			writer.writeEndDocument();
			writer.flush();
			writer.close();
		}catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void writeEventTest(){
		try {
			XMLEventWriter writer = XMLOutputFactory.newFactory().createXMLEventWriter(System.out);
			writer.setPrefix("ns", "http://test");
			writer.add(new StartDocumentEvent());
			writer.add(new StartElementEvent(new QName("person")));
			writer.add(new AttributeBase("id", "1"));
			writer.add(new StartElementEvent(new QName("name")));
			writer.add(new CharacterEvent("hello"));
			writer.add(new EndElementEvent());
			writer.add(new EndElementEvent());
			writer.add(new EndDocumentEvent());
			writer.flush();
			writer.close();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void modXmlTest(){
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = db.parse(this.getClass().getClassLoader().getResourceAsStream("books.xml"));
			XPath xPath = XPathFactory.newInstance().newXPath();
			Element book = (Element) ((NodeList) xPath.evaluate("//book[title='Learning XML']", doc, XPathConstants.NODESET)).item(0);
			Element price = (Element) book.getElementsByTagName("price").item(0);
			price.setTextContent("40.0");
			
			Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			tr.transform(new DOMSource(doc), new StreamResult(System.out));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
























