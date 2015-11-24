package com.lin.webservice.test.soap;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPFaultException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.lin.webservice.service.bean.User;
import com.lin.webservice.test.Constants;

public class SoapMessageTest {
	
	@Test
	public void createReqMessageTest() {
		try {
			// 1、创建消息工厂
			MessageFactory factory = MessageFactory.newInstance();
			// 2、创建saop消息
			SOAPMessage message = factory.createMessage();
			// 3、获取saoppart
			SOAPPart soapPart = message.getSOAPPart();
			// 4、获取消息信封
			SOAPEnvelope envelope = soapPart.getEnvelope();
			// 5、获取消息体
			SOAPBody body = envelope.getBody();
			// 6、创建消息体节点(方法节点)
			SOAPBodyElement bodyElement = body.addBodyElement(new QName(Constants.NAMESPACE, "add", Constants.NAMESPACE_SP));
			bodyElement.addChildElement("a").setValue("5");
			bodyElement.addChildElement("b").setValue("10");
			message.writeTo(System.out);
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void sendReqMessageTest() {
		try {
			// 1、创建服务
			Service service = Service.create(new URL(Constants.PUBLISH_URL), new QName(Constants.NAMESPACE, "ArithmeticServiceImplService"));
			// 2、创建dispatch
			Dispatch<SOAPMessage> dispatch = service.createDispatch(new QName(Constants.NAMESPACE, "ArithmeticServiceImplPort"), SOAPMessage.class, Service.Mode.MESSAGE);
			// 3、创建请求消息体
			MessageFactory factory = MessageFactory.newInstance();
			SOAPMessage message = factory.createMessage();
			SOAPPart soapPart = message.getSOAPPart();
			SOAPEnvelope envelope = soapPart.getEnvelope();
			SOAPBody soapBody = envelope.getBody();
			SOAPBodyElement bodyElement = soapBody.addBodyElement(new QName(Constants.METHOD_NAMESPACE, "add", Constants.NAMESPACE_SP));
			bodyElement.addChildElement("a").setValue("5");
			bodyElement.addChildElement("b").setValue("10");
			
			// 4、发送请求
			SOAPMessage respSoapMessage = dispatch.invoke(message);
			// 5、解析响应
			SOAPBody respSoapBody = respSoapMessage.getSOAPBody();
			String res = respSoapBody.getElementsByTagName("addResult").item(0).getTextContent();
			System.out.println("响应结果：" + res);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SOAPException e) {
			e.printStackTrace();
		}
	}
	
	public String listUser() {
		StringBuilder buf = new StringBuilder();
		buf.append("<").append(Constants.NAMESPACE_SP).append(":list xmlns:").append(Constants.NAMESPACE_SP).append("=\"").append(Constants.METHOD_NAMESPACE).append("\"/>");
		
		return buf.toString();
	}
	
	public String loginUser() {
		StringBuilder buf = new StringBuilder();
		buf.append("<").append(Constants.NAMESPACE_SP).append(":login xmlns:").append(Constants.NAMESPACE_SP).append("=\"").append(Constants.METHOD_NAMESPACE).append("\">")
				.append("<").append("username>").append("admin4").append("</").append("username>").append("<").append("password>").append("123").append("</").append("password>")
				.append("</").append(Constants.NAMESPACE_SP).append(":login>");
		
		return buf.toString();
	}
	
	public String addUser() {
		StringBuilder buf = new StringBuilder();
		buf.append("<").append(Constants.NAMESPACE_SP).append(":addUser xmlns:").append(Constants.NAMESPACE_SP).append("=\"").append(Constants.METHOD_NAMESPACE).append("\">");
		
		StringWriter writer = new StringWriter();
		User user = new User(3, "admin3", "123");
		try {
			Marshaller marshaller = JAXBContext.newInstance(User.class).createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			marshaller.marshal(user, writer);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		buf.append(writer.toString()).append("</").append(Constants.NAMESPACE_SP).append(":addUser>");
		
		return buf.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new SoapMessageTest().addUser());
	}
	
	@Test
	public void sendPayloadMessageTest() {
		try {
			// 1、创建服务
			Service service = Service.create(new URL(Constants.PUBLISH_URL), new QName(Constants.NAMESPACE, "MyServiceImplService"));
			// 2、创建dispatch
			Dispatch<Source> dispatch = service.createDispatch(new QName(Constants.NAMESPACE, "MyServiceImplPort"), Source.class, Service.Mode.PAYLOAD);
			// 3、创建请求消息体
//			StreamSource streamSource = new StreamSource(new StringReader(listUser()));
			StreamSource streamSource = new StreamSource(new StringReader(loginUser()));
//			StreamSource streamSource = new StreamSource(new StringReader(addUser()));
			
			// 4、发送请求
			Source respSource = dispatch.invoke(streamSource);
			
			// 5、消息提转换
			DOMResult domResult = new DOMResult();
			Transformer transform = TransformerFactory.newInstance().newTransformer();
			transform.transform(respSource, domResult);
			
			// 6、解析响应
			XPath xPath = XPathFactory.newInstance().newXPath();
			NodeList list = (NodeList) xPath.evaluate("//user", domResult.getNode(), XPathConstants.NODESET);
			Unmarshaller um = JAXBContext.newInstance(User.class).createUnmarshaller();
			for (int i = 0, len = list.getLength(); i < len; i++) {
				Node node = list.item(i);
				User user = (User) um.unmarshal(node);
				System.out.println(user);
			}
		} catch(SOAPFaultException e){
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void sendHeadReqMessageTest() {
		try {
			// 1、创建服务
			Service service = Service.create(new URL(Constants.PUBLISH_URL), new QName(Constants.NAMESPACE, "MyServiceImplService"));
			// 2、创建dispatch
			Dispatch<SOAPMessage> dispatch = service.createDispatch(new QName(Constants.NAMESPACE, "MyServiceImplPort"), SOAPMessage.class, Service.Mode.MESSAGE);
			// 3、头部消息
			MessageFactory factory = MessageFactory.newInstance();
			SOAPMessage message = factory.createMessage();
			SOAPPart soapPart = message.getSOAPPart();
			SOAPEnvelope envelope = soapPart.getEnvelope();
			SOAPHeader soapHeader = envelope.getHeader();
			SOAPHeaderElement headerElement = soapHeader.addHeaderElement(new QName(Constants.NAMESPACE, "authInfo", Constants.NAMESPACE_SP));
			// 4、创建请求消息体
			SOAPBody soapBody = envelope.getBody();
			soapBody.addBodyElement(new QName(Constants.METHOD_NAMESPACE, "headerMessage", Constants.NAMESPACE_SP));
			headerElement.setValue("hello world.");
			message.writeTo(System.out);
			// 5、发送请求
			SOAPMessage respSoapMessage = dispatch.invoke(message);
			// 6、解析响应
			SOAPBody respSoapBody = respSoapMessage.getSOAPBody();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void sendWsdlHeadReqMessageTest() {
		try {
			// 1、创建服务
			Service service = Service.create(new URL(Constants.PUBLISH_URL), new QName(Constants.NAMESPACE, "MyTestServiceImplService"));
			// 2、创建dispatch
			Dispatch<SOAPMessage> dispatch = service.createDispatch(new QName(Constants.NAMESPACE, "MyTestServiceImplPort"), SOAPMessage.class, Service.Mode.MESSAGE);
			// 3、头部消息
			MessageFactory factory = MessageFactory.newInstance();
			SOAPMessage message = factory.createMessage();
			SOAPPart soapPart = message.getSOAPPart();
			SOAPEnvelope envelope = soapPart.getEnvelope();
			SOAPHeader soapHeader = envelope.getHeader();
			SOAPHeaderElement headerElement = soapHeader.addHeaderElement(new QName(Constants.NAMESPACE, "license", Constants.NAMESPACE_SP));
			headerElement.setValue("hello world.");
			// 4、创建请求消息体
			SOAPBody soapBody = envelope.getBody();
			SOAPBodyElement bodyElement = soapBody.addBodyElement(new QName(Constants.NAMESPACE, "add", Constants.NAMESPACE_SP));
			bodyElement.addChildElement("a").setValue("5");
			bodyElement.addChildElement("b").setValue("10");
			// 5、发送请求
			SOAPMessage respSoapMessage = dispatch.invoke(message);
			// 6、解析响应
			SOAPBody respSoapBody = respSoapMessage.getSOAPBody();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
