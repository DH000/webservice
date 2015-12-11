package com.lin.umws.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import javax.xml.ws.soap.MTOMFeature;

import org.junit.Test;
import org.w3c.dom.Document;

import com.lin.umws.entity.LicenseType;
import com.lin.umws.entity.User;
import com.lin.umws.exception.UserException;
import com.lin.umws.service.impl.UserServiceImpl;
import com.sun.xml.ws.api.message.Header;
import com.sun.xml.ws.api.message.Headers;
import com.sun.xml.ws.developer.WSBindingProvider;

public class UserServiceTest {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8888/us", new UserServiceImpl());
	}
	
	@Test
	public void addTest(){
		try {
			Service service = Service.create(new URL("http://localhost:8888/us"), new QName("http://service.umws.lin.com/", "UserService", "ns"));
			IUserService userService = service.getPort(IUserService.class);
			userService.add(new User(3, "admin3", "123", 2));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteTest(){
		try {
			Service service = Service.create(new URL("http://localhost:8888/us"), new QName("http://service.umws.lin.com/", "UserService", "ns"));
			IUserService userService = service.getPort(IUserService.class);
			userService.delete(new User(3, "admin3", "123", 2));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void listTest(){
		try {
			Service service = Service.create(new URL("http://localhost:8888/us"), new QName("http://service.umws.lin.com/", "UserService", "ns"));
			IUserService userService = service.getPort(IUserService.class);
			List<User> users = userService.list();
			System.out.println(users);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void loginTest(){
		try {
			Service service = Service.create(new URL("http://localhost:8888/us"), new QName("http://service.umws.lin.com/", "UserService", "ns"));
			IUserService userService = service.getPort(IUserService.class);
			
			JAXBContext cxt = JAXBContext.newInstance(LicenseType.class);
			Marshaller marshaller = cxt.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			LicenseType license = new LicenseType();
			license.setUser(new User(1, "admin1", "123", 1));
			
			JAXBElement<LicenseType> jxe = new JAXBElement<LicenseType>(new QName("http://service.umws.lin.com/", "licenseType"), LicenseType.class, license);
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			marshaller.marshal(jxe, doc);
			
			// 加header
			Header header = Headers.create(doc.getDocumentElement());
			((WSBindingProvider) userService).setOutboundHeaders(header);
			User user = userService.login("admin3", "123");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (PropertyException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void badUploadTest(){
		try {
			Service service = Service.create(new URL("http://localhost:8888/us"), new QName("http://service.umws.lin.com/", "UserService", "ns"));
			IUserService userService = service.getPort(IUserService.class);
			
			InputStream is = this.getClass().getResourceAsStream("UserServiceTest.class");
			byte[] file = new byte[is.available()];
			is.read(file);
			userService.badUpload(file);
			is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
