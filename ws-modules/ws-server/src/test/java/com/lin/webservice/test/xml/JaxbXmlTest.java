package com.lin.webservice.test.xml;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import com.lin.webservice.service.bean.User;

public class JaxbXmlTest {
	
	@Test
	public void obj2xml(){
		try {
			JAXBContext cxt = JAXBContext.newInstance(User.class);
			Marshaller marshaller = cxt.createMarshaller();
			marshaller.marshal(new User("hello", "123"), System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void xml2obj(){
		try {
			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><user><id>0</id><password>123</password><username>hello</username></user>";
			JAXBContext cxt = JAXBContext.newInstance(User.class);
			Unmarshaller um = cxt.createUnmarshaller();
			User user = (User) um.unmarshal(new StringReader(xml));
			System.out.println(user.getUsername() + ", " + user.getPassword());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
}
