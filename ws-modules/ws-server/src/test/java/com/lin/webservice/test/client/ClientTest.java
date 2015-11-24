package com.lin.webservice.test.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Test;

import com.lin.webservice.service.ArithmeticService;
import com.lin.webservice.test.Constants;

/**
 * 
 * desc:   客户端测试
 * @author xuelin
 * @date   Nov 11, 2015
 */
public class ClientTest {
	
	@Test
	public void arithmeticAddTest() throws MalformedURLException{
		QName qName = new QName("http://impl.service.webservice.lin.com/", "ArithmeticServiceImplService");
		Service service = Service.create(new URL(Constants.PUBLISH_URL), qName);
		ArithmeticService arithmeticService = service.getPort(ArithmeticService.class);
		arithmeticService.add(1, 2);
	}
	
	@Test
	public void myTestServiceTest() throws MalformedURLException{
		QName qName = new QName("http://test1.service.webservice.lin.com/", "MyTestServiceImplService");
		Service service = Service.create(new URL(Constants.PUBLISH_URL), qName);
	}
	
}
